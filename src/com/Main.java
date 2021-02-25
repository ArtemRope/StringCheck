package com;


import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String checkedString;
            while ((checkedString = reader.readLine()) != "") {
                System.out.println(check(checkedString));
            }
        }catch (IOException e){

        }
    }

    static boolean check (String checkedString){
        Stack<Character> stack = new Stack<>();
        for (char c: checkedString.toCharArray()){
            switch (c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
            }
        }
        if (!stack.empty()){
            return false;
        }
        return true;
    }
}
