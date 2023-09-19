package AbstractionEncapsulationInheritancePolymorphism;

public class Encapsulation {
    public static void main(String[] args) {

        Student s = new Student();
        s.name = "garima";
        s.age = 35;
        s.CollegeName = "PDM";
        s.psp = 7.5;

        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.CollegeName);
        System.out.println(s.psp);
        System.out.println(s.playSports());
        System.out.println(s.StudyHours());

    }
    public  static class Student{
        String name;
        int age;
        String CollegeName;
        double psp;

        public int StudyHours(){
            return 5;
        }
        public boolean playSports(){
            return true;
        }

    }
}
