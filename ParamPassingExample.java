package org.familysearch.test;

/**
 * Created by tyganshelton on 5/8/2015.
 * Example of results of passing and changing primitives and objects in methods
 */
public class ParamPassingExample {

    public static void changeValues(int x, String string, Example example, final Example finalExample){
        x = 2;
        string = "Second String";
        string = "Second String";
        example.name = "Charles the Second";
        finalExample.name = "Second Final Example";
        System.out.println("\nInside-method values:\n  x = " + x + "\n  string = " + string + "\n  example.name = " + example.name+
                "\n  finalExample.name = "+finalExample.name);
    }

    public static void main(String[] args) {
        ParamPassingExample ppexample = new ParamPassingExample();

        int x = 1;
        String string = "First String";
        Example example = new Example();
        example.name = "Charles the First";
        Example finalExample = new Example();
        finalExample.name = "First Final Example";

         System.out.println("Original values:\n  x = "+x+"\n  string = "+string+"\n  example.name = "+example.name+
                "\n  finalExample.name = "+finalExample.name);
        ppexample.changeValues(x, string, example, finalExample);
        System.out.println("\nAfter-method values:\n  x = " + x + "\n  string = " + string + "\n  example.name = " + example.name+
                "\n  finalExample.name = "+finalExample.name);
    }

    static class Example{
        String name;
    }
}
