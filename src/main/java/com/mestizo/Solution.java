package com.mestizo;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    static int[][] boxBlur(int[][] image) {
        int[][] result = new int[image.length-2][image[0].length-2];

        return result;
    }


    public static void main(String[] args) {

        int[][] newArray = {{36, 0, 18, 9, 9, 45, 27},
                {27, 0, 54, 9, 0, 63, 90},
                {81, 63, 72, 45, 18, 27, 0},
                {0, 0, 9, 81, 27, 18, 45},
                {45, 45, 27, 27, 90, 81, 72},
                {45, 18, 9, 0, 9, 18, 45},
                {27, 81, 36, 63, 63, 72, 81}
        };


        int[][] array = {
                {7, 4, 0, 1},
                {5, 6, 2, 2},
                {6, 10, 7, 8},
                {1, 4, 2, 0}
        };

        int result[][] = boxBlur(array);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();

        }
    }
}
