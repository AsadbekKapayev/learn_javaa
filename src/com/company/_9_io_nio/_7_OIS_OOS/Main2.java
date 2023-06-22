package com.company._9_io_nio._7_OIS_OOS;

import java.io.*;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        try (var fw = new ObjectInputStream(new FileInputStream("src/com/company/_9_io_nio/_7_OIS_OOS/test.bin"))) {

            var object = (List<String>) fw.readObject();

            System.out.println(object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
