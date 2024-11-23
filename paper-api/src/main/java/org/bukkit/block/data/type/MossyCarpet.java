package org.bukkit.block.data.type;

import org.bukkit.MinecraftExperimental;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * This class encompasses the 'north', 'east', 'south', 'west', height flags
 * which are used to set the height of a face.
 *
 * 'bottom' denotes whether this is a bottom block.
 */
@ApiStatus.Experimental
@MinecraftExperimental(MinecraftExperimental.Requires.WINTER_DROP)
public interface MossyCarpet extends BlockData {

    /**
     * Gets the value of the 'bottom' property.
     *
     * @return the 'bottom' value
     */
    boolean isBottom();

    /**
     * Sets the value of the 'bottom' property.
     *
     * @param bottom the new 'bottom' value
     */
    void setBottom(boolean bottom);

    /**
     * Gets the height of the specified face.
     *
     * @param face to check
     * @return if face is enabled
     */
    @NotNull
    Height getHeight(@NotNull BlockFace face);

    /**
     * Set the height of the specified face.
     *
     * @param face to set
     * @param height the height
     */
    void setHeight(@NotNull BlockFace face, @NotNull Height height);

    /**
     * The different heights a face may have.
     */
    public enum Height {
        /**
         * Not present.
         */
        NONE,
        /**
         * Low face present.
         */
        LOW,
        /**
         * Tall face present.
         */
        TALL;
    }
}