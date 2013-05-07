package com.triton;

import java.io.File;

import org.junit.Test;

/**
 * The Class ExcerciceDisk.
 * 
 * @author Stephane
 * @since 2013
 */
public class ExcerciceDisk extends AbstractExcercice {

    /** The root directory to test. */
    private final String fileTest = "c:\\";

    /** The free space to test. */
    private final long spaceTest = 230071632352L;

    /**
     * Show free disk space on all root file available.
     */
    @Test
    public final void showFreeDiskSpace() {
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
    }

    /**
     * Test free disk space on sample directory.
     */
    @Test
    public final void testFreeDiskSpace() {
        StringBuilder sb = new StringBuilder();

        File file = new File(fileTest);
        sb.append("File : ").append(fileTest).append(NEW_LINE);
        sb.append("Space test : ").append(spaceTest).append(NEW_LINE);
        boolean boEnoughFreeSpace = isEnoughFreeSpace(file, spaceTest);
        sb.append("enough : ").append(boEnoughFreeSpace).append(NEW_LINE);

        LOG.info(sb.toString());
    }

    /**
     * Checks if is enough free space.
     * 
     * @param file
     *            the file
     * @param nbBytes
     *            the nb bytes
     * @return true, if is enough free space
     */
    private boolean isEnoughFreeSpace(final File file, final long nbBytes) {
        return file.getFreeSpace() > nbBytes;
    }
}
