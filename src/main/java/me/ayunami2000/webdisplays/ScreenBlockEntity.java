package me.ayunami2000.webdisplays;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ScreenBlockEntity extends BlockEntity {
    public ScreenBlockEntity(BlockPos pos, BlockState state) {
        super(Main.SCREEN_BLOCK_ENTITY, pos, state);
    }
}