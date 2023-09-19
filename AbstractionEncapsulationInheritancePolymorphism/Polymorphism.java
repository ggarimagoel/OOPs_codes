package AbstractionEncapsulationInheritancePolymorphism;

public class Polymorphism {
    public static void main(String[] args) {

        employee emp1 = new employee();
//        System.out.println(emp1.salary("Hr"));
//        System.out.println(emp1.salary("hr" , 5));

        employee emp2 = new salesEmployee();
        System.out.println(emp2.salary("hr"));
    }
    public static class employee{
        String name;
        String post;
        int yoe;


        //compile time polymorphism
        public int salary(String post){
            return 10000;
        }
        public int salary(String post , int yoe){
            return 20000;
        }
    }

    // runtime polymorphism
    public static class salesEmployee extends employee{

        @Override
        public int salary(String post) {
            return 40000;
        }
    }
}
