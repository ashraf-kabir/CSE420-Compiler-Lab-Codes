package CSE420Lab01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class task01a {

    public static boolean isOthers(String s) {
        String[] p = {",", ";", "(", ")", "{", "}", "[", "]"};
        for (int i = 0; i <= p.length; i++) {
            if (s.equals(p[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLogicalOperator(String s) {
        String[] p = {">", "<", ">=", "<=", "==", "!="};
        for (int i = 0; i <= p.length; i++) {
            if (s.equals(p[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMathOperator(String s) {
        String[] p = {"+", "-", "*", "/"};
        for (int i = 0; i <= p.length; i++) {
            if (s.equals(p[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKeyWord(String s) {
        String[] p = {"if", "else", "public", "private"};
        for (int i = 0; i <= p.length; i++) {
            if (s.equals(p[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String s) {
        String[] p = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i <= p.length; i++) {
            if (s.equals(p[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIdentifier(String s) {
        String[] p = {"if", "else", "", ""};
        for (int i = 0; i <= p.length; i++) {
            if (s.equals(p[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        HashSet<String> keywords = new HashSet<String>();
        HashSet<String> math = new HashSet<String>();
        HashSet<String> log = new HashSet<String>();
        HashSet<String> num = new HashSet<String>();
        HashSet<String> others = new HashSet<String>();
        HashSet<String> id = new HashSet<String>();

        //readFromFile("task1");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader("src\\CSE420Lab01\\task1.txt"));
            while ((line = br.readLine()) != null) {
                if (isOthers(line)) {
                    others.add(line);
                } else if (isLogicalOperator(line)) {
                    log.add(line);
                } else if (isMathOperator(line)) {
                    math.add(line);
                } else if (isKeyWord(line)) {
                    keywords.add(line);
                } else if (isNumeric(line)) {
                    num.add(line);
                } else {
                    id.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
