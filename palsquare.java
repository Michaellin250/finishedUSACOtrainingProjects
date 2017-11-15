
import java.io.*;
import java.util.*;

/*
 ID: 305399
 LANG: JAVA
 TASK: palsquare
 */
public class palsquare {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("palsquare.in"));
        PrintWriter out = new PrintWriter("palsquare.out");

        int base = scanner.nextInt();

        
        for (int numbers = 1; numbers <= 300; numbers++) {

            int squared = numbers * numbers;

            String numberConverted = converToBased(numbers, base);
            String squaredConverted = converToBased(squared, base);

            if (isPalindrome(squaredConverted)) {
  
                out.println(numberConverted + " " + squaredConverted);
            }

        }

        scanner.close();
        out.close();

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
