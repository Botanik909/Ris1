import java.util.Scanner;

interface Animal {
    int getAge(int age1, int age2);
}

interface Mammal extends Animal {
    int getNumberOfLegs();
}


interface Bird extends Animal {
    String getFeatherColor(String color);
}


interface Fish extends Animal {
    String getScalePattern(String pattern);
}


interface Reptile extends Animal {
    int getTailLength(int length1, int length2);
}


abstract class MammalAnimal implements Mammal {
    @Override
    public int getAge(int age1, int age2) {
        return age1 + age2;
    }

    abstract double calculateSpeed(int speed1, int speed2);
}


abstract class BirdAnimal implements Bird, Fish {
    @Override
    public int getAge(int age1, int age2) {
        return age1 * age2;
    }

    abstract boolean canFly(String wings);
}

interface Aquatic extends Mammal, Fish {
    void swim();
}

abstract class ReptileAnimal implements Bird {
    @Override
    public String getFeatherColor(String color) {
        return "Feather color: " + color;
    }

    abstract boolean isColdBlooded(boolean cold);
}


interface ZooCreature extends Bird, Fish, Reptile {
    void makeSound(String sound);
}

class ZooAnimal extends ReptileAnimal implements Aquatic, ZooCreature {
    @Override
    public void swim() {
        System.out.println("The animal is swimming.");
    }

    @Override
    public void makeSound(String sound) {
        System.out.println("Animal makes a sound: " + sound);
    }

    @Override
    boolean isColdBlooded(boolean cold) {
        return cold;
    }

    double calculateSpeed(int speed1, int speed2) {
        return (speed1 + speed2) / 2.0;
    }

    @Override
    public int getAge(int age1, int age2) {
        return 0;
    }

    @Override
    public int getNumberOfLegs() {
        return 0;
    }

    @Override
    public String getScalePattern(String pattern) {
        return null;
    }

    @Override
    public int getTailLength(int length1, int length2) {
        return 0;
    }
}

class MammalSpecies implements Mammal {
    @Override
    public int getAge(int age1, int age2) {
        return age1 - age2;
    }

    @Override
    public int getNumberOfLegs() {
        return 4;
    }

    void giveBirth(int numberOfOffspring) {
        System.out.println("The mammal gave birth to " + numberOfOffspring + " offspring.");
    }
}


class BirdSpecies extends MammalAnimal {
    @Override
    double calculateSpeed(int speed1, int speed2) {
        return (speed1 + speed2) * 1.5;
    }

    boolean isEndangered(String status) {
        return "endangered".equalsIgnoreCase(status);
    }

    @Override
    public int getNumberOfLegs() {
        return 0;
    }
}


class FishSpecies extends MammalAnimal {
    @Override
    double calculateSpeed(int speed1, int speed2) {
        return (speed1 + speed2) * 0.75;
    }

    double calculateDepth(int depth1, int depth2) {
        return (depth1 + depth2) / 2.0;
    }

    @Override
    public int getNumberOfLegs() {
        return 0;
    }
}


class ReptileSpecies extends BirdAnimal {
    @Override
    boolean canFly(String wings) {
        return "yes".equalsIgnoreCase(wings);
    }

    boolean isVenomous(String venom) {
        return "venomous".equalsIgnoreCase(venom);
    }

    @Override
    public String getFeatherColor(String color) {
        return null;
    }

    @Override
    public String getScalePattern(String pattern) {
        return null;
    }
}


public class Main {

    public static void main(String[] args) {

        ZooAnimal zooAnimal = new ZooAnimal();
        zooAnimal.swim();
        zooAnimal.makeSound("Bzzzzzzzzzzzzz");
        MammalSpecies mammalSpecies = new MammalSpecies();
        mammalSpecies.giveBirth(3);

        BirdSpecies birdSpecies = new BirdSpecies();
        System.out.println("Is bird endangered? " + birdSpecies.isEndangered("endangered"));

        FishSpecies fishSpecies = new FishSpecies();
        System.out.println("Fish speed: " + fishSpecies.calculateSpeed(20, 25));
        System.out.println("Fish depth: " + fishSpecies.calculateDepth(5, 10));

        ReptileSpecies reptileSpecies = new ReptileSpecies();
        System.out.println("Can reptile fly? " + reptileSpecies.canFly("yes"));
        System.out.println("Is reptile venomous? " + reptileSpecies.isVenomous("venomous"));
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        System.out.println("Vsem privet!!!");
    }
}