package 括号问题.计算字符串;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "5*(4+6)";

        char[] chars = s.toCharArray();
        System.out.println(getAns(chars));
    }

    private static int getAns(char[] chars) {
        int ans;
        ans = process(chars, 0)[0];
        return ans;
    }
    private static int[] process(char[] chars, int i) {
        Stack<String> stack = new Stack<>();
        int[] ans;
        int base = 0;
        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' && chars[i] <= '9') {
                base = base * 10 + chars[i++] - '0';
            } else if (chars[i] != '(') {
                addStack(stack, base);
                stack.push(String.valueOf(chars[i++]));
                base = 0;
            } else {
                ans = process(chars, i + 1);
                base = ans[0];
                i = ans[1] + 1;
            }
        }
        addStack(stack, base);
        return new int[]{getSum(stack), i};
    }

    private static int getSum(Stack<String> stack) {
        while (stack.size() >= 3) {
            String num1 = stack.pop();
            String str = stack.pop();
            String num2 = stack.pop();
            int tempans = "+".equals(str) ? Integer.parseInt(num1) + Integer.parseInt(num2) : Integer.parseInt(num2) - Integer.parseInt(num1);
            stack.push(String.valueOf(tempans));
        }
        return Integer.parseInt(stack.peek());
    }
    private static void addStack(Stack<String> stack, int base) {
        if (!stack.isEmpty()) {
            String str = stack.pop();
            if ("+".equals(str) || "-".equals(str)) {
                stack.push(str);
            } else {
                base = "*".equals(str) ? (base * Integer.parseInt(stack.pop())) : (base / Integer.parseInt(stack.pop()));
            }
        }
        stack.push(String.valueOf(base));
    }
}
