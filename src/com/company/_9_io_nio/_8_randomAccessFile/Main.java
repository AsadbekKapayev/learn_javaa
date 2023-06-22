package com.company._9_io_nio._8_randomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) {

        try (var random = new RandomAccessFile("src/com/company/_9_io_nio/_8_randomAccessFile/test.txt", "rw")) {

            var v = random.read();
            System.out.println(v);

            var l = random.readLine();
            System.out.println(l);

            random.seek(53);
            var l2 = random.readLine();
            System.out.println(l2);

            var p = random.getFilePointer();
            System.out.println(p);

            random.writeBytes("Iam not bot!!!!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
