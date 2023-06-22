package com.company._9_io_nio._7_OIS_OOS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {
        try (var s = new ObjectInputStream(new FileInputStream("src/com/company/_9_io_nio/_7_OIS_OOS/test2.bin"))) {

            var result = (List<User>) s.readObject();

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
