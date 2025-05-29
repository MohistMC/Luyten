package com.mohistmc.mowudecomp;

import com.strobel.assembler.InputTypeLoader;
import com.strobel.assembler.metadata.Buffer;
import com.strobel.assembler.metadata.ITypeLoader;

import java.util.ArrayList;
import java.util.List;

public final class MoWuDecompTypeLoader implements ITypeLoader {
    private final List<ITypeLoader> _typeLoaders;

    public MoWuDecompTypeLoader() {
        _typeLoaders = new ArrayList<>();
        _typeLoaders.add(new InputTypeLoader());
    }

    public List<ITypeLoader> getTypeLoaders() {
        return _typeLoaders;
    }

    @Override
    public boolean tryLoadType(final String internalName, final Buffer buffer) {
        for (final ITypeLoader typeLoader : _typeLoaders) {
            if (typeLoader.tryLoadType(internalName, buffer)) {
                return true;
            }

            buffer.reset();
        }

        return false;
    }
}