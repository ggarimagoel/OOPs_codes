package AbstractionEncapsulationInheritancePolymorphism;

public class Abstraction {
    public static void main(String[] args) {

        animal cat = new Cat();
        System.out.println(cat.makeSound());
        System.out.println(cat.eat());


        animal toto = new tortotoise();
        System.out.println(toto.makeSound());
        System.out.println(toto.eat());
    }
    public static abstract class animal{
        abstract String makeSound();
        abstract boolean run();
        abstract  String eat();
    }
    public static class Cat extends animal{
        public String makeSound(){
            return "meow meow";
        }
        public boolean run(){
            return true;
        }
        public String eat(){
            return "mouse";
        }
    }
    public static class tortotoise extends animal{
        public String makeSound(){
            return "toto sound";
        }
        public boolean run(){
            return false;
        }
        public String eat(){
            return "worms";
        }
    }
}
