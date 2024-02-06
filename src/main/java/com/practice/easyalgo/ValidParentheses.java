package com.practice.easyalgo;

import java.util.*;

public class ValidParentheses {
    public static void main(String args[]){
        String a = "{[[]{}]}";
        ValidParentheses sol = new ValidParentheses();
        System.out.printf("%b\n", sol.isValid("{[[]{}]}"));
        System.out.printf("%b\n", sol.isValid("()[]{}"));
        System.out.printf("%b\n", sol.isValid("(]"));
        System.out.printf("%b\n", sol.isValid("]"));
        System.out.printf("%b\n", sol.isValid(""));


    }

    public boolean isValid(String s) {
        if(s==null) return true;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> braces = new HashMap()
        {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        for(char ch : s.toCharArray()){
            if (braces.containsKey(ch)){
                if(stack.isEmpty() || !stack.pop().equals(braces.get(ch))) return false;
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
