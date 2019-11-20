package com.sort;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2019/11/20
 */
public class BubbleSort {

    public static void main(String[] args) {
        int a[]=new int[]{4,5,1,2,7,8};
        bubbleSort(a);
        System.out.println(a);
    }

    /**
     * 冒泡排序 升序
     * @param a
     */
    public static void bubbleSort(int[] a){
        if(a==null||a.length==0){
            return;
        }

        for (int i = 0; i <a.length ; i++) {
            boolean flag= false;
            for (int j = 0; j <a.length-i-1 ; j++) {
                if(a[j]>a[j+1]){
                    int tmp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=tmp;
                    flag=true;
                }
            }
            // 一次冒泡中没有数据交换代表以及完全排序
            if(!flag){
                return;
            }
        }


    }
}
