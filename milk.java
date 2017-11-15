/*
 ID: 305399
 LANG: JAVA
 TASK: milk
 */

import java.io.*;
import java.util.*;

class milk {

    //public static int firstDiffer;
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("milk."));
        PrintWriter out = new PrintWriter("milk.out");

        int amountOfmilk = scanner.nextInt();

        int farmers = scanner.nextInt();

        Interval Data[] = new Interval[farmers];

        for (int n = 0; n < Data.length; n++) {

            Data[n] = new Interval(scanner.nextInt(), scanner.nextInt());

        }

        Arrays.sort(Data, new Comparator<Interval>() {

            public int compare(Interval first, Interval second) {
                return first.cents - second.cents;
            }
        });

        int toReturn = 0;
        int cur_milk = 0;
        int i = 0;
        for(Interval f : Data) {

            if (f.milk+cur_milk>=amountOfmilk) {

                int toAdd = amountOfmilk - cur_milk;
                toReturn += Data[i].cents * toAdd;
                cur_milk += toAdd;
            } else {

                cur_milk += Data[i].milk;
                toReturn += Data[i].returnedCost();

                i++;

            }

        }

        out.println(toReturn);

        scanner.close();

        out.close();

    }

    private static class Interval {

        private final int cents;
        private final int milk;

        public Interval(int c, int m) {

            cents = c;
            milk = m;

        }

        public int returnedCost() {

            return cents * milk;
        }

        public String toString() {
            return cents + " " + milk;
        }

    }

}
