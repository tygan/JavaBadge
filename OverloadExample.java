package org.familysearch.test;

/**
 * Created by tyganshelton on 5/8/2015.
 * Shows examples of overloading constructors via constructor chaining and overloading normal methods
 */
public class OverloadExample {

    public static class Person{
        private String name;
        private int age;
        private boolean isCool;
        private boolean canJuggle;

        public Person(String name){
            this.name = name;
            System.out.println("1 Parameter Constructor completed with parameter name="+name);
        }

        //Two-parameter constructor first calls one-parameter constructor
        public Person(String name, int age){
            this(name);
            this.age = age;
            System.out.println("2 Parameter Constructor completed with parameters name="+name+", age="+age);
        }

        //Three-parameter constructor first calls two-parameter constructor
        public Person(String name, int age, boolean isCool){
            this(name, age);
            this.isCool = isCool;
            System.out.println("3 Parameter Constructor completed with parameters name="+name+", age="+age+", isCool="+isCool);
        }

        //Four-parameter constructor first calls three-parameter constructor
        public Person(String name, int age, boolean isCool, boolean canJuggle){
            this(name, age, isCool);
            this.canJuggle = canJuggle;
            System.out.println("3 Parameter Constructor completed with parameters name="+name+", age="+age+", isCool="+isCool+", canJuggle="+canJuggle);
        }

        public void getOlder(){
            age++;
            System.out.println("getOlder method called. "+name+" is now "+age+" years old");
        }

        public void getMarried(){
            isCool = true;
            System.out.println("Zero Parameter getMarried method called. "+name+" is now married.");
        }

        public void getMarried(String newName){
            System.out.println("One Parameter getMarried method called. "+name+" has changed his name to "+newName+".");
            getMarried();
            name = newName;
        }
    }

    public static class Missionary extends Person{

        public Missionary(String name, int age) {
            super(name, age);
            super.isCool = true;
        }

        public void getMarried(){
            super.isCool = false;
            System.out.println("Missionary getMarried method called: Missionaries can't get married!");
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("John Jackson", 35, false, true);
        Person person2 = new Person("Jane Chase", 33, true, false);
        person1.getOlder();
        person2.getMarried();
        person1.getMarried("John Chase");
        Missionary missionary = new Missionary("Elder Skinner", 19);
        missionary.getOlder();
        missionary.getMarried();
    }
}
