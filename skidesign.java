
import java.io.*;
import java.util.*;


/*/*
 ID: 305399
 LANG: JAVA
 TASK: skidesign
 */
public class skidesign {


    public static int [] data;
    public static ArrayList<Integer> sum = new ArrayList<Integer>();
    
    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(new File("skidesign.in"));
        PrintWriter out = new PrintWriter("skidesign.out");
        
        
        
        int num_hills = keyboard.nextInt();
        int N = num_hills;
        data = new int[num_hills];
        int index = 0;
        
        while(num_hills != 0){
            data[index] = keyboard.nextInt();
            index++;
            num_hills--;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int iter = 0; iter<=83; iter++){
            
            int total = 0; int diff = 0;
            for(index = 0; index<N; index++){
                
                if(data[index] < iter){
                    diff = iter - data[index];
                }
                
                else if(data[index] > iter + 17){
                    diff = data[index] - (iter + 17);
                }
                
                else{
                    diff = 0;
                }
                
                total+= diff*diff;
                
            }
            
            min = Math.min(total,min);
            
        }

        keyboard.close();
        out.println(min);
        out.close();

    }

    
}
