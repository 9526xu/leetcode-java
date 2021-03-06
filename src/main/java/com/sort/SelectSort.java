package com.sort;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2019/11/21
 */
public class SelectSort {

    public static void main(String[] args) {
        int a[] = new int[]{4, 5, 1, 2, 7, 8};
        selectSort(a);
        System.out.println(a);
    }

    public static void selectSort(int[] a) {
        if ((a == null) || (a.length == 0)) {
            return;
        }

        for (int i = 0; i < a.length; i++) {

            int index = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[index] > a[j]) {
                    index = j;
                }
            }

            int tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;


        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
