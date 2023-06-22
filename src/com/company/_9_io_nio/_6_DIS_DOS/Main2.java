package com.company._9_io_nio._6_DIS_DOS;

import java.io.*;

public class Main2 {

    public static void main(String[] args) {
        try (var reader = new DataInputStream(new FileInputStream("/home/akapayev/IdeaProjects/LearnJava/src/com/company/_9_io_nio/_6_DIS_DOS/test.bin"))) {

            System.out.println(reader.readInt());
            System.out.println(reader.readUTF());
            System.out.println(reader.readLong());
            System.out.println(reader.readBoolean());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
