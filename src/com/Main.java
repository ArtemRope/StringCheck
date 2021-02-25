package com;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String checkedString;
            while (!(checkedString = reader.readLine()).equals("")){ // считываем строки из консоли до тех пор, пока не будет введена пустая строка
                System.out.println(check(checkedString));
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    static boolean check (String checkedString){
        Stack<Character> stack = new Stack<>(); // стек в котором хранятся открывающие скобки
        for (char c: checkedString.toCharArray()){ // проверяем каждый символ строки
            switch (c){
                case '{':
                case '[':
                case '(':
                    stack.push(c); // если текущий символ открывающая скобка заносим её в стек
                    break;
                case '}': // если текущий символ закрывающая скобка выполняем проверку
                    if (stack.empty() || stack.pop() != '{') { // если стек пустой (отсутсвуют открывающие скобки) или последняя извлеченная открывающая скобка не соответсвует закрывающие - возвращаем false
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') { // если стек пустой (отсутсвуют открывающие скобки) или последняя извлеченная открывающая скобка не соответсвует закрывающие - возвращаем false
                        return false;
                    }
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') { // если стек пустой (отсутсвуют открывающие скобки) или последняя извлеченная открывающая скобка не соответсвует закрывающие - возвращаем false
                        return false;
                    }
                    break;
            }
        }
        if (!stack.empty()){ // если по окончанию перебора всех символов стек не пустой (остались не закрытые скобки) - возвращаем false
            return false;
        }
        return true;
    }
}
