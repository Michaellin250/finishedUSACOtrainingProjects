/*
 ID: 305399
 LANG: JAVA
 TASK: crypt1
 */

import java.io.*;
import java.util.*;

public class crypt1 {

    private static int arr[] = new int [5];
    public static void main(String[] args) throws IOException {

        
        Scanner scanner = new Scanner(new File("crypt1.in"));
        PrintWriter out = new PrintWriter("crypt1.out");


        int numcrypts = 0;
        int num_digits = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        String numb[] = input.split(" ");

        arr = new int[numb.length];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = Integer.parseInt(numb[i]);
        }

        for (int a = 0; a < arr.length; a++) {

            for (int b = 0; b < arr.length; b++) {

                for (int c = 0; c < arr.length; c++) {

                    for (int d = 0; d < arr.length; d++) {

                        for (int e = 0; e < arr.length; e++) {

                            int ABC = 100 * arr[a] + 10 * arr[b] + arr[c];
                            int DE = 10 * arr[d] + arr[e];
                            if (isValid(ABC*arr[d]) && isValid(ABC*arr[e]) && isValid(ABC*DE) && String.valueOf(ABC * DE).length() == 4 && String.valueOf(ABC * arr[d]).length() == String.valueOf(ABC * arr[e]).length() && String.valueOf(ABC * arr[e]).length() == 3) {
                                numcrypts++;
                            }
                        }
                    }

                }
            }
        }

            out.println(numcrypts);

            scanner.close();

            out.close();

        
        }
    
    //checks whether the digit is valid in the prime array
    public static boolean val(int toFind) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == toFind) {
                return true;
            }

        }
        return false;

    }
    
    public static boolean isValid(int number){
        
        while(number>0){
            
            if(!val(number%10)){
                return false; 
            }
            
            number = number / 10;
            
        }
        
        return true;   
    }
    
    
    

}
