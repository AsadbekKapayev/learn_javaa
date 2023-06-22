package com.company._9_io_nio._7_OIS_OOS;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        var users = List.of(new User(1L, "Hey", "Hey", 17, "hey@email.com", "hey!password"), new User(2L, "Hey1", "Hey", 16, "hey2@email.com", "hey!password"), new User(3L, "Hey2", "Hey", 15, "hey3@email.com", "hey!password"), new User(4L, "Hey3", "Hey", 14, "hey1@email.com", "hey!password"));

        try (var s = new ObjectOutputStream(new FileOutputStream("src/com/company/_9_io_nio/_7_OIS_OOS/test2.bin"))) {

            s.writeObject(users);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


class User implements Serializable {
    public static final long serialVersionUID = 2; // если мы поменяли объект то должны также менять версию
    public Long id;
    public String name;
    public String surname;
    public Integer age;
    public String email;
    transient public String password;

    public User(Long id, String name, String surname, Integer age, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", age='" + age + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}