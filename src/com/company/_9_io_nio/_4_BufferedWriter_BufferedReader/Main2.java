package com.company._9_io_nio._4_BufferedWriter_BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main2 {

    public static void main(String[] args) {
        try (var reader = new BufferedReader(new FileReader("src/com/company/_9_io_nio/_4_BufferedWriter_BufferedReader/test.txt"))) {

            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char)character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
