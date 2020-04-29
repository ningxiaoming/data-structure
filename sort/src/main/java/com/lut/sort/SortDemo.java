package com.lut.sort;

public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {3,2,7,4,1,6,5};
//        insert_sort(arr);
        System.out.println();
//        bubble_sort(arr);
/*        quick_sort(arr,0,6);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }*/
        select_sort(arr);

    }

    /*
     归并排序
     */


    /*
    插入排序
         插入排序: 思想：它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
         简单来说就是：用一个元素和此元素前面的有序序列对比，若比前面的小那么它前面的元素就往后移一位，
         直到找到比前面某个元素大的或者比到了位置0那么就将该元素插入到当前位置即可。
    */
    public static void insert_sort(int[] arr){
        if (arr.length<=1){
            System.out.println(arr[0]);
        }
        for (int i = 0; i < arr.length-1; i++) {
            int tamp = arr[i+1];
            int index = i;
            while(index>=0&&arr[index]>tamp){
                arr[index+1]=arr[index];
                index--;
            }
            arr[index+1] = tamp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ");
        }
    }
    /*
    冒泡排序
        冒泡排序：取当前位置的元素与后面所以的元素进行比较，若比后面的大则进行位置交换。
        简单来说  就是进行比较，把小的换到前面来
     */
    public static void bubble_sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    int tamp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=tamp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ");
        }
    }
    /*
    快速排序
    实现思想：
        取第一个为基准数temp，取两个指针i，j；分别是第一个下标和最后一个下标；
        然后用arr[j]和temp比较。
    实现步骤：
        i 最开始指向数组的第一个元素，j 最开始指向数组的最后一个元素。
        指针 i 从左向右移动，指针 j 从右向左移动。先移动 j 指针（从右忘左移），
        当 j 指向的数大于基准数时，略过，j 继续往左移动，直到遇到小于等于基准数的数arr[j]，
        将arr[j]填入arr[i]中；再移动 i 指针，当 i 指向的数小于等于基准数时，略过，i 继续往右移动，
        直到遇到比基准数大的数arr[i]，将arr[i]填入arr[j]中；再移动 i 指针，再移动 j 指针...(轮换移动)，
        直到 i 和 j 指针相遇，此时将temp（基准数）填入arr[i]中即完成算法的第2个步骤。
        接下来分别将基准数左边和右边的数组按照以上方法进行聚合，直到每个子集只有一个元素，即排序完成。
     */
    public static void quick_sort(int[] arr,int L,int R){
        if (L>R)
            return;
        int left = L;
        int right = R;
        int pivot = arr[L];
        while (right>left){
            while (right>left&&arr[right]>=pivot)
                right--;
            if (right>left)
                arr[left] = arr[right];
            while(right>left&&pivot>=arr[left])
                left++;
            if (right>left)
                arr[right] = arr[left];
            if (left>=right)
                arr[left] = pivot;
        }
        quick_sort(arr,L,right-1);
        quick_sort(arr,right+1,R);
    }
    /*
    直接选择排序：
        选择第一个与其后的所有元素进行比较，将最小值放在第一个位置
        第一个位置放置好之后，再选择第二个与其后的所有元素进行比较
        再将最小值放再第二个位置
        以此类推，知道最后一个位置也被放置了元素。
     */
    public static void select_sort(int[] arr){
        if (arr==null||arr.length==0)
            return;
        for (int i = 0; i < arr.length; i++) {
            int tamp = arr[i];//存储遍历的最小元素
            int flag = i;//存储最小值的下标
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<tamp){
                    //找到更小的值，将值和位置存储起来
                    tamp = arr[j];
                    flag = j;
                }
            }
            int tamp1 = arr[i];//保存临时arr[i]的值
            arr[i] = arr[flag];
            arr[flag] = tamp1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ");
        }
    }
}
