package com.sort;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2019/11/20
 */
public class InsertSort {

    public static void main(String[] args) {
        int a[] = new int[]{4, 5, 1, 2, 7, 8};
        insertSortV2(a);
        System.out.println(a);
    }

    public static void insertSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] > value) {
                    int tmp = a[j];
                    for (int k = j; k < i; k++) {
                        int temp = a[k + 1];
                        a[k + 1] = tmp;
                        tmp = temp;

                    }
                    a[j] = value;
                    break;
                }

            }


        }
    }


    public static void insertSortV2(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {

                    break;
                }
            }
            a[j + 1] = value;


        }
    }
}
