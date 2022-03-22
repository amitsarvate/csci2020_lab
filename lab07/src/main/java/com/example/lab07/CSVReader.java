package com.example.lab07;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CSVReader {

    public static final String file = "/Users/amit.sar21/University/Second Year/Semester 2 /Systems Development and Integration - CSCI 2020/labs/lab07/src/weatherwarnings-2015.csv";
    public static ArrayList<String> events;
    public static int[] count = new int[4];

    public static int[] readCSV() throws IOException {

        BufferedReader reader = null;
        String line = "";

        events = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null)  {
                String[] row = line.split(",");
                events.add(row[5]);

            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        count[0] = Collections.frequency(events, "SEVERE THUNDERSTORM");
        count[1] = Collections.frequency(events, "SPECIAL MARINE");
        count[2] = Collections.frequency(events, "FLASH FLOOD");
        count[3]  = Collections.frequency(events, "TORNADO");

        return count;

    }

//    public static void main(String[] args) throws IOException {
//        int[] eventCounts = CSVReader.readCSV();
//
//        for (int index : eventCounts) {
//            System.out.println(index);
//        }
//    }
}
