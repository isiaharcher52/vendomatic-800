package com.techelevator.models;

import java.io.*;
import java.time.LocalDateTime;

public class Audit {

    public Audit(){

    }

    public void writeToLog(String printString){

        try(FileWriter fw = new FileWriter("Log.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)){
            out.println(LocalDateTime.now() + " " + printString);
        } catch (IOException e) {
            System.err.println("Cannot open the file for writing.");
        }
    }
}
