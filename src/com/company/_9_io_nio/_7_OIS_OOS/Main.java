package com.company._9_io_nio._7_OIS_OOS;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (var fw = new ObjectOutputStream(new FileOutputStream("src/com/company/_9_io_nio/_7_OIS_OOS/test.bin"))) {

            fw.writeObject(List.of(1, 2, 3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
