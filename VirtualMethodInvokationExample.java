package org.familysearch.test;

import java.util.ArrayList;

/**
 * Created by tyganshelton on 5/8/2015.
 * Shows example of how virtual method invocation lets one implementation be swapped for another.
 * In this case, the implementation for welcome() is swapped.
 */
public class VirtualMethodInvokationExample {

    public static class Language{
        public Language(){
        }

        public String welcome(){
            return "Generic welcome";
        }
    }

    public static class English extends Language{
        public String welcome(){
            return "Welcome!";
        }
    }

    public static class Aussie extends English{
        public String welcome(){
            return "G'day, mate!";
        }
    }

    public static class Texan extends English{
        public String welcome(){
            return "Howdy, y'all!";
        }
    }

    public static class Thai extends Language{
        public String welcome(){
            return "Sawatdeekrup!";
        }
    }

    public static class Cantonese extends Language{
        public String welcome(){
            return "Lay ho!";
        }
    }

    public static void main(String args[]){
        ArrayList<Language> languages = new ArrayList<Language>();
        languages.add(new Language());
        languages.add(new Cantonese());
        languages.add(new English());
        languages.add(new Texan());
        languages.add(new Thai());
        languages.add(new Aussie());

        for(Language temp: languages){
            System.out.println(temp.welcome());
        }
    }

}
