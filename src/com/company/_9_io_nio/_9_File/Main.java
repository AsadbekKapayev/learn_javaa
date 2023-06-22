package com.company._9_io_nio._9_File;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        var f1 = new File("C:\\Users\\asadb\\IdeaProjects\\learn_javaa\\src\\com\\company\\_9_io_nio\\_9_File\\dir");
        var f2 = new File("src/com/company/_9_io_nio/_9_File/dir/test.txt");
        var f3 = new File("src/com/company/_9_io_nio/_9_File/dir/test2.txt");
        var f4 = new File("src/com/company/_9_io_nio/_9_File/dir2");

        System.out.println("dir absolute - " + f1.getAbsolutePath());
        System.out.println("file absolute - " + f2.getAbsolutePath());

        System.out.println("-----------");

        System.out.println("dir is absolute - " + f1.isAbsolute());
        System.out.println("file is absolute - " + f2.isAbsolute());

        System.out.println("-----------");

        System.out.println("dir is directory - " + f1.isDirectory());
        System.out.println("file is directory - " + f2.isDirectory());

        System.out.println("-----------");

        System.out.println("dir is exists - " + f1.exists());
        System.out.println("file is exists - " + f2.exists());

        System.out.println("-----------");

        System.out.println("dir is length() - " + f1.length());
        System.out.println("file is length() - " + f2.length());

        System.out.println("-----------");

        System.out.println("file is create new file() - " + f3.createNewFile());
        System.out.println("dir is mkdir() - " + f4.mkdir());

        System.out.println("-----------");

        System.out.println("file is delete() - " + f3.delete());
//        System.out.println("dir is delete() - " + f4.delete());

        System.out.println("files - " + Arrays.toString(f1.listFiles()));

    }

}
