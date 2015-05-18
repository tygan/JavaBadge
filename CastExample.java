package org.familysearch.test;

/**
 * Created by tyganshelton on 5/8/2015.
 * Shows examples of casting and instanceof
 */
public class CastExample {
    public static class Person{
        private String name;

        public Person(String name){
            this.name = name;
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
    }

    public static void main(String args[]){

        //Example of instanceof and casting
        Person percy = new Redhead("Percy", "crimson");
        Redhead jo=null;

        if(jo instanceof Person){
            if(jo instanceof Redhead){
                System.out.println("Jo is a person, and a redhead");
            }
            else{
                System.out.println("Jo is a person, but no a redhead");
            }
        }
        else{
            System.out.println("Jo is not a person or a redhead, because Jo is null");
        }

        jo = (Redhead) percy;

        if(jo instanceof Person){
            if(jo instanceof Redhead){
                System.out.println("Jo is now a redhead as well as a person");
            }
            else{
                System.out.println("Jo is still not a redhead, but he is a person");
            }
        }


    }

}
