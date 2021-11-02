package me.ayunami2000.objviewer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

import java.io.File;
import java.io.FileNotFoundException;

import static me.ayunami2000.objviewer.Main.screenBlockIdentifier;

public class ScreenBlockEntityRenderer implements BlockEntityRenderer<ScreenBlockEntity> {
    //private static ItemStack stack = new ItemStack(Registry.ITEM.get(screenBlockIdentifier), 1);

    public ScreenBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        //lol
    }

    @Override
    public void render(ScreenBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if(blockEntity.obj!=null){
            matrices.push();
            //do stuff here
            blockEntity.objLoader.render(blockEntity.obj);
            matrices.pop();
        }
        //matrices.push();


        /*
        // Calculate the current offset in the y value
        double offset = Math.sin((blockEntity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        // Move the item
        matrices.translate(0.5, 1.25 + offset, 0.5);

        // Rotate the item
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((blockEntity.getWorld().getTime() + tickDelta) * 4));


        int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);//seed??!?!?!?
        */


        // Mandatory call after GL calls
        //matrices.pop();
    }
}