package LabFinal;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.*;

public class task01 {


    public static void main(String[] args) throws FileNotFoundException {

        HashSet<String> num = new HashSet<String>();

        URL url = task01.class.getResource("input.txt");
        File f = new File(url.getPath());
        //File f = new File("E:\\workspaces\\CSE420-Lab\\src\\LabFinal\\input.txt");
        Scanner sc = new Scanner(f);
        String s = sc.next();
        int n = ((int) (s.charAt(0))) - 48;   //Number of regular expression

        int counter = 0;
        int counter2 = 0;
        int m = 0;

        String[] a = new String[n];  //Array for regular expression
        String[] b = new String[m];  //Array for input string


        while (sc.hasNext()) {
            //Loop for updating the values of RE array and input array
            s = sc.next();

            if (counter >= 0 && counter < n) {
                a[counter] = s;
            } else if (counter == n) {
                m = ((int) (s.charAt(0))) - 48;   //Number of input string
                b = new String[m];
            } else if (counter > (n) && counter <= (n + m)) {
                b[counter2] = s;
                counter2++;
            }
            counter++;
        }

        for (int i = 0; i < m; i++) {
            int match = 0;

            for (int j = 0; j < n; j++) {
                if (Pattern.matches(a[j], b[i])) {
                    if (s.matches("[0-9]*[.0-9]?[0-9]*")) {
                        num.add(s);
                        System.out.println("Digit, " + (j + 1));
                        match++;
                        //System.out.println("YES, " + (match));
                        //Matching input string with RE
                    }
                }
            }

            if (match == 0) {
                System.out.println("NO, 0");
            }
        }
    }
}
