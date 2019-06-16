package CSE420Lab02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many email/web do you want to check?");
        int counter = sc.nextInt();
        String word[] = new String[counter];
        for (int i = 0; i < counter; i++) {
            word[i] = sc.next().toLowerCase();
        }
        for (int i = 0; i < counter; i++) {
            if (emailCheck(word[i])) {
                System.out.println("Email: " + (i + 1));
            } else if (websiteCheck(word[i])) {
                System.out.println("Web: " + (i + 1));
            } else {
                System.out.println("Error: " + (i + 1));
            }
        }

    }

    public static Character[] alphabetCheck = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static List<Character> alphabet = Arrays.asList(alphabetCheck);
    public static Character[] numeric = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '~', '!', '@', '#', '$', '^', '&', '*', '(', ')', '+', '<', '>', '?', '/'};
    public static List<Character> numericAndSings = Arrays.asList(numeric);
    public static String[] mailCheck = {"gmail.com", "yahoo.com", "hotmail.com", "aol.com", "msn.com", "g.bracu.ac.bd", "bracu.ac.bd"};
    public static List<String> mail = Arrays.asList(mailCheck);
    public static String[] webDomainCheck = {"com", "net", "org", "uk", "bd", "us", "ac"};
    public static List<String> webDCheck = Arrays.asList(webDomainCheck);


    static boolean startsWith(String word, List<Character> numericAndSings, String en) {
        if (en.equals("web")) {
            if (numericAndSings.contains(word.charAt(4)))
                return true;
        } else if (en.equals("email")) {
            if (numericAndSings.contains(word.charAt(0)))
                return true;
        }
        return false;
    }

    static boolean websiteCheck(String word) {
        int state = 0;
        boolean check = false;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            switch (state) {
                case 0:
                    if (startsWith(word, numericAndSings, "web")) {
                        break;
                    } else if (c == 'w') {
                        continue;
                    } else if (c == '.') {
                        state = 1;
                        continue;
                    }
                case 1:
                    if (alphabet.contains(c)) {
                        continue;
                    } else if (c == '.') {
                        state = 2;
                    }
                case 2:
                    int size = word.substring(i).length();
                    if (size <= 3 && webDCheck.contains(word.substring(i))) {
                        return true;

                    } else {
                        if (webDCheck.contains(word.substring(i, (i + 3)))) {
                            i = i + 3;
                            continue;
                        } else if (webDCheck.contains(word.substring(i, (i + 2)))) {
                            i = i + 2;
                            continue;
                        }
                    }

            }
        }
        return check;
    }

    static boolean emailCheck(String word) {
        int state = 0;
        boolean check = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            switch (state) {
                case 0:
                    if (startsWith(word, numericAndSings, "email")) {
                        break;
                    } else if (alphabet.contains(c) || c == '.')
                        continue;
                    else if (c == '@')
                        state = 1;
                    continue;

                case 1:
                    String subWord = word.substring(i, word.length());
                    if (mail.contains(subWord)) {
                        check = true;
                        break;
                    }


            }
        }
        return check;
    }
}
