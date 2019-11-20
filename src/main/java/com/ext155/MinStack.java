package com.ext155;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2019/11/5
 */
public class MinStack {


    private List<Integer> arrayStack;

    private int minNum;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        arrayStack = new ArrayList<>();
        minNum = 0;
    }

    public void push(int x) {
        if (arrayStack.isEmpty()) {
            minNum = x;
        }
        minNum = Math.min(minNum, x);
        arrayStack.add(x);
    }

    public void pop() {
        // 删除栈顶元素，最小元素需要变动
        if (arrayStack.isEmpty()) {
            return;
        }
        Integer remove = arrayStack.remove(arrayStack.size() - 1);
        // 栈顶元素是最小值的话，需要重新搜索最小值
        if (remove == minNum) {
            searchMinNum();
        }


    }

    private void searchMinNum() {
        if (arrayStack.isEmpty()) {
            return;
        }
        int num = arrayStack.get(0);
        for (int i = 1; i < arrayStack.size(); i++) {
            num = Math.min(num, arrayStack.get(i));

        }
        minNum = num;

    }

    public int top() {
        if (arrayStack.isEmpty()) {
            return 0;
        }
        return arrayStack.get(arrayStack.size() - 1);
    }

    public int getMin() {
        return minNum;
    }
}
