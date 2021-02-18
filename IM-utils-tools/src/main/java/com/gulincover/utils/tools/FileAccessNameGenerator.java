package com.gulincover.utils.tools;

import java.util.UUID;

public class FileAccessNameGenerator {
    public static String creator() {
        return UUID.randomUUID().toString().substring(4, 28);
    }
}
