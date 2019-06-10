package otherProblems;

import java.util.Stack;

public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    maxArea = Math.max(maxArea,calculateArea( i,  j,matrix));
                }
            }
        }

        return maxArea;
    }

    public int calculateArea(int i,int j,char[][] matrix){
        int length = 1;
        int height = 1;

        height = calculateHeight( i, j, matrix);
        // Boundary
        if(j==matrix[0].length-1)
            return length*calculateHeight(i, j, matrix);

        if(i== matrix.length-1){
            length = calculateLength( i, j, matrix);
            return length*height;
        }

        boolean foundExit = false;

            for(int y=j+1;y<matrix[0].length;y++){

                if(matrix[i][y] == '1'){

                    int localHeight = calculateHeight( i,  y, matrix);

                    if(localHeight<height){
                        if(height*length <= localHeight*(length+1)){
                            height = localHeight;
                            length++;
                        }

                    }else {
                        length++;
                    }

                }else{
                    foundExit = true;
                    break;
                }
            }


        return length*height;
    }

    public int calculateHeight(int i,int j,char [][] matrix){
        int height = 0;

        int index = i;

        while(i<matrix.length){

            if(matrix[i][j] == '1') {
                height++;
                i++;
            }
            else break;
        }

        return height;
    }

    public int calculateLength(int i,int j,char [][] matrix){
        int length =0;

        while(j< matrix[0].length){

            if(matrix[i][j] == '1') {
                length++;
                j++;
            }
            else break;
        }

        return length;
    }

    public static void main(String[] args){
        char [][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        MaximumRectangle maximumRectangle = new MaximumRectangle();
//       System.out.print( maximumRectangle.maximalRectangle(matrix));
//
//        matrix = new char[][]{
//                {'1', '1'},
//                {'1', '1'}};
//
//        System.out.print( maximumRectangle.maximalRectangle(matrix));

        matrix =  new char[][]{{'1','1','1','1','1','1','1','1'},
                                {'1','1','1','1','1','1','1','0'},
                                {'1','1','1','1','1','1','1','0'},
                                {'1','1','1','1','1','0','0','0'},
                                {'0','1','1','1','1','0','0','0'}};

       System.out.print( maximumRectangle.maximalRectangle(matrix));
    }
}
