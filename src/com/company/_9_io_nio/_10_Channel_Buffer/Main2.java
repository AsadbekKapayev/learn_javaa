package com.company._9_io_nio._10_Channel_Buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class Main2 {

    public static void main(String[] args) {
        try (var random = new RandomAccessFile("src/com/company/_9_io_nio/_10_Channel_Buffer/test.txt", "rw");
             var channel = random.getChannel()) {

            var buffer = ByteBuffer.allocate(5);
            channel.read(buffer);
            buffer.flip();

            System.out.println((char) buffer.get());

            buffer.mark();

            System.out.println((char) buffer.get());
            System.out.println((char) buffer.get());

            buffer.reset();
            System.out.println((char) buffer.get());

            buffer.rewind();

            System.out.println((char) buffer.get());

            buffer.flip();
            buffer.compact();

            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }

            buffer.clear();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
