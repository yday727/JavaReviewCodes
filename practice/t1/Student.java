package practice.t1;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void introduce() {
        System.out.println("我的名字是" + name + "，今年" + age + "岁。");
    }

    public static void main(String[] args) {
        Student stu = new Student("张三", 20);
        stu.introduce();
    }
}
