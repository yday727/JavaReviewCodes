package exercise.t3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Student> students = new ArrayList<>(3);
        students.add(new Student("张三", random.nextInt(0, 35)));
        students.add(new Student("李四", random.nextInt(0, 35)));
        students.add(new Student("王五", random.nextInt(0, 35)));

        // 增强for循环
        for (Student stu : students) {
            try {
                if (stu.age > 30) {
                    throw new IllegalAgeException("年龄大于30");
                }
            } catch (IllegalAgeException e) {
                System.err.println(e.getMessage());
                System.out.println("删除：" + stu.name);
                students.remove(stu);
            }
        }

        // iterator迭代器
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student stu = iterator.next();
            try {
                if (stu.age > 30) {
                    throw new IllegalAgeException("年龄大于30");
                }
            }  catch (IllegalAgeException e) {
                System.err.println(e.getMessage());
                System.out.println("删除：" + stu.name);
                students.remove(stu);
            }
        }
    }
}
