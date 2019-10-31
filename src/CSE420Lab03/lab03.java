package CSE420Lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

public class lab03 {

    public static void main(String[] args) throws FileNotFoundException {

        URL url = lab03.class.getResource("input_lab03.txt");
        File f = new File(url.getPath());
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
                    //Matching input string with RE
                    System.out.println("YES, " + (j + 1));
                    match++;
                }
            }
            if (match == 0) {
                System.out.println("NO, 0");
            }
        }
    }

}
