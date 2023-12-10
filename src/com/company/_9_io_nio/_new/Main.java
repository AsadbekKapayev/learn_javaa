package com.company._9_io_nio._new;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

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
        var byteArray = loremIpsum.getBytes(StandardCharsets.UTF_8);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);

        int value;

        while ((value = byteArrayInputStream.read()) != -1) {

            System.out.print((char) value);

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

    }

}
