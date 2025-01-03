package org.bukkit.craftbukkit.inventory;

import com.google.common.base.Joiner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.junit.jupiter.params.provider.Arguments;

public class ItemStackEnchantStorageTest extends ItemStackTest {

    public static Stream<Arguments> data() {
        return StackProvider.compound(ItemStackEnchantStorageTest.operators(), "%s %s", NAME_PARAMETER, Material.ENCHANTED_BOOK);
    }

    @SuppressWarnings("unchecked")
    static List<Object[]> operators() {
        return CompoundOperator.compound(
            Joiner.on('+'),
            NAME_PARAMETER,
            Long.parseLong("10", 2),
            ItemStackLoreEnchantmentTest.operators(),
            Arrays.asList(
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) cleanStack.getItemMeta();
                            meta.addStoredEnchant(Enchantment.UNBREAKING, 1, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) cleanStack.getItemMeta();
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Enchantable vs Blank"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) cleanStack.getItemMeta();
                            meta.addStoredEnchant(Enchantment.KNOCKBACK, 1, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            return cleanStack;
                        }
                    },
                    "Enchantable vs Null"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) cleanStack.getItemMeta();
                            meta.addStoredEnchant(Enchantment.SMITE, 1, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) cleanStack.getItemMeta();
                            meta.addStoredEnchant(Enchantment.SMITE, 1, true);
                            meta.addStoredEnchant(Enchantment.FIRE_ASPECT, 1, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Enchantable vs More"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) cleanStack.getItemMeta();
                            meta.addStoredEnchant(Enchantment.FIRE_PROTECTION, 1, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) cleanStack.getItemMeta();
                            meta.addEnchant(Enchantment.FIRE_PROTECTION, 2, true);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Enchantable vs Other"
                }
            )
        );
    }
}
