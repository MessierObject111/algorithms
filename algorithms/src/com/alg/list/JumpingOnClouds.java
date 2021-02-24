package com.alg.list;

public class JumpingOnClouds {
    public int jumpingOnClouds(int[] c) {
        if(c.length <= 2) return 1;
        int steps = 0;
        int i = 0;
        while (i < c.length) {
            System.out.println("i:" + i + " step: "+steps);
            steps++;
            if(i + 2 >= c.length - 1) {
                break;
            }
            if(c[i + 2] != 1) {
                i+=2;
                continue;
            }
            if(c[i + 1] != 1) {
                i++;
                continue;
            }

        }
        return steps;
    }

    public static void main(String[] args) {
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};
        JumpingOnClouds s = new JumpingOnClouds();
        int num = s.jumpingOnClouds(clouds);
        System.out.println(num);
        long size = 100l;
        int length = 10;
        if(length > size) {
            long result = length + size;
        }
    }
}
