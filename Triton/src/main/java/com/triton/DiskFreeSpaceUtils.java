package com.triton;

import java.io.File;

/**
 * The Class DiskFreeSpaceUtils.
 * 
 * @author Stephane
 * @since 2013
 */
public class DiskFreeSpaceUtils {

    /**
     * Hide Constructor for DiskFreeSpaceUtils utility class.
     */
    private DiskFreeSpaceUtils() {
    }

    /**
     * Gets the free space for a root directory.
     * 
     * @param rootDirectory
     *            the root directory to check
     * @return the free space on this root directory
     */
    public static long getFreeSpace(final File rootDirectory) {
        long freeSpace = 0;

        if (rootDirectory != null && rootDirectory.exists()) {
            freeSpace = rootDirectory.getFreeSpace();
        }

        return freeSpace;
    }

    /**
     * Gets the usable space for a root directory.
     * 
     * @param rootDirectory
     *            the root directory to check
     * @return the usable space on this root directory
     */
    public static long getUsableSpace(final File rootDirectory) {
        long usableSpace = 0;

        if (rootDirectory != null && rootDirectory.exists()) {
            usableSpace = rootDirectory.getUsableSpace();
        }

        return usableSpace;
    }

    /**
     * Checks if there is enough free space available on a root directory.
     * 
     * @param rootDirectory
     *            the root directory to check
     * @param freeSpaceToTest
     *            the free space amount to check
     * @return true, if there is enough free space available on this root directory
     */
    public static boolean isFreeSpaceAvailable(final File rootDirectory, final long freeSpaceToTest) {
        long freeSpace = getFreeSpace(rootDirectory);

        return freeSpace > freeSpaceToTest;
    }
}
