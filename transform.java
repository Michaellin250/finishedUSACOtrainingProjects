
import java.io.*;
import java.util.*;


/*/*
 ID: 305399
 LANG: JAVA
 TASK: transform
 */
public class transform {

    public static char Data[][];
    public static char Output[][];
    public static char Original[][];
    public static int numLines;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter("transform.out");

        numLines = scanner.nextInt();
        scanner.nextLine();

        Data = new char[numLines][numLines];
        for (int row = 0; row < Data.length; row++) {
            String toScan = scanner.nextLine();

            for (int col = 0; col < Data[row].length; col++) {

                Data[row][col] = toScan.charAt(col);
                //System.out.print(Data[row][col]);
            }
            //System.out.println();
        }

        Original = new char[numLines][numLines];

        for (int row = 0; row < Original.length; row++) {

            for (int col = 0; col < Original.length; col++) {

                Original[row][col] = Data[row][col];

            }
        }

        Output = new char[numLines][numLines];
        for (int row = 0; row < Output.length; row++) {
            String toScan = scanner.nextLine();
            for (int col = 0; col < Output[row].length; col++) {

                Output[row][col] = toScan.charAt(col);
                //System.out.print(Output[row][col]);
            }
            //System.out.println();
        }

        out.println(toReturn());
        scanner.close();
        out.close();

    }

    public static char[][] flipped(char input[][]) {

        char toReturn[][] = new char[input.length][input.length];
        for (int row = 0; row < toReturn.length; row++) {

            for (int col = 0; col < toReturn.length; col++) {

                toReturn[row][col] = input[input.length - 1 - col][row];
                //System.out.print(toReturn[row][col]);

            }

            //System.out.println();
        }

        return toReturn;

    }

    public static void Reflection(char input[][], char toReturn[][]) {

        for (int row = 0; row < toReturn.length; row++) {

            for (int col = 0; col < toReturn.length; col++) {

                toReturn[row][col] = input[row][input.length - 1 - col];
                //System.out.print(input[row][col]);

            }

            //System.out.println();
        }

    }

    public static int toReturn() {

        
        Data = flipped(Data);

        if (isEqual(Data, Output)) {

            return 1;

        } else {

            Data = flipped(Data);

            if (isEqual(Data, Output)) {

                return 2;

            } else {

                Data = flipped(Data);

                if (isEqual(Data, Output)) {

                    return 3;
                } else {

                    Reflection(Original, Data);

                    if (isEqual(Data, Output)) {

                        return 4;

                    } else {

                        Data = flipped(Data);

                            //printArray(Data);
                        //printArray(Output);
                        if (isEqual(Data, Output)) {

                            return 5;

                        } else {

                            Data = flipped(Data);

                            if (isEqual(Data, Output)) {

                                return 5;

                            } else {
                                Data = flipped(Data);

                                /*
                                 printArray(Data);
                                 printArray(Output);
                                 */
                                if (isEqual(Data, Output)) {

                                    return 5;

                                }
                                
                                else if (isEqual(Original,Output)){
                                    
                                    return 6;
                                    
                                    
                                }

                            }

                        }

                    }

                }

            }

        }

        return 7;

    }

    public static boolean isEqual(char input[][], char output[][]) {

        for (int row = 0; row < input.length; row++) {

            for (int col = 0; col < input.length; col++) {

                if (input[row][col] != output[row][col]) {

                    return false;
                }

            }

        }

        return true;

    }

    public static void printArray(char input[][]) {

        for (int i = 0; i < input.length; i++) {

            for (int j = 0; j < input.length; j++) {

                System.out.print(input[i][j]);

            }

            System.out.println();
        }

    }


}
