import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int animalType = scanner.nextInt();

        Animal animal;

        if (animalType == 1) {
            animal = new Cat();
        } else if (animalType == 2) {
            animal = new Dog();
        } else {
            animal = new Animal();
        }

        animal.makeSound();
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Generic sound");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}