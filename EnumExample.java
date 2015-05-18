package org.familysearch.test;

/**
 * Created by tyganshelton on 5/6/2015.
 */
public class EnumExample {

    public enum Bender {
        NONE, AIR, WATER, EARTH, FIRE, AVATAR
    }

    private Bender bender;

    public EnumExample(Bender bender){
        this.bender = bender;
    }

    private String describe(){
        switch(bender){
            case NONE:
                return ("Can't bend any elements, but may still be skilled at battle");

            case AIR:
                return ("Focuses on freedom, momentum, speed, and evasion.");

            case WATER:
                return ("Focuses on adaptability, versatility, flow, and using the enemy's strength against him");

            case EARTH:
                return ("Focuses on patience, stability, absorbing attacks, and brute strength");

            case FIRE:
                return ("Focuses on aggression, balance, passion, and constant energy");

            case AVATAR:
                return ("The only one who can bend all of the elements.");
        }
        return null;
    }

    public static void main(String[] args) throws Error{
        EnumExample Aang = new EnumExample(Bender.AVATAR);
        EnumExample Toff = new EnumExample(Bender.EARTH);
        EnumExample Katara = new EnumExample(Bender.WATER);
        EnumExample Zuko = new EnumExample(Bender.FIRE);
        EnumExample Tenzin = new EnumExample(Bender.AIR);
        EnumExample Sokka = new EnumExample(Bender.NONE);

        System.out.println("Sokka: "+Sokka.describe());
        System.out.println("Katara: " + Katara.describe());
        System.out.println("Tenzin: "+Tenzin.describe());
        System.out.println("Zuko: "+Zuko.describe());
        System.out.println("Toff: "+Toff.describe());
        System.out.println("Aang: " + Aang.describe());

    }

}
