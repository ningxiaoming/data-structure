package com.lut.tree;


/*
    关于堆排序；
        1：构造一个堆
        2：然后依次将这个堆的第一个元素和最后一个元素交换；交换完 堆的元素 --；

 */
public class Heap {
    public static void main(String[] args) {
//        int[] tree = {2,5,3,1,10,4,88};
        int[] tree = {4,10,3,5,1,2};
//        build_heap(tree,6);
        heapify(tree,6,0);
//        heap_sort(tree,6);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i]+" ");
        }
    }

    public static void heap_sort(int[] tree,int n){
        build_heap(tree,n);
        for (int i = n-1; i >= 0; i--) {
            swap(tree,0,i);
            heapify(tree,i,0);
        }
    }

    public static void build_heap(int[] tree,int n){
        int last_node = n-1;
        int parent = (last_node-1)/2;
        for (int i = parent; i >= 0 ; i--) {
            heapify(tree,n,i);
        }
    }

    // n表示树的节点的数量，i表示要交换的节点
    public static void heapify(int[] tree,int n,int i){
        if (i>=n){
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        System.out.println(c1+"   ****"+i);
        int max = i;
        if (c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if (c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        if (max != i){
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }

    public static void swap(int[] tree,int n,int i){
        int temp = tree[n];
        tree[n] = tree[i];
        tree[i] = temp;
    }
}
