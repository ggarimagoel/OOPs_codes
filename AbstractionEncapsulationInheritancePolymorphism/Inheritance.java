package AbstractionEncapsulationInheritancePolymorphism;

public class Inheritance {
    public static void main(String[] args) {

        Pigeon p1 = new Pigeon();
        System.out.println("P1 sound : " + p1.makeSound());

        Pigeon p2 = new WhitePigeon();
         ((WhitePigeon) p2).weight = 200;
         ((WhitePigeon) p2).symbol = "peace";
        System.out.println("p2 symbol of : " + ((WhitePigeon) p2).symbol);

    }
    public interface BirdSound{
        String makeSound();
    }
    public static class Pigeon implements BirdSound{
        public String makeSound(){
            return "Pigeon sound";
        }
    }
    public static class WhitePigeon extends Pigeon{
        int weight ;
        String symbol ;

        public String PigeonColor(){
            return "white";
        }
    }
}
