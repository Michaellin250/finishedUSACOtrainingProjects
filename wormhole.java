/*
 ID: 305399
 LANG: JAVA
 TASK: wormhole
 */

import java.io.*;
import java.util.*;

class wormhole {

    public static int paired_holes[];
    //public static ArrayList<worm> data;
    public static int next_partner[];
    public static int max_worm;
    public static int X[];
    public static int Y[];

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("wormhole.in"));
        PrintWriter out = new PrintWriter("wormhole.out");

        max_worm = scanner.nextInt();
        //data = new ArrayList<worm>();

        //holds all the indexes of every partner worm 
        paired_holes = new int[max_worm + 1];
        next_partner = new int[max_worm + 1];

        X = new int[max_worm + 1];
        Y = new int[max_worm + 1];

        /*
         for (int i = 0; i < paired_holes.length; i++) {
         paired_holes[i] = -1;
         }*/

        /*
         for (int i = 0; i < max_worm; i++) {

         int x_pos = scanner.nextInt();
         int y_pos = scanner.nextInt();
         data.add(new worm(x_pos, y_pos));

         }*/
        for (int i = 1; i <= max_worm; i++) {

            X[i] = scanner.nextInt();
            Y[i] = scanner.nextInt();
        }

        for (int i = 1; i <= max_worm; i++) {
            for (int j = 1; j <= max_worm; j++) {
                if ((X[j] > X[i]) && (Y[i] == Y[j])) {

                    if (next_partner[i] == 0 || X[j] - X[i] < X[next_partner[i]] - X[i]) {
                        next_partner[i] = j;
                    }

                }
            }
        }

        int toPrint = pairAll();
        out.println(toPrint);

        scanner.close();

        out.close();

    }

    public static int pairAll() {

        int Unpair_index = returnUnpairedIndex(1);

        int total = 0;
        //if it's all paired

        if (Unpair_index == -2) {

            if (isCycle()) {
                return 1;
            } else {
                return 0;
            }

        } else {

            for (int S_UnpairIndex = Unpair_index + 1; S_UnpairIndex < paired_holes.length; S_UnpairIndex++) {

                if (paired_holes[S_UnpairIndex] == 0) {
                    paired_holes[Unpair_index] = S_UnpairIndex;
                    paired_holes[S_UnpairIndex] = Unpair_index;
                    total += pairAll();
                    paired_holes[Unpair_index] = 0;
                    paired_holes[S_UnpairIndex] = 0;
                }
            }

        }

        return total;

    }

    public static boolean isCycle() {

        for (int start = 1; start <= max_worm; start++) {

            int pos = start;

            for (int count = 0; count < max_worm; count++) {
                pos = next_partner[paired_holes[pos]];

            }

            if (pos != 0) {
                return true;
            }

        }

        /*
         //have to check every single pair to make sure it is a cycle. 
         for (int i = 0; i < paired_holes.length; i++) {

         int pos = i;
         int next_pos = returnRightHole(pos);
         //int next_next_paired = i;

         while (next_pos != -2) {
         next_pos = paired_holes[next_pos];

         if (next_pos == pos) {
         return true;
         }

         if (returnRightHole(next_pos) != -2) {

         if (next_pos == paired_holes[returnRightHole(next_pos)]) {
         return true;
         }
         }

         next_pos = returnRightHole(next_pos);

                
         }

         if (next_pos == pos) {
         return true;
         }

         // System.out.print(i + " " + paired_holes[i] + " ");
         }
         //System.out.println();
         */
        return false;
    }

    //returns the first instance of -1 which is unpaired wormhole
    //otherwise return -2 that it is paired. 
    public static int returnUnpairedIndex(int start) {
        for (int i = start; i < paired_holes.length; i++) {

            if (paired_holes[i] == 0) {
                return i;
            }
        }

        return -2;

    }

    /*
     //checks whether there is a wormhole on the right if there is return the index otherwise return -2
     public static int returnRightHole(int start) {

     int differ = Integer.MAX_VALUE;
     for (int j = 0; j < paired_holes.length; j++) {

     if ((data.get(j).x_pos > data.get(start).x_pos) && (data.get(j).y_pos == data.get(start).y_pos)) {

     differ = Math.min(differ, data.get(j).x_pos - data.get(start).x_pos);

     }

     }

     for (int j = 0; j < paired_holes.length; j++) {

     if (data.get(j).x_pos - data.get(start).x_pos == differ) {
     return j;
     }

     }

     return -2;
     }
     */
    /*
     private static class worm {

     int x_pos;
     int y_pos;

     public worm(int x, int y) {
     x_pos = x;
     y_pos = y;
     }

     public String toString() {
     return "Positions: " + x_pos + " " + y_pos;
     }

     }*/
}
