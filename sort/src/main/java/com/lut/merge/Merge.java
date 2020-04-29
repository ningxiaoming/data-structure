package com.lut.merge;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {5,6,2,8,1,7,3,4};
//        merge(arr,0,4,7);
    merge_sort(arr,0,7);
/*        for (int l1 = 0; l1 < arr.length; l1++) {
            System.out.print(arr[l1]+"  ");

        }*/
    }

    public static void merge_sort(int[] arr,int l,int r){
//        System.out.println("**********");
        if (l==r){
            return;
        }else {
            int m = (l + r) / 2;
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);
            merge(arr, l, m+1, r);
        }
    }

    //分治
    public static void merge(int[] arr,int l,int m,int r){
        //1.将左右排好序的数组分成两个数组；  然后两个数组中个每个元素进行比较，小的元素放到arr中；
        int LEFT_SIZE = m-l;
        int RIGHT_SIZE = r-m+1;
        int[] left = new int[LEFT_SIZE];
        int[] right = new int[RIGHT_SIZE];
        for (int i = l; i < m; i++) {
            left[i-l] = arr[i];
        }
        for (int i = m; i <= r; i++) {
            right[i-m] = arr[i];
        }
        int i = 0;int j = 0;int k = l;
        while (i < LEFT_SIZE && j < RIGHT_SIZE){
            if (left[i] < right[j]){
                arr[k] = left[i];
                i++;
                k++;
            }else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < LEFT_SIZE){
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < RIGHT_SIZE){
            arr[k] = right[j];
            k++;
            j++;
        }
    }
}
