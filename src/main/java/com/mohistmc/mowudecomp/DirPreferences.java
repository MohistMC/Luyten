package com.mohistmc.mowudecomp;

import javax.swing.JFileChooser;
import java.io.File;

class DirPreferences {

    private final MoWuDecompPreferences luytenPrefs;

    public DirPreferences(MoWuDecompPreferences luytenPrefs) {
        this.luytenPrefs = luytenPrefs;
    }

    void retrieveOpenDialogDir(JFileChooser fc) {
        try {
            String currentDirStr = luytenPrefs.getFileOpenCurrentDirectory();
            if (currentDirStr != null && currentDirStr.trim().length() > 0) {
                File currentDir = new File(currentDirStr);
                if (currentDir.exists() && currentDir.isDirectory()) {
                    fc.setCurrentDirectory(currentDir);
                }
            }
        } catch (Exception e) {
            MoWuDecomp.showExceptionDialog("Exception!", e);
        }
    }

    void saveOpenDialogDir(JFileChooser fc) {
        try {
            File currentDir = fc.getCurrentDirectory();
            if (currentDir != null && currentDir.exists() && currentDir.isDirectory()) {
                luytenPrefs.setFileOpenCurrentDirectory(currentDir.getAbsolutePath());
            }
        } catch (Exception e) {
            MoWuDecomp.showExceptionDialog("Exception!", e);
        }
    }

    void retrieveSaveDialogDir(JFileChooser fc) {
        try {
            String currentDirStr = luytenPrefs.getFileSaveCurrentDirectory();
            if (currentDirStr != null && currentDirStr.trim().length() > 0) {
                File currentDir = new File(currentDirStr);
                if (currentDir.exists() && currentDir.isDirectory()) {
                    fc.setCurrentDirectory(currentDir);
                }
            }
        } catch (Exception e) {
            MoWuDecomp.showExceptionDialog("Exception!", e);
        }
    }

    void saveSaveDialogDir(JFileChooser fc) {
        try {
            File currentDir = fc.getCurrentDirectory();
            if (currentDir != null && currentDir.exists() && currentDir.isDirectory()) {
                luytenPrefs.setFileSaveCurrentDirectory(currentDir.getAbsolutePath());
            }
        } catch (Exception e) {
            MoWuDecomp.showExceptionDialog("Exception!", e);
        }
    }

}
