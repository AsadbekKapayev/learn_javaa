package com.company._9_io_nio._2_FileReader;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader reader = null;

        try {
            reader = new FileReader("src/com/company/_9_io_nio/_2_FileReader/test.txt");
            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char)character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

}
