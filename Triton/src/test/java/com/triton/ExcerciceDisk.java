package com.triton;

import java.io.File;

import org.junit.Test;

public class ExcerciceDisk extends AbstractExcercice {
    private final String fileTest = "c:\\";
    private final long spaceTest = 230071632352L;

    @Test
    public final void testFreeDiskSpace() {
        StringBuilder sb = new StringBuilder();

        File[] roots = File.listRoots();
        for (File root : roots) {
            sb.append("File system root: " + root.getAbsolutePath()).append(NEW_LINE);
            sb.append("Total space (bytes): " + root.getTotalSpace()).append(NEW_LINE);
            sb.append("Free space (bytes): " + root.getFreeSpace()).append(NEW_LINE);
            sb.append("Usable space (bytes): " + root.getUsableSpace()).append(NEW_LINE);

            sb.append(NEW_LINE);
        }

        LOG.info(sb.toString());

        sb = new StringBuilder();
        File file = new File(fileTest);
        sb.append("File : ").append(fileTest).append(NEW_LINE);
        sb.append("Space test : ").append(spaceTest).append(NEW_LINE);
        boolean boEnoughFreeSpace = isEnoughFreeSpace(file, spaceTest);
        sb.append("enough : ").append(boEnoughFreeSpace).append(NEW_LINE);

        LOG.info(sb.toString());
    }

    private boolean isEnoughFreeSpace(final File file, final long nbBytes) {
        return file.getFreeSpace() > nbBytes;
    }
}
