package com.sort;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2019/11/25
 * <p>
 * <p>
 * 卡主的点：
 * <p>
 * merge 函数：
 * <p>
 * 1.先将左右的两部分拆成两个小数组？还是在原有数组上操作?
 * 2.边界
 * 3.剩余数组如何处理
 * <p>
 * <p>
 * <p>
 * <p>
 * 2.
 */
public class MergeSort {

    public static void main(String[] args) {
        int a[] = new int[]{4, 5, 1, 2, 7, 8};
        sort(a);
        System.out.println(a);
    }

    public static void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int p, int r) {

        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        mergeTwoArray(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {

        int i = p;
        int j = q + 1;

        int[] tmp = new int[r - p + 1];
        int k = 0;

        while (i <= q && j <= r) {
            /**
             * 如果两者相等，左边的元素顺序要比右边的靠前
             */
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }


        }
        // 判断两个数组还有哪个升序
        int start = i, end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = a[start++];
        }


        // 将临时数组放回原来数组

        for (int l = 0; l < tmp.length; l++) {
            a[p + l] = tmp[l];
        }


    }

    public static void mergeTwoArray(int[] a, int p, int q, int r) {
        int left[] = new int[q - p + 1];
        int right[] = new int[r - q];

        for (int i = p; i <= q; i++) {
            left[i - p] = a[i];
        }

        for (int i = q + 1; i <= r; i++) {
            right[i - q - 1] = a[i];
        }

        // 比较两个小数组

        int i = 0, j = 0;


        int start = p;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                a[start++] = left[i++];
            } else {
                a[start++] = right[j++];
            }
        }

        // 剩余数组

        if (i < left.length) {
            while (i < left.length) {
                a[start++] = left[i++];
            }
        } else {
            while (j < right.length) {
                a[start++] = right[j++];
            }
        }


    }


}
