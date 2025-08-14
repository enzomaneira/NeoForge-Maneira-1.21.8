package net.maneira.maneiramod.block;

import net.maneira.maneiramod.ManeiraMod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.maneira.maneiramod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ManeiraMod.MOD_ID);


    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            (properties) -> new RotatedPillarBlock(properties
                    .strength(0.5f).sound(SoundType.AMETHYST)));


    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock("bismuth_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(2, 4),
                    properties.strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE = registerBlock("bismuth_deepslate_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(3, 6),
                    properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));





    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register((eventBus));
    }
}
