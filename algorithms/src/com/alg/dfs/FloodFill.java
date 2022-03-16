package com.alg.dfs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //
        int currentColor = image[sr][sc];
        if(currentColor != newColor){
            searchAndFill(image, sr, sc, currentColor, newColor);
        }

        return image;
    }

    private void searchAndFill (int[][] image, int sr, int sc, int currentColor, int newColor) {
        //check if current color is same with previous color from caller, if yes, then they are considered
        //same patch of color block, and should be filled. Else, don't fill it. After filling it with new
        //color, this won't be visited back again (e.g. move up then down again, back to the same cell)
        if(image[sr][sc] == currentColor){
            image[sr][sc] = newColor;
            if(sr > 0){
                searchAndFill(image, (sr - 1), sc, currentColor, newColor);
            }
            if(sr < image.length - 1){
                searchAndFill(image, (sr + 1), sc, currentColor, newColor);
            }
            if(sc > 0){
                searchAndFill(image, sr, sc - 1, currentColor, newColor);
            }
            if(sc < image[0].length - 1){
                searchAndFill(image, sr, sc + 1, currentColor, newColor);
            }
        }
    }
}
