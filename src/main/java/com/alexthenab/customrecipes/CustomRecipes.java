package com.alexthenab.customrecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomRecipes extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("CustomRecipes enabled");
        addCustomRecipes();
    }

    private void addCustomRecipes() {
        // Recipe 1: Golden Apple from 4 Gold Ingots (sides) + 1 Apple (middle)
        ItemStack goldenApple = new ItemStack(Material.GOLDEN_APPLE);
        NamespacedKey gapKey = new NamespacedKey(this, "custom_golden_apple");
        ShapedRecipe gapRecipe = new ShapedRecipe(gapKey, goldenApple);
        gapRecipe.shape(
                " G ",
                "GAG",
                " G "
        );
        gapRecipe.setIngredient('G', Material.GOLD_INGOT);
        gapRecipe.setIngredient('A', Material.APPLE);
        getServer().addRecipe(gapRecipe);

        // Recipe 2: Cobweb from 9 String (Shapeless)
        ItemStack cobweb = new ItemStack(Material.COBWEB);
        NamespacedKey cobwebKey = new NamespacedKey(this, "custom_cobweb");
        ShapelessRecipe cobwebRecipe = new ShapelessRecipe(cobwebKey, cobweb);
        for (int i = 0; i < 9; i++) {
            cobwebRecipe.addIngredient(Material.STRING);
        }
        getServer().addRecipe(cobwebRecipe);
    }
}
