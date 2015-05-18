package org.familysearch.test;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by tyganshelton on 5/6/2015.
 * Accepts file name as argument.
 */
public class FileSorter {

    private void sort(String filename){
        TreeSet<String> set = new TreeSet<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
            String readLine = br.readLine();
            while(readLine!=null){
                set.add(readLine);
                readLine = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File orderedFile = new File("ordered_"+filename);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(orderedFile));
            for(String writeLine: set){
                bw.write(writeLine);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reverseSort(String filename){
        TreeSet<String> set = new TreeSet<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
            String readLine = br.readLine();
            while(readLine!=null){
                set.add(readLine);
                readLine = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> reverseSet = set.descendingSet();

        File orderedFile = new File("reverse_ordered_"+filename);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(orderedFile));
            for(String writeLine: reverseSet){
                bw.write(writeLine);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileSorter instance = new FileSorter();
        instance.sort(args[0]);
        instance.reverseSort(args[0]);
    }
}