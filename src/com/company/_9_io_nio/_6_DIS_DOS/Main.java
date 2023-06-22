package com.company._9_io_nio._6_DIS_DOS;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (var fw = new DataOutputStream(new FileOutputStream("/home/akapayev/IdeaProjects/LearnJava/src/com/company/_9_io_nio/_6_DIS_DOS/test.bin"))) {

            fw.writeInt(1);
            fw.writeUTF("HJe");
            fw.writeLong(500_000_000);
            fw.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
