package com.mohistmc.luyten;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author Mgazul by MohistMC
 * @date 2023/4/13 23:39:14
 */
public enum Decompiler {
    PROCYON(ProcyonLinkProvider::new),
    CFR(CFRLinkProvider::new),
    Quiltflower(QuiltflowerLinkProvider::new);

    public static final Decompiler[] VALUES = values();

    public final Supplier<LinkProvider> linkProviderSupplier;

    Decompiler(Supplier<LinkProvider> linkProviderSupplier) {
        this.linkProviderSupplier = linkProviderSupplier;
    }

    public static Decompiler getDecompiler(final String s) {
        return Arrays.stream(VALUES)
                .filter(decompiler -> decompiler.name().equalsIgnoreCase(s))
                .findFirst().orElse(null);
    }

}