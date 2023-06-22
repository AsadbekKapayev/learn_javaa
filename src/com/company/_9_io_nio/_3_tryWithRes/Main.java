package com.company._9_io_nio._3_tryWithRes;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        try (var reader = new FileReader("src/com/company/_9_io_nio/_3_tryWithRes/test.txt")) {

            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char)character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
