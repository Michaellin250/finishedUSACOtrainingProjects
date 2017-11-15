/*
 ID: 305399
 LANG: JAVA
 TASK: barn1
 */

import java.io.*;
import java.util.*;

class barn1 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("barn1.in"));
        PrintWriter out = new PrintWriter("barn1.out");

        int maxBoards = scanner.nextInt();
        int tot_stalls = scanner.nextInt();
        int cow_inStalls = scanner.nextInt();

        int stalls[] = new int[cow_inStalls];
        int boards, stallsCovered = cow_inStalls;

        ArrayList<Gap> gaps = new ArrayList<Gap>();

        Gap g;
        
        for (int index = 0; index < stalls.length; index++) {

            stalls[index] = scanner.nextInt();

        }

        Arrays.sort(stalls);

        for (int iter = 1; iter < cow_inStalls; iter++) {

            if (stalls[iter] - stalls[iter - 1] > 1) {

                gaps.add(new Gap(stalls[iter - 1], stalls[iter]));

            }

        }

        Collections.sort(gaps);

        boards = gaps.size() + 1;

        while (boards > maxBoards) {
            //remove smallest gap
            g = gaps.remove(0);
            //add its size to stallsCovered
            stallsCovered += g.getSize();
            //remove a board
            boards--;
        }

        out.println(stallsCovered);

        scanner.close();

        out.close();

    }

    static class Gap implements Comparable<Gap> {

        int start, end;

        Gap(int s, int e) {
            start = s;
            end = e;
        }

        public int compareTo(Gap o) {
            return getSize() - o.getSize();
        }

        public int getSize() {
            return end - start - 1;
        }

    }

}
