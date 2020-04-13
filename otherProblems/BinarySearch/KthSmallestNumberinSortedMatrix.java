package otherProblems.BinarySearch;

/**
 * Problem statement
 * Given an N * N matrix where each row and column is sorted in ascending order, find the K-th smallest element in the matrix.
 * https://medium.com/better-programming/three-smart-ways-to-use-binary-search-in-coding-interviews-250ba296cb82
 */
public class KthSmallestNumberinSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        // We will try to traverse binary search for the values instead for the index
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];


        // We will keep track of the smallest and the largest number of the search space
        while (start < end) {
            int mid = start + (end - start) / 2;
            int[] smallLargePair = new int[]{start, end};
            //int count = countLessOrEqual(matrix, smallLargePair, mid);
            int count = countLessOrEqualsR(matrix,mid,smallLargePair,0,0,0);

            if (count == k)
                return smallLargePair[0];

            if (count < k)
                start = smallLargePair[1];
            else
                end = smallLargePair[0];
        }

        return start;
    }

    public static int countLessOrEqual(int[][] matrix, int[] smallLargePair, int mid) {
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;
        int n = matrix.length;

        while (row >= 0 && col < n) {

            if (matrix[row][col] > mid) {
                // as matrix[row][col] is bigger than the mid , let's keep the track of
                // smallest number greater than the mid
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;

    }

    public static int countLessOrEqualsR(int[][] matrix, int mid, int[] smallLargPair, int count, int i, int j) {

        if(i>matrix.length-1 || j>matrix.length-1)
            return count;

            if (matrix[i][j] > mid) {
                smallLargPair[1] = Math.min(smallLargPair[1], matrix[i][j]);
                return count;
            } else {
                smallLargPair[0] = Math.max(smallLargPair[0], matrix[i][j]);
                count = count+1;
                int downcount = 0;
                int rightCount = 0;
                // go right
                downcount = countLessOrEqualsR(matrix, mid, smallLargPair, 0 , i + 1, j);
                // go down
                rightCount = countLessOrEqualsR(matrix, mid, smallLargPair, 0, i , j+1);

                count+=rightCount+downcount;
            }

            return count;
    }


    public static void main(String[] args) {
        int matrix[][] = { { 2,6,8}, {9,12,18 },{11,15,20}};
        int result = KthSmallestNumberinSortedMatrix.findKthSmallest(matrix, 5);
        System.out.println("Kth smallest number is: " + result);
    }
}
