package LabQuiz01;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class LabQuiz01 {

    public static void main(String[] args) {

        try {
            File f = new File("E:\\workspaces\\CSE420-Lab\\src\\LabQuiz01\\input.txt");
            Scanner sc = new Scanner(f);

            System.out.println("Methods:");

            while (sc.hasNextLine()) {
                Stack<String> x = new Stack<String>();
                String s = "";
                String str2 = sc.nextLine();

                if (str2.contains(".") || str2.contains(("=")) || str2.contains("if")
                        || str2.contains("else") || str2.contains("for") || str2.contains("while")) {
                    // checking if it is loop, condition or function

                } else if (str2.contains("(") && str2.contains(")")) {
                    // for checking any parentheses
                    StringTokenizer token = new StringTokenizer(str2, " ()", true);
                    while (token.hasMoreTokens()) {
                        try {
                            x.push(token.nextToken());
                        } catch (Exception e) {
                            System.out.println("Dead  >  " + e);
                        }
                    }
                } else {
                }

                while (!x.empty()) {
                    try {
                        String z = (String) x.pop();
                        if (z.equals("(")) {
                            s = z + s;
                            while (x.peek().equals(" ")) {
                                x.pop();
                            }
                            s = (String) x.pop() + s;
                            System.out.print(s.trim() + ", ");
                            //trim() function is used to remove space
                            while (x.peek().equals(" ")) {
                                x.pop();
                            }
                            System.out.println("return type: " + (String) x.pop());
                            break;
                        } else {
                            s = z + s;
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}