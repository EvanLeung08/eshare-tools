package com.eshare.tools.archive;

import java.io.File;
import java.io.IOException;

public class ZipProgram {

    private static final String OUTPUT_DIRECTORY = "/tmp";
    private static final String TAR_GZIP_SUFFIX = ".zip";

    private static final String OUTPUT_RESOURCES = "/output-resources";
    private static final String RECURSIVE_DIRECTORY = "/output-recursive-directory";

    private static final String MULTIPLE_RESOURCES_PATH = OUTPUT_DIRECTORY + OUTPUT_RESOURCES + TAR_GZIP_SUFFIX;
    private static final String RECURSIVE_DIRECTORY_PATH = OUTPUT_DIRECTORY + RECURSIVE_DIRECTORY + TAR_GZIP_SUFFIX;


    public static void main(String... args) throws IOException {

        // class for resource classloading
        Class clazz = ZipProgram.class;

        // get multiple resources files to compress
        File resource1 = new File(clazz.getResource("/in/file1.txt").getFile());
        File resource2 = new File(clazz.getResource("/in/file2.txt").getFile());
        File resource3 = new File(clazz.getResource("/in/file3.txt").getFile());

        // compress multiple resources
        ZipUtil.compress(MULTIPLE_RESOURCES_PATH, resource1, resource2, resource3);

        // decompress multiple resources
        ZipUtil.decompress(MULTIPLE_RESOURCES_PATH, new File(OUTPUT_DIRECTORY + OUTPUT_RESOURCES));



        // get directory file to compress
        File directory = new File(clazz.getResource("/in/dir").getFile());

        // compress recursive directory
        ZipUtil.compress(RECURSIVE_DIRECTORY_PATH, directory);

        // decompress recursive directory
        ZipUtil.decompress(RECURSIVE_DIRECTORY_PATH, new File(OUTPUT_DIRECTORY + RECURSIVE_DIRECTORY));
    }
}