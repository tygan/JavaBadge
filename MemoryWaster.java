package org.familysearch.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyganshelton on 5/13/2015.
 * Example of using OutOfMemoryError: finds total number of characters that can be held in a list of strings.
 */
public class MemoryWaster {

    private static int iteratorValue;
    private static int totalChars;

    public static void main(String[] args) {
        MemoryWaster waster = new MemoryWaster();
        try{
            waster.stringListOOM();
        } catch (OutOfMemoryError e){
            System.out.println("Max number of total characters in a list of strings is "+totalChars);
        }
    }

    public void stringListOOM() throws OutOfMemoryError {
        totalChars = 0;
        List<String> strings = new ArrayList<String>();
        for(int i=0; i>-1; i++) {
            String temp = "Trial "+i;
            strings.add(temp);
            totalChars+=temp.length();
        }
    }
}