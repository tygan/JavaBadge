package org.familysearch.test;

/**
 * Created by tyganshelton on 5/8/2015.
 * Shows examples of overloading methods in subclass
 */
public class OverrideExample {

    public static class Person{
        private String name;

        public Person(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public void talk(){
            System.out.print("\nMy name is " + name + " and I'm a person");
        }
    }

    public static class Redhead extends Person{
        private String hue;

        public Redhead(String name, String hue){
            super(name);
            this.hue = hue;
        }

        public String getHue(){
            return hue;
        }

        //Shows example of overriding methods
        public void talk(){
            super.talk();
            System.out.println(", but I am better than other people because I have red hair");
        }
    }

    public static void main(String args[]){

        //Example of overriding methods
        Person larry = new Person("Larry");
        Person percy = new Redhead("Percy", "crimson");

        larry.talk();
        percy.talk();
    }

}
