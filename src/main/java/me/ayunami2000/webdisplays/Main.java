package me.ayunami2000.webdisplays;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("webdisplays");

	public static final Block SCREEN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

	public static BlockEntityType<ScreenBlockEntity> SCREEN_BLOCK_ENTITY;

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("webdisplays", "screen_block"), SCREEN_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("webdisplays", "screen_block"), new BlockItem(SCREEN_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));
		SCREEN_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "webdisplays:screen_block_entity", FabricBlockEntityTypeBuilder.create(ScreenBlockEntity::new, SCREEN_BLOCK).build(null));
		LOGGER.info("fard");
	}
}
