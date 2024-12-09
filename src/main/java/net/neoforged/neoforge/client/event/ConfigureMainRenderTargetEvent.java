/*
 * Copyright (c) NeoForged and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.pipeline.MainTarget;
import com.mojang.blaze3d.pipeline.RenderTarget;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.event.IModBusEvent;
import org.jetbrains.annotations.ApiStatus;

/**
 * Fired when configuring the main {@linkplain RenderTarget render target}.
 * <p>
 * This event fires during startup when the {@link MainTarget} is constructed.
 * <p>
 * This event is not {@linkplain ICancellableEvent cancellable}.
 * <p>
 * This event is fired on the mod-speciffic event bus, only on the {@linkplain LogicalSide#CLIENT logical client}.
 */
public class ConfigureMainRenderTargetEvent extends Event implements IModBusEvent {
    private final boolean useDepth;
    private boolean useStencil;

    private final int width;
    private final int height;

    @ApiStatus.Internal
    public ConfigureMainRenderTargetEvent(boolean useDepth, int width, int height) {
        this.useDepth = useDepth;
        this.useStencil = false;

        this.width = width;
        this.height = height;
    }

    /**
     * Returns whether the depth buffer is enabled.
     *
     * @return <code>true</code>, if the depth buffer is enabled, or <code>false</code> otherwise.
     */
    public boolean useDepth() {
        return this.useDepth;
    }

    /**
     * Returns whether the stencil buffer is enabled.
     *
     * @return <code>true</code>, if the stencil buffer is enabled, or <code>false</code> otherwise.
     */
    public boolean useStencil() {
        return this.useStencil;
    }

    /**
     * Returns the preferred width of the framebuffer.
     *
     * @return The width, in pixels, to attempt to use for the framebuffer.
     */
    public int width() {
        return this.width;
    }

    /**
     * Returns the preferred height of the framebuffer.
     *
     * @return The height, in pixels, to attempt to use for the framebuffer.
     */
    public int height() {
        return this.height;
    }

    /**
     * Enable the stencil buffer for the main render target.
     *
     * @return <code>this</code>, for method chaining.
     */
    public ConfigureMainRenderTargetEvent enableStencil() {
        this.useStencil = true;
        return this;
    }
}
