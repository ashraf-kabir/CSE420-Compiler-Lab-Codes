package LabQuiz01;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class LabQuiz01 {

    public static void main(String[] args) {

        try {
            File f = new File("input.txt");
            Scanner sc = new Scanner(f);

            System.out.println("Methods:");

            while (sc.hasNextLine()) {
                Stack<String> x = new Stack<String>();
                String str1 = "";
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

            }

        } catch (Exception e) {

        }
    }

}