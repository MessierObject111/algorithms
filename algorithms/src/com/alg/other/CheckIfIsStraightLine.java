package com.alg.other;

public class CheckIfIsStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        /**
         * 2023-07-10
         First, find out the slope rate of the first straight line constructed from
         first 2 points coordinates[0] & coordinates[1], then iterate thru the
         rest of other points to check if their slope matches or not.
         From concept it sounds easy, but when I tried to implement this, I found
         the integer typed point coordinates does not have the slope rate calculated
         well; e.g. 2/5 == 0 after integer operation. This won't give us any
         reliable slope results. Forcing the integers to be doubles won't help much
         due to precision digits and the syntax will be utterly ugly.
         So, solution: use another way to compare the slope rate formula:
         Let's say there are 3 points: p1, p2 and p3. Slope rate between p1&p2 must be
         equal to p1&p3 to pass. To calculate slope rate of p1-p2, we have
         p2[1] - p1[1]/p2[0] - p1[0] == p3[1] - p1[1]/p3[0] - p1[0]
         Instead of comparing the division results, we can compare multiplications:
         (p2[1] - p1[1])*p3[0] - p1[0] == (p3[1] - p1[1])*(p2[0] - p1[0])
         This will make it utterly easier.
         */
        //int[] offset = coordinates[0];
        int i = 1;
        while(i < coordinates.length) {
            int[] p1 = coordinates[0];
            int[] p2 = coordinates[1];
            int[] pi = coordinates[i];
            if((p2[1] - p1[1] == 0 && pi[1] - p1[1] != 0) ||
                    (p2[1] - p1[1] != 0 && pi[1] - p1[1] == 0)) {
                System.out.println("Vertical line:" + i);
                return false;
            }
            if(
                    (p2[0] - p1[0])*(pi[1] - p1[1]) ==
                            (pi[0] - p1[0])*(p2[1] - p1[1])
            ) {
//                System.out.println("Angle matched; Next:" + i);
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates1 =
                {{1,-8},{2,-3},{1,2}};
        int[][] coordinates2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates3 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        CheckIfIsStraightLine sol = new CheckIfIsStraightLine();
        System.out.println("coordinates 1 should be false:"+ sol.checkStraightLine(coordinates1));
        System.out.println("coordinates 2 should be true:"+ sol.checkStraightLine(coordinates2));
        System.out.println("coordinates 3 should be false:"+ sol.checkStraightLine(coordinates3));

    }
}
