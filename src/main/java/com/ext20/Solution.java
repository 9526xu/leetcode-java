package com.ext20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2019/11/5
 */
public class Solution {

    private static Map<Character, Character> bracketMap = new HashMap<>();

    static {
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        bracketMap.put(')', '(');
    }


    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            // 是左边的符号入栈
            if (!isRight(chr)) {
                stack.push(chr);
                continue;
            }
            // 如果栈的现有长度已经大于 字符串 1/2，肯定已经无法匹配
            if (stack.size() > s.length() / 2) {
                return false;
            }


            // 右边的符号 弹出栈的元素.如果栈为空，代表无效账号
            if (stack.empty()) {
                return false;
            }
            Character top = stack.pop();
            if (!top.equals(bracketMap.get(chr))) {
                // 不等于 代表不一样
                return false;
            }

            //
        }
        return stack.empty();


    }

    private boolean isRight(char bracket) {
        return bracketMap.containsKey(bracket);
    }


}
