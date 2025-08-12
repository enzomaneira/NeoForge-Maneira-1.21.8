package net.maneira.maneiramod.item;

import net.maneira.maneiramod.ManeiraMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ManeiraMod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.registerItem("bismuth",
            Item::new, new Item.Properties());

    public static void register(IEventBus eventBus) {
        System.out.println("CARALHOOOOO!");
        ITEMS.register(eventBus);
    }
}
