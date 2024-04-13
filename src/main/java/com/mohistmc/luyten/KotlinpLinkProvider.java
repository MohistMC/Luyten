package com.mohistmc.luyten;

import com.strobel.assembler.metadata.TypeDefinition;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.kotlin.kotlinp.Kotlinp;
import org.jetbrains.kotlin.kotlinp.KotlinpException;
import org.jetbrains.kotlin.kotlinp.KotlinpSettings;

import java.io.File;
import java.util.Map;
import java.util.Set;

public class KotlinpLinkProvider implements LinkProvider {

    private static final String[] ARGS = {"-verbose"};

    private String content;

    private TypeDefinition type;
    private byte[] bytecode;

    @Override
    public String getTextContent() {
        return content;
    }
    
    @Override
    public void setType(TypeDefinition type, Model model) {
        this.type = type;
        this.bytecode = ProcyonUtils.getContent(type, model);
    }
    
    @Override
    public void generateContent() {
        Kotlinp kotlinp = new Kotlinp(new KotlinpSettings(true));
        File singletonJar = ProcyonUtils.createSingletonTempJar(type.getInternalName() + ".class", bytecode);

        String var10 = FilesKt.getExtension(singletonJar);
        if (Intrinsics.areEqual(var10, "class")) {
            content = kotlinp.renderClassFile$kotlinp(kotlinp.readClassFile$kotlinp(singletonJar));
        } else {
            if (!Intrinsics.areEqual(var10, "kotlin_module")) {
                throw new KotlinpException("only .class and .kotlin_module files are supported");
            }

            content = kotlinp.renderModuleFile$kotlinp(kotlinp.readModuleFile$kotlinp(singletonJar));
        }
    }
    
    @Override
    public void processLinks() {
    
    }
    
    @Override
    public Map<String, Selection> getDefinitionToSelectionMap() {
        return null;
    }
    
    @Override
    public Map<String, Set<Selection>> getReferenceToSelectionsMap() {
        return null;
    }
    
    @Override
    public boolean isLinkNavigable(String uniqueStr) {
        return false;
    }
    
    @Override
    public String getLinkDescription(String uniqueStr) {
        return null;
    }
}
