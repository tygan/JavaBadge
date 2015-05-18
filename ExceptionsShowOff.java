package org.familysearch.test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by tyganshelton on 5/6/2015.
 */
public class ExceptionsShowOff {

    private void exceptionShower(){

        //Unchecked exceptions
        System.out.println("Examples of unchecked exceptions:");
        //ArrayOutOfBoundsException
        int[] ages = {0,1,2,3,4};
        int attempt=7;
        try {
            System.out.println(ages[attempt]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException: You requested the "+attempt+"th index, but the size of the array is only "+ages.length);
;        }

        //NullPointerException
        String s = "";
        s = null;
        try{
            System.out.println(s.length());
        }
        catch(NullPointerException e){
            System.out.println("NullPointerException: You requested the length of String s, but String s is null");
        }

        //ArithmeticException
        int a = 254;
        int b = 0;
        try{
            int c = a/b;
        }
        catch(ArithmeticException e){
            System.out.println("ArithmeticExcetion: You tried to divide by zero");
        }

        //IllegalArgumentException
        int d = -1;
        try{
            Character.toChars(-1);
        }
        catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException: Character.toChars() cannot accept negative integer");
        }

        //Checked Exceptions
        System.out.println("\nExamples of unchecked exceptions:");
        //FileNotFoundException
        try {
            FileReader reader = new FileReader("doesntExist.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: You tried to access doesntExist.txt, but this file doesn't exist");
        }

        //IOException
        String sample = "Lorem ipsum dolor sit amet";
        File file = new File("example");
        try {
            FileWriter writer = new FileWriter(file);
            writer.close();
            writer.write(sample);
        } catch (IOException e) {
            System.out.println("IOException: You tried to use FileWriter writer but it is closed");
        }

        System.out.println("\nExample of error:");
        throw new Error("Error: This class has thrown all its exceptions. You now have nothing fun to do.");
    }



    public static void main(String[] args) throws Error{
        ExceptionsShowOff showoff = new ExceptionsShowOff();
        showoff.exceptionShower();
    }
}
