
import java.io.*;
import java.util.*;

/*
 ID: 305399
 LANG: JAVA
 TASK: dualpal
 */
public class dualpal {
    
    public static String input;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("dualpal.in"));
        PrintWriter out = new PrintWriter("dualpal.out");

        int numb = scanner.nextInt();
        int limit = scanner.nextInt()+1;
        
        
        while(numb!=0){
            
            if(twoBases(limit)){
                
                out.println(limit);
                numb--;
                
            }
            limit++;

        }
        
        
        
        scanner.close();
        out.close();

    }
    
    public static boolean twoBases(int number){
        int numbBases = 0;
        for(int i = 2; i<=11; i++){
            
            if(numbBases>=2){
                return true;
            }
            
            input = converToBased(number,i);
            
            if(isPalindrome(input)){
                
                numbBases++;
            }
        }
        
        return false;
        
    }

    public static String converToBased(int number, int base) {

        int remainder = 0;
        String toReturn = "";
        char letters [] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K'};

        do {

            remainder = number % base;
            
            
            toReturn = letters[remainder] + toReturn;
            
            number = number / base;

        } while (number != 0);
        return toReturn;
    }

    public static boolean isPalindrome(String toCheck) {

        int n = toCheck.length();
 
        for(int i = 0; i<n/2; i++){
            
            if(toCheck.charAt(i) != toCheck.charAt(n-i -1)){
                
                return false;
            }

        }
        return true;

    }

}
