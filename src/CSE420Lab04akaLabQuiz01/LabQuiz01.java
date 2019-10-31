package CSE420Lab04akaLabQuiz01;

import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class LabQuiz01 {

    public static void main(String[] args) {

        try {
            URL url = LabQuiz01.class.getResource("input.txt");
            File f = new File(url.getPath());
            //File f = new File("E:\\workspaces\\CSE420-Lab\\src\\CSE420Lab04akaLabQuiz01\\input.txt");
            Scanner sc = new Scanner(f);

            System.out.println("Methods:");

            while (sc.hasNextLine()) {
                Stack<String> x = new Stack<String>();
                String str1 = "";
                String str2 = sc.nextLine();

                if (str2.contains(".") || str2.contains(("=")) || str2.contains("if")
                        || str2.contains("else") || str2.contains("for") || str2.contains("while")) {
                    // checking whether it is loop, condition or function

                } else if (str2.contains("(") && str2.contains(")")) {
                    // for checking any parentheses
                    StringTokenizer token = new StringTokenizer(str2, " ()", true);
                    while (token.hasMoreTokens()) {
                        try {
                            x.push(token.nextToken());
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else {
                }

                while (!x.empty()) {
                    try {
                        String z = (String) x.pop();
                        if (z.equals("(")) {
                            str1 = z + str1;
                            while (x.peek().equals(" ")) {
                                x.pop();
                            }
                            str1 = (String) x.pop() + str1;
                            System.out.print(str1.trim() + ", ");
                            //trim() function is used to remove space
                            while (x.peek().equals(" ")) {
                                x.pop();
                            }
                            System.out.println("return type: " + (String) x.pop());
                            break;
                        } else {
                            str1 = z + str1;
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