package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String string = null;
        if (sc.hasNext()) {
            string = sc.nextLine();
        }

        List<Integer> steck2 = new ArrayList<>();
        List<Character> steck = new ArrayList<Character>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                steck.add(ch);
                steck2.add(i);
            } else {
                if (steck.isEmpty() && i == string.length()-1 && (ch == ']' || ch == '}' || ch == ')')){
                    System.out.println(i+1);
                    break;
                }
                if ((ch == ']' || ch == '}' || ch == ')') && steck.isEmpty()){
                    System.out.println(i+1);
                    break;
                }
                if ((ch == ']' || ch == '}' || ch == ')') && !steck.isEmpty()) {
                    char top = steck.get(steck.size() - 1);
                    if (top == '[' && ch == ']' || top == '(' && ch == ')' || top == '{' && ch == '}') {
                        steck.remove(steck.size() - 1);
                        steck2.remove(steck2.size() - 1);
                    } else if (top == '[' && ch != ']' || top == '(' && ch != ')' || top == '{' && ch != '}'){
                        System.out.println(i+1);
                        break;
                    }
                }

            }
            if (i == string.length()-1){
                if (!steck.isEmpty()){

                    System.out.println(steck2.get(steck2.size()-1)+1);
                    break;
                }
                else {
                    System.out.println("Success");
                    break;
                }
            }
        }

    }
}
