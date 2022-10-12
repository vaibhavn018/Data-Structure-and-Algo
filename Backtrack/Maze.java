import java.util.*;

import javax.management.Query;

public class Maze {

    public static void main(String[] args) {
        int n = 3;
        int[][] maze1 = {
                { 1, 1, 1, 0 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 1 }
        };

        int [][] maze = new int[n][n];

        // System.out.println(rat1(maze1, 0, 0, ""));

        String[] name = {"ab", "ab" , "abc"};
        for(int i=0;i<3;i++) {
            if(i>0 && name[i].equals(name[i-1])) {
                continue;
            }
            for(int j=0;j<1;j++) {
                System.out.println(j);
            }
            System.out.println(name[i]);
        }

    }

    static int rat1(int [][] n, int i, int j, String p) {
        if (i == n.length - 1 && j == n.length - 1) {
            System.out.println(p);
            return 1;
        }
        if(n[i][j] == 0) {
            return 0;
        }
        int answer =0;
        // if(i<n.length && j<n.length) {
        //     answer += rat1(n, i+1, j+1, p + "S");
        // }
        if(i<n.length-1 ) {
            answer += rat1(n, i + 1, j, p + "D");
        }
        if(j<n.length-1) {
            answer += rat1(n, i, j + 1, p + "R");
        }

        return answer;
    }
}
