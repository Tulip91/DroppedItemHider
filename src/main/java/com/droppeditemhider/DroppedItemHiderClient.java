package com.droppeditemhider;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DroppedItemHiderClient implements ClientModInitializer {
    public static boolean hideDroppedItems = true;

    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("dropped-item-hider.txt");
    private static KeyBinding toggleKey;

    @Override
    public void onInitializeClient() {
        loadConfig();

        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.dropped-item-hider.toggle",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_K,
            "category.dropped-item-hider"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleKey.wasPressed()) {
                hideDroppedItems = !hideDroppedItems;
                saveConfig();
                if (client.player != null) {
                    client.player.sendMessage(Text.literal("Dropped item rendering: " + (hideDroppedItems ? "hidden" : "visible")), true);
                }
            }
        });
    }

    private static void loadConfig() {
        try {
            if (Files.exists(CONFIG_PATH)) {
                hideDroppedItems = Boolean.parseBoolean(Files.readString(CONFIG_PATH).trim());
            }
        } catch (IOException ignored) {
        }
    }

    private static void saveConfig() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            Files.writeString(CONFIG_PATH, Boolean.toString(hideDroppedItems));
        } catch (IOException ignored) {
        }
    }
}
