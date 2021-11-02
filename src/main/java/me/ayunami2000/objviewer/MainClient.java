package me.ayunami2000.objviewer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.util.tinyfd.TinyFileDialogs;

import java.io.File;

import static me.ayunami2000.objviewer.Main.SCREEN_BLOCK_ENTITY;

public class MainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(SCREEN_BLOCK_ENTITY, ScreenBlockEntityRenderer::new);
    }

    public static File chooseFile(String filter, String filterName){
        return chooseFile(new String[]{filter},filterName);
    }
    public static File chooseFile(String[] filters,String filterName){
        File fileResult=showOpenFileDialog("Select File to Open",MinecraftClient.getInstance().runDirectory,filterName,filters);
        return fileResult;
    }
    //originally from LWJGUI at https://github.com/orange451/LWJGUI
    private static File showOpenFileDialog(String title, File defaultPath, String filterDescription, String[] acceptedFileExtensions){

        MemoryStack stack = MemoryStack.stackPush();

        PointerBuffer filters = stack.mallocPointer(acceptedFileExtensions.length);

        for(int i = 0; i < acceptedFileExtensions.length; i++){
            filters.put(stack.UTF8("*." + acceptedFileExtensions[i]));
        }

        filters.flip();

        defaultPath = defaultPath.getAbsoluteFile();
        String defaultString = defaultPath.getAbsolutePath();
        if(defaultPath.isDirectory() && !defaultString.endsWith(File.separator)){
            defaultString += File.separator;
        }

        String result = TinyFileDialogs.tinyfd_openFileDialog(title, defaultString, filters, filterDescription, false);

        stack.pop();

        return result != null ? new File(result) : null;
    }
    public static File saveFile(String ext,String desc){
        return showSaveFileDialog("Save file as...", MinecraftClient.getInstance().runDirectory,desc,ext,true);
    }
    public static File showSaveFileDialog(String title, File defaultPath, String filterDescription, String fileExtension, boolean forceExtension){

        MemoryStack stack = MemoryStack.stackPush();

        PointerBuffer filters = stack.mallocPointer(1);

        filters.put(stack.UTF8("*." + fileExtension)).flip();

        defaultPath = defaultPath.getAbsoluteFile();
        String defaultString = defaultPath.getAbsolutePath();
        if(defaultPath.isDirectory() && !defaultString.endsWith(File.separator)){
            defaultString += File.separator;
        }

        String result = TinyFileDialogs.tinyfd_saveFileDialog(title, defaultString, filters, filterDescription);

        stack.pop();

        if(result == null){
            return null;
        }

        if(forceExtension && !result.endsWith("." + fileExtension)){
            result += "." + fileExtension;
        }

        return new File(result);
    }
}
