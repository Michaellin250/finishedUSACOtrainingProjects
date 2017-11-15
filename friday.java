/*
LANG: JAVA
TASK: friday
ID: 305399
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class friday {

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        int N = Integer.parseInt(f.readLine());

        
        int numdaysinmonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
       
        int currentindexday = 0;

        int sun =0 ;
        int mon = 0;
        int tues = 0;
        int weds = 0;
        int thurs = 0;
        int fri = 0;
        int sat = 0;
                

        

        //the number of days to add to get from teh first starting day to the last day
            int daystoadd = 0; 
            
            
            int startingday = 1;
            
            int end = N + 1900;
        
        //for loop from years
       for (int x = 1900; x < end; x++) {

            
             if(x%4 == 0 && x%100 != 0 || x%400==0 ){
            
             numdaysinmonth[1] = 29;
            
             }
        
             else{
            
             numdaysinmonth[1] = 28;
             }
        
            
         
            
            for (int y = 0; y < numdaysinmonth.length; y++) {
                
                if(numdaysinmonth[y] == 31){
                    
                    daystoadd = 3;
                    
                }
                
                else if(numdaysinmonth[y] == 30){
                    
                    daystoadd = 2;
                    
                }
                
                else if(numdaysinmonth[y] == 29){
                    
                    daystoadd = 1;
                    
                }
                
                else if(numdaysinmonth[y] == 28){
                    
                    daystoadd = 0;
                    
                }
                
                
                //each thirteenth day is the first day adding 5 to get the day 13%7 -1 
                currentindexday = (startingday + 5);
                
                if(currentindexday>7){
                    
                    currentindexday = currentindexday%7;
                    
                }

                switch(currentindexday){
                    
            
                    case 1:
                        mon++;
                        break;
                    case 2:
                        tues++;
                        break;
                    case 3:
                        weds++;
                        break;
                    case 4:
                        thurs++;
                        break;
                    case 5:
                        fri++;
                        break;
                    case 6:
                        sat++; 
                        break;
                    case 7:
                        sun++;
                        break;
                    
                }
                
                startingday = startingday + daystoadd;
                
                if(startingday>7){
                    startingday = startingday%7;
                }
                

            }
            
            
            
        }
        
        out.println(sat + " " + sun + " " + mon + " " + tues + " " + weds + " " + thurs + " "+ fri);
        

        out.close();                                  // close the output file
        System.exit(0);                               // don't omit this!

    }


}
