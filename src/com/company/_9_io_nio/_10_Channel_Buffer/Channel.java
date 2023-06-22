package com.company._9_io_nio._10_Channel_Buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel {

    public static void main(String[] args) {

        try (var random = new RandomAccessFile("src/com/company/_9_io_nio/_10_Channel_Buffer/test.txt", "rw");
             FileChannel channel = random.getChannel()) {

            StringBuilder builder = new StringBuilder();
            ByteBuffer buffer = ByteBuffer.allocate(2);

            int byteRead = channel.read(buffer);

            while (byteRead > 0) {
                System.out.println(byteRead);

                buffer.flip();

                while (buffer.hasRemaining()) {
                    builder.append((char) buffer.get());
                }

                buffer.clear();
                byteRead = channel.read(buffer);
            }

            System.out.println(builder);

            String text = "\nThere are only two ways to live your life. " +
                    "One is as though nothing is a miracle. The other is as " +
                    "though everything is a miracle.";

//            ByteBuffer buffer2 = ByteBuffer.allocate(text.length());
//            buffer2.put(text.getBytes());
//            buffer2.flip();

            ByteBuffer buffer2 = ByteBuffer.wrap(text.getBytes());

            channel.write(buffer2);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
