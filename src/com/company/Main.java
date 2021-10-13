/**
 * Java 1. Homework 3
 *
 * @author NatalieDan
 * @version 12.10.2021
 */

import java.util.Arrays;

public class HomeWork3 {

    public static void main(String[] args) {

        int [] arr1 = {1,1,1,0,0,0,1,0,0};
        System.out.println(Arrays.toString(arr1));
        change(arr1);
        System.out.println(Arrays.toString(arr1));

        int [] arr2 = massive();
        System.out.println(Arrays.toString(arr2));

        int [] arr3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        System.out.println(Arrays.toString(arr3));
        checks(arr3);
        System.out.println(Arrays.toString(arr3));

        int [][] arr4 = new int[10][10];
        diagonal(arr4);
        for (int i=0;i< arr4.length;i++){
            for (int j=0;j< arr4[i].length;j++){
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }

        int[] arr5 = vector(10, 8);
        System.out.println(Arrays.toString(arr5));

        int [] arr6 = {2,7,9,5,3,0,66};
        int [] m = findMinMax(arr6);
        System.out.println("Min = " + m[0] + " Max = " + m[1]);

        int [] arr7 = {5,2,5,7,9,0,2};
        System.out.println(Arrays.toString(arr7) + " " + isPoint(arr7));
        int [] arr77 = {0,1,3,2,1,1,6};
        System.out.println(Arrays.toString(arr77) + " " + isPoint(arr77));

        int [] arr8 = {2,3,4,5,6,7};
        int n = 3;
        System.out.println(Arrays.toString(arr8));
        shiftRL(arr8, n);
        System.out.println(Arrays.toString(arr8));
        int v = -2;
        shiftRL(arr8, v);
        System.out.println(Arrays.toString(arr8));


    }

    static void change(int[] arr){
        for (int i=0; i<arr.length; i++){
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    static int[] massive(){
        int [] arr = new int [100];
        for (int i=0; i<arr.length; i++){
            arr[i]=i+1;
        }
        return arr;
    }

    static void checks(int [] arr){
        for (int i=0; i<arr.length; i++){
            if (arr[i]<6) arr[i]=arr[i]*2;
        }
    }

    static void diagonal(int [][] arr){
        for (int i=0; i<arr.length; i++){
            arr[i][i] = 1;
            arr[i][arr.length-i-1] = 1;
        }
    }

    static int[] vector(int len, int initialValue){
        int arr[] = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    static int[] findMinMax(int [] arr){
        int [] m = new int[2];
        m[0] = arr[0];
        m[1] = arr[0];
        for (int i=1; i<arr.length; i++){
            if (arr[i]<m[0]) m[0]=arr[i];
            if (arr[i]>m[1]) m[1]=arr[i];
        }
        return m;
    }

    static boolean isPoint(int [] arr){
        int z = 0;
        int sumLeft = 0;
        int sumRight = 0;
        for (int i=0; i<arr.length; i++){
            sumLeft = sumLeft + arr[i];
            sumRight = 0;
            for (int j=i+1; j< arr.length; j++) sumRight = sumRight + arr[j];
            if (sumLeft == sumRight) z=1;
        }
        return z == 1;
    }

    static void shiftRL(int[] arr, int n){
        int z;
        if (n > 0) {
            for (int i = 0; i < Math.abs(n); i++) {
                z = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) arr[j] = arr[j - 1];
                arr[0] = z;
            }
        } else{
            for (int i = 0; i < Math.abs(n); i++) {
                z = arr[0];
                for (int j = 0; j < arr.length - 1; j++) arr[j] = arr[j + 1];
                arr[arr.length-1] = z;
            }
        }
    }
}

