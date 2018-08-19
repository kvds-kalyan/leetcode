package leetcode;

import java.util.Arrays;

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if(m==0)
            return false;

        int n = matrix[0].length;
        if(n==0)
            return false;

        int candidateRowNum = searchRow(matrix,target);

        if(candidateRowNum >=m)
            return false;

        int[] candidateRow = matrix[candidateRowNum];
        return Arrays.binarySearch(candidateRow,target)>=0;


    }

    public static int searchRow(int[][] nums, int target) {
        int i=0;
        int j=nums.length-1;

        int m = nums[0].length;

        while(i<=j){
            int mid = (i+j)/2;

            if(target > nums[mid][m-1]){
                i=mid+1;
            }else if(target < nums[mid][m-1]){
                j=mid-1;
            }else{
                return mid;
            }
        }

        return i;
    }




    public static void main(String[] args) {
        int arr[][] = {};
        System.out.println(searchMatrix(arr,0));
    }
}
