package Interview.YuShi;

import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.ir.debug.ObjectSizeCalculator.getObjectSize;

class People{
    String name;
    int  age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
public class Size {

    public static void main(String[] args) {
         People p1=new  People("张三",18);
        System.out.println(getObjectSize(p1));

    }
}
