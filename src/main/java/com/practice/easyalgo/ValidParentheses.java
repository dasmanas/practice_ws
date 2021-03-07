package com.practice.easyalgo;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String args[]){

        String a = "{[[]{}]}";
        Stack<Character> stack = new Stack<>();

        Set<Character> left = new HashSet<>();
        Set<Character> right = new HashSet<>();

        left.add('(');
        left.add('{');
        left.add('[');

        right.add(')');
        right.add('}');
        right.add(']');

        char[] braces = a.toCharArray();
        int len = braces.length;
        for (int i = 0; i < len; i++) {
            char ch = braces[i];
            if (left.contains(ch)) {
                stack.push(ch);
            } else if (right.contains(ch) && stack.pop()=='a'){

            } else{

            }
        }




    }
}
