package com.gulincover.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@SpringBootTest
public class TestMain {
    @Test
    public void test() throws IOException {
        String packageName = "com.gulincover.api.entry";
        List<Class<?>> classes = getClasses(packageName);

        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\12086\\Desktop\\creator.sql"));
        bw.write("use internetmemory;\n");
        for (Class<?> clazz : classes) {
            bw.write(createTable(clazz));
        }
        bw.close();

        System.out.println();
    }

    public static String createTable(Class<?> clazz) {
        StringBuilder sss = new StringBuilder();
        sss.append("create table ")
                .append(upperToUnderscore(clazz.getSimpleName()).substring(1))
                .append(" (");

        String tmplate = "";
        for (Field field : clazz.getFields()) {
            for (String s : field.toGenericString().split(" ")) {
                System.out.println(s);
                if ("public".equals(s)) continue;
                if ("private".equals(s)) continue;
                String[] ss = s.split("\\.");
                String tmps = ss[ss.length - 1];
                if ("Date".equals(tmps)) continue;

                if ("Integer".equals(tmps)) {
                    tmplate = " int,";
                    continue;
                }

                if ("Long".equals(tmps)) {
                    tmplate = " bigint,";
                    continue;
                }

                if ("String".equals(tmps)) {
                    tmplate = " varchar(256),";
                    continue;
                }

                if ("createDate".equals(tmps)) {
                    sss.append("create_date datetime DEFAULT NULL COMMENT 'create time',");
                    continue;
                }

                if ("updateDate".equals(tmps)) {
                    sss.append("update_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update time',");
                    continue;
                }

                if ("version".equals(tmps)) {
                    sss.append("version int default 1,");
                    continue;
                }

                if ("isBlack".equals(tmps)) {
                    sss.append("is_black int default 0");
                    continue;
                }

                sss.append(upperToUnderscore(tmps)).append(tmplate);
            }
        }
        if (sss.toString().endsWith(",")) {
            sss.deleteCharAt(sss.length() - 1);
        }

        sss.append(");")
                .append("\n");
        return sss.toString();
    }

    public static String upperToUnderscore(String src) {
        StringBuilder ret = new StringBuilder();
        for (char c : src.toCharArray()) {
            if ((c & 0b00100000) == 0) {
                c = (char) (c | 0b00100000);
                ret.append("_");
            }
            ret.append(c);
        }
        return ret.toString();
    }

    public static List<Class<?>> getClasses(String packageName) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String packageDirName = packageName.replace(".", "/");
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findAndAddClassesInPackageByFile(packageName, filePath, false, classes);
                } else if ("jar".equals(protocol)) {
                    System.out.println("jar");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classes;
    }

    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, List<Class<?>> classes) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] dirFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });

        assert dirFiles != null;
        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(Class.forName(packageName + "." + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}










