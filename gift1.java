/*
ID: 305399
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    
    int NP = Integer.parseInt(f.readLine());
    
    int arraymoney [] = new int[NP];
    String groupmembers[] = new String[NP];
     
        for(int i = 0; i<NP; i++){
            groupmembers[i] = f.readLine();
        }
    
    while(f.ready()){     
        
        String GiftGiver = f.readLine();
        
        String twonumbers = f.readLine();
        
        int giftgiverindex = 0;
        
        int indexOf = twonumbers.indexOf(" ");
        
        int giftGiver_Imoney = Integer.parseInt(twonumbers.substring(0 , indexOf));
        
        int num_gifts = Integer.parseInt(twonumbers.substring(indexOf+1));
        
        if(num_gifts != 0){
            
            for(int i = 0; i<num_gifts; i++){
                
                String persontoFind = " ";
                
                persontoFind = f.readLine();
                for(int x = 0; x<groupmembers.length; x++){
                    

                    
                    if(groupmembers[x].equals(persontoFind)){
                        indexOf = x;
                    }
                    
                    if(groupmembers[x].equals(GiftGiver)){
                        giftgiverindex = x;
                    }
                    
                }
                
                arraymoney[indexOf] += (giftGiver_Imoney/num_gifts);
                
               
                arraymoney[giftgiverindex] -= (giftGiver_Imoney/num_gifts);
                
            }
            
            
        }
        
    }
    
    for(int x = 0; x<arraymoney.length; x++){
        
        
        out.println(groupmembers[x] + " " + arraymoney[x]);
        
    }
       
        
    
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
        }
    
  }