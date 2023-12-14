package com.company._9_io_nio._new;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {

    public static void main(String[] args) {

        var loremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        //region outputStreamWriter
        try (OutputStream outputStream = new FileOutputStream("test.txt"); OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream)) {

            outputStreamWriter.write(loremIpsum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region outputStreamReader
        try (FileInputStream fileInputStream = new FileInputStream("test.txt"); InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream)) {

            int value;

            while ((value = inputStreamReader.read()) != -1) {
                System.out.print((char) value);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nOutputStreamWriter and InputStreamReader\n");
        //endregion

        //region FileWriter
        try (var fileWriter = new FileWriter("test.txt", false)) {
            fileWriter.write(loremIpsum);
            fileWriter.append("\nappend test");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region FileReader
        try (FileReader fileReader = new FileReader("test.txt")) {

            StringBuilder stringBuilder = new StringBuilder();
            int value = -1;

            while ((value = fileReader.read()) != -1) {
                stringBuilder.append((char) value);
            }

            System.out.println(stringBuilder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nfileWriter and FileReader\n");
        //endregion

        //region BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"))) {

            bufferedWriter.write(loremIpsum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"))) {

            int value;

            while ((value = bufferedReader.read()) != -1) {
                System.out.print((char) value);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nBufferedReader and BufferedWriter\n");
        //endregion

        //region CharArrayReader
        char[] charArray = {'a', 'b', 'c'};

        CharArrayReader charArrayReader = new CharArrayReader(charArray);

        try {

            int value;

            while ((value = charArrayReader.read()) != -1) {

                System.out.print((char) value);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region CharArrayWriter
        CharArrayWriter charArrayWriter = new CharArrayWriter();

        try {
            charArrayWriter.write(charArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nCharArrayReader and CharArrayWriter\n");
        //endregion

        //region FileOutputStream
        try (FileOutputStream fileOutputStream = new FileOutputStream("test.txt")) {

            var loremBytes = loremIpsum.getBytes();

            for (int i = 0; i < loremIpsum.length(); i++) {
                fileOutputStream.write(loremBytes[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region FileInputStream
        try (FileInputStream fileInputStream = new FileInputStream("test.txt")) {

            int value;

            while ((value = fileInputStream.read()) != -1) {
                System.out.print((char) value);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nFileOutputStream and FileInputStream\n");
        //endregion

        //region BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("test.txt"))) {

            bufferedOutputStream.write(loremIpsum.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region BufferedInputStream
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("test.txt"))) {

            int value;

            while ((value = bufferedInputStream.read()) != -1) {

                System.out.print((char) value);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nBufferedOutputStream and BufferedInputStream\n");
        //endregion

        //region ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            byteArrayOutputStream.write(loremIpsum.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region ByteArrayInputStream
        {
            var byteArray = loremIpsum.getBytes(StandardCharsets.UTF_8);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);

            int value;

            while ((value = byteArrayInputStream.read()) != -1) {

                System.out.print((char) value);

            }
        }

        System.out.println("\nByteArrayOutputStream and ByteArrayInputStream\n");
        //endregion

        //region DataOutputStream
        int testInt = 1;
        String testString = "test";

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("test_data.bin"))) {

            dataOutputStream.writeUTF(testString);
            dataOutputStream.write(testInt);
            dataOutputStream.write(testInt);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region DataInputStream
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("test_data.bin"))) {

            String stringResult = dataInputStream.readUTF();
            int intResult = dataInputStream.read();

            System.out.println(stringResult);
            System.out.println(intResult);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nDataOutputStream and DataInputStream\n");
        //endregion

        //region ObjectOutputStream

        class TestObjectStream implements Serializable {
            public String name;
            public String surname;
            public int age;
            public Date createdDate;

            public TestObjectStream(String name, String surname, int age, Date createdDate) {
                this.name = name;
                this.surname = surname;
                this.age = age;
                this.createdDate = createdDate;
            }

            @Override
            public String toString() {
                return "TestObjectStream{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + ", createdDate=" + createdDate + '}';
            }
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test_data.bin"))) {

            objectOutputStream.writeObject(new TestObjectStream("John", "Snow", 12, new Date()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region ObjectInputStream
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test_data.bin"))) {

            TestObjectStream testObjectStream = (TestObjectStream) objectInputStream.readObject();

            System.out.println(testObjectStream);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nObjectOutputStream and ObjectInputStream\n");
        //endregion

        //region RandomAccessFile
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt", "rw")) {

            randomAccessFile.write((loremIpsum + "raf").getBytes(StandardCharsets.UTF_8));

            int value;

            randomAccessFile.seek(0);

            while ((value = randomAccessFile.read()) != -1) {
                System.out.print(((char) value));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nRandomAccessFile\n");
        //endregion

        //region FileChannel write
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt", "rw"); FileChannel channel = randomAccessFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(loremIpsum.length());
            buffer.put(loremIpsum.getBytes());
            buffer.flip();
            channel.write(buffer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion

        //region FileChannel read
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt", "rw"); FileChannel channel = randomAccessFile.getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(24);
            int byteRead = channel.read(byteBuffer);

            while (byteRead > 0) {

                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }

                byteBuffer.clear();
                byteRead = channel.read(byteBuffer);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nChannel read\n");
        //endregion

        //region Path
        {
            Path path = Paths.get("C:\\Users\\asadb\\IdeaProjects\\learn_javaa\\test.txt");

            Path fileName = path.getFileName();
            System.out.println("fileName :: " + fileName);

            Path parent = path.getParent();
            System.out.println("parent :: " + parent);

            Path root = path.getRoot();
            System.out.println("root :: " + root);

            System.out.println("path.endsWith(\"test.txt\") :: " + path.endsWith("test.txt"));
            System.out.println("path.endsWith(\"learn_javaa\\\\test.txt\") :: " + path.endsWith("learn_javaa\\test.txt"));

            System.out.println("path.isAbsolute() :: " + path.isAbsolute());

            path = Paths.get("C:\\Users\\asadb\\IdeaProjects\\..\\IdeaProjects\\learn_javaa\\test.txt");

            System.out.println("path.normalize() :: " + path.normalize());
        }

        System.out.println("\nPath\n");
        //endregion

        //region Files
        {
            try {
                Path file = Files.createFile(Paths.get("createTest.txt"));
                System.out.println("File created? " + Files.exists(file));

                Path dir = Files.createDirectory(Paths.get("createDir"));
                System.out.println("dir created? " + Files.exists(dir));

                Path copy = Files.copy(file, Paths.get("createDir/copy.txt"));
                Path move = Files.move(file, Paths.get("createDir/createTest.txt"), REPLACE_EXISTING);

                Files.delete(copy);
                Files.delete(move);
                Files.delete(dir);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //endregion
    }

}
