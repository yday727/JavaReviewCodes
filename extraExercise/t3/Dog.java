package extraExercise.t3;

public class Dog extends Animal{
    public Dog() {};

    @Override
    public void cry() {
        System.out.println("汪汪");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry();
    }
}
