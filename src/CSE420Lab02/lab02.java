package CSE420Lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lab02 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("E:\\workspaces\\CSE420-Lab\\src\\CSE420Lab02\\input_lab02.txt");
        Scanner sc = new Scanner(f);
        String s = "";

        int pCount = 0;  // For printing

        while (sc.hasNext()) {
            s = sc.next().toLowerCase();
            char c = s.charAt(0);
            int n = (int) c;
            int p = 0;

            String s2 = s.substring(4);

            if (s.length() > 8 && s.startsWith("www.") && s2.contains(".")) {          //Conditions for checking valid web address
                for (int i = 4; i < s.length(); i++) {
                    int t = (int) (s.charAt(i));

                    if (s.length() > i + 1) {
                        p = (int) (s.charAt(i + 1));
                    }

                    if ((int) (s.charAt(4)) == 46) {
                        pCount++;
                        System.out.println(pCount + ": Invalid web address!");
                        break;
                    } else if ((t > 96 && t < 123) || (t > 47 && t < 58)) {       //Letter and number
                        continue;
                    } else if (t == 46) {
                        if (p == 46) {
                            pCount++;
                            System.out.println(pCount + ": Invalid web address!");
                            break;
                        } else {
                            int lastin = s.lastIndexOf(".");
                            String g = s.substring(i + 1);
                            if (s.length() > lastin && g.length() >= 2) {
                                pCount++;
                                System.out.println(pCount + ": Valid web address.");
                                break;
                            } else {
                                pCount++;
                                System.out.println(pCount + ": Invalid web address!");
                                break;
                            }
                        }
                    } else if (t == 64) {
                        pCount++;
                        System.out.println(pCount + ": Invalid web address or email id!");
                        break;
                    }
                }
            } else if (s.contains("@") && s.contains(".")) {          //Conditions for checking valid mail id
                if ((n > 96 && n < 123)) {
                    for (int i = 0; i < s.length(); i++) {
                        int t = (int) (s.charAt(i));

                        if (s.length() > i + 1) {
                            p = (int) (s.charAt(i + 1));
                        }

                        if ((t > 96 && t < 123) || (t > 47 && t < 58) || (t == 46)) {  //Letter, number and dot
                            continue;
                        } else if (t == 64) {
                            if (p == 46 || p == 64) {
                                pCount++;
                                System.out.println(pCount + ": Invalid email id!");
                                break;
                            } else {
                                String g = s.substring(i + 1);
                                if (g.contains(".")) {
                                    pCount++;
                                    System.out.println(pCount + ": Valid email id.");
                                } else {
                                    pCount++;
                                    System.out.println(pCount + ": Invalid email id!");
                                }
                            }
                        }
                    }
                } else {
                    pCount++;
                    System.out.println(pCount + ": Invalid email id!");
                }
            } else if (s.endsWith(".com")) {              //Conditions for checking invalid web address
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    int t = (int) (s.charAt(i));
                    if (t == 64) {
                        count++;
                    }
                }

                if (count == 0) {
                    pCount++;
                    System.out.println(pCount + ": Invalid web address!");
                }
            } else {
                pCount++;
                System.out.println(pCount + ": Invalid web address or email id!");
            }
        }
    }
}
