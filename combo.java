/*
 ID: 305399
 LANG: JAVA
 TASK: combo
 */

import java.io.*;
import java.util.*;

class combo {

    public static int N; 
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("combo.in"));
        PrintWriter out = new PrintWriter("combo.out");

        N = scanner.nextInt();

        int a  = scanner.nextInt();
        int b  = scanner.nextInt();
        int c = scanner.nextInt();


        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();

         int count = 0;
        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= N; j++) {

                for (int k = 1; k <= N ; k++) {
           
                    if(checkAll(i,j,k, a, b, c) || checkAll(i,j, k, d, e,f)){
                        //System.out.println(i + "," + j + "," + k);
                        count++;
                    }
                }

            }

        }     

        out.println(count);
        scanner.close();

        out.close();

    }
    
    
    public static boolean checkAll(int i, int j, int k, int a, int b, int c){
        
        return check(i,a) && check(j,b) && check(k,c);
    }
    
    public static boolean check(int a, int b){
        
        if(Math.abs(a-b)<=2){
            return true; 
        }
        
        if(Math.abs(a-b)>= N-2){
            return true;
        }
        
        return false;
    }

}
