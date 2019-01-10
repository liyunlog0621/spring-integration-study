package com.lyl.springbatchintegration.edabatch;

import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * ClassName Utils
 *
 * @Author liyunlong
 * Data 下午 4:00
 * Version 1.0
 **/
abstract class Utils {
    static void mv(File in, File out) {
        try {
            Assert.isTrue(out.exists() || out.mkdirs());
            File target = new File(out, in.getName());
            java.nio.file.Files.copy(in.toPath(), target.toPath(), REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
