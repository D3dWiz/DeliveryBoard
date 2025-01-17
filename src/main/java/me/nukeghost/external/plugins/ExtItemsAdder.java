package me.nukeghost.external.plugins;

import dev.lone.itemsadder.api.CustomStack;
import me.nukeghost.external.ItemPlugin;
import org.bukkit.inventory.ItemStack;

public class ExtItemsAdder extends ItemPlugin {
    @Override
    public String getName() {
        return "ItemsAdder";
    }

    @Override
    public ItemStack generateItem(String itemID, String itemType) {
        CustomStack stack = CustomStack.getInstance(itemID);
        if(stack != null)
        {
            ItemStack itemStack = stack.getItemStack();
            return itemStack;
        }
        return null;
    }

    @Override
    public String generateItemString(ItemStack itemStack) {
        CustomStack stack = CustomStack.byItemStack(itemStack);

        if(stack != null) {
            //IA Custom Item
            String itemString = "iad@" + stack.getNamespacedID() + "@1";
            return itemString;
        }
        return null;
    }

    @Override
    public boolean isMatching(ItemStack generatedItem, ItemStack submittedItem) {

        CustomStack subStack = CustomStack.byItemStack(submittedItem);
        CustomStack genStack = CustomStack.byItemStack(generatedItem);

        try {
            if (CustomStack.isInRegistry(subStack.getNamespacedID())) {
                if (genStack.matchNamespacedID(subStack)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
