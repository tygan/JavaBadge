package org.familysearch.test;

/**
 * Created by tyganshelton on 5/8/2015.
 */
public class EncapsulationExample {

    //Example of good encapsulation
    public static class GoodSpaceship{
        private String name;
        private int speed;
        private int yearMade;

        public GoodSpaceship(String name, int yearMade) {
            this.name = name;
            this.yearMade = yearMade;
            speed = 0;
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public int getYearMade() {
            return yearMade;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        //YearMade should not be changed, so no setter is created.

        public String getRegistration(){
            return "Y2-7B-" + name + "-" + yearMade;
        }
    }

    //Example of bad encapsulation
    public static class BadSpaceship{
        String name;
        int yearMade;
        int speed;
    }

    public static void main(String[] args) {
        //Use of good encapsulation
        GoodSpaceship ship1 = new GoodSpaceship("Enterprise", 2245);
        ship1.setSpeed(40);
        ship1.setName("USS Enterprise");
        System.out.println("The registration code for " + ship1.getName() + " is " + ship1.getRegistration());

        //Use of bad encapsulation
        BadSpaceship ship2 = new BadSpaceship();
        ship2.name = "YT-1300 492727ZED";
        ship2.yearMade = 60;
        ship2.speed = 110;
        ship2.name = "Millennium Falcon";
        ship2.yearMade = 93;
        System.out.println("The registration code for " + ship2.name + " is " + "Y2-7B-" + ship2.name + "-" + ship2.yearMade);
    }
}
