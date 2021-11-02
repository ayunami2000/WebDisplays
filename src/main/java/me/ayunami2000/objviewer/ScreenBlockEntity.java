package me.ayunami2000.objviewer;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.io.File;
import java.io.FileNotFoundException;

public class ScreenBlockEntity extends BlockEntity {
    public static OBJLoader objLoader = null;
    public static Obj obj = null;

    public ScreenBlockEntity(BlockPos pos, BlockState state) {
        super(Main.SCREEN_BLOCK_ENTITY, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, ScreenBlockEntity be) {
        //bruh
        if(objLoader==null){
            objLoader=new OBJLoader();
            File objFile = MainClient.chooseFile("obj", "OBJ files");
            Obj tempObj = null;
            if (objFile!=null) {
                try {
                    tempObj=objLoader.loadModel(objFile);
                    obj=tempObj;
                } catch (FileNotFoundException e) {
                    //invalid file
                }
            }else{
                //no file selected
            }
        }
    }
}