package me.ayunami2000.webdisplays;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

import static me.ayunami2000.webdisplays.Main.SCREEN_BLOCK_ENTITY;

public class MainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(SCREEN_BLOCK_ENTITY, ScreenBlockEntityRenderer::new);
    }
}