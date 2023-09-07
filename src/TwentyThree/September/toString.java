package TwentyThree.September;

public class toString {

    static class Person {
        String name;
        Integer age;
        String job;

        public Person(String name, Integer age, String job) {
            this.name = name;
            this.age = age;
            this.job = job;
        }
    }
    public static void main(String[] args) {
        Person jenny = new Person("jenny", 10, "doctor");
        Person tom = new Person("tom", 12, "programmer");

        System.out.println(jenny);  // TwentyThree.September.toString$Person@49e4cb85
        System.out.println(jenny.toString()); // TwentyThree.September.toString$Person@49e4cb85
        System.out.println(tom.toString()); // TwentyThree.September.toString$Person@2133c8f8
    }

}
