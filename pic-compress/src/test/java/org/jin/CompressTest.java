package org.jin;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class CompressTest {

    @Test
    public void test_compress() throws IOException {
        File[] files = new File("./src/test/resources/origin").listFiles();
        File des = new File("./src/test/resources/compressed");
        System.out.println(files);
        Thumbnails.of(files)
                .scale(0.5)
                .outputFormat("png")
                .toFiles(des, Rename.NO_CHANGE);
    }
}
