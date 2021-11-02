package me.ayunami2000.webdisplays;

public class ScreenBlockEntityRenderer extends BlockEntityRenderer<DemoBlockEntity> {
    // A jukebox itemstack
    private static ItemStack stack = new ItemStack(Items.JUKEBOX, 1);

    public DemoBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(DemoBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
    }
}