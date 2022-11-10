package Simulation;

/**
 * @author QiangQin
 * * @date 2021/9/29
 */

import java.io.*;

public class Person implements Serializable {
    private String name;

    public Person() {
        this.name = "lili";
        System.out.println("Construct");
    }

    public String toString() {
        return this.name;
    }

    public static void main(String args[]) {
        Person p = new Person();
        System.out.println(p);
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            FileOutputStream fos = new FileOutputStream("person.out");// 文件操作  字节流
            oos = new ObjectOutputStream(fos); // 对象流 输出到 fos
            oos.writeObject(p);// 将 p对象 写到对象流
            oos.close();
        } catch (Exception ex) {
        }


        Person pl;
        try {
            FileInputStream fis = new  FileInputStream("person.out");// 从文件操作  字节流  中读取
            ois = new ObjectInputStream(fis);
            Person p1 = (Person) ois.readObject();

            System.out.println(p);
            if (p != p1)
                System.out.println("two different object");
            ois.close();
        } catch (Exception ex) {
        }
    }
}