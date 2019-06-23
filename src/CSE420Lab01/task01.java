package CSE420Lab01;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;

public class task01 {

    public static final String idWithCommaRegx = "^(int|float|String|double|byte|char)[ ]+[^\\d\\s](([{[\\w$_]*]*)*)(,?[ ]*(([{[\\w$_]*]*)*))*;";
    public static final String idWithValueRegx = "(char|int|double|String|byte)[ ]+[^\\d\\s](([{[\\w$_]*]*)*)[ ]*=[ ]*([.]*)";
    public static final String numericValuesRegx = "([-]?([\\d]*[\\.]?[\\d]+))";
    public static final String stringRegx = "\"[.]*\"";
    public static final String charRegx = "'[\\w\\d\\s\\S.]'";
    public static final String keywordsRegx = "(byte|short|int|float|double|long|char|boolean|String|if|else|else if|for|public|static|void|main)";
    public static final String mathOpRegx = "(\\*)|(\\+\\+)|\\/|\\%|(\\-\\-)|\\-|\\=|\\+";
    public static final String compOpRegx = "(>=)|(==)|(<=)|<|>";
    public static final String OtherRegx = "[\\{\\}\\(\\)\\[\\]\\;]";


    public static Set<String> keySet = new HashSet<String>();
    public static Set<String> mathOpSet = new HashSet<String>();
    public static Set<String> compOpSet = new HashSet<String>();
    public static Set<String> numSet = new HashSet<String>();
    public static Set<String> otherSet = new HashSet<String>();
    public static Set<String> idSet = new HashSet<String>();


    public static String idParserforValue(String str) {
        str = str.replaceAll("(int|float|String|double|byte|char)", "").replaceAll("\\=", "");
        return str;
    }

    public static String idParserforComma(String str) {
        str = str.replaceAll("(int|float|String|double|byte|char)", "").replaceAll(" ", "").replaceAll(",", " ").replaceAll(";", "");
        return str;
    }

    public static void Setting(String str, Set<String> ss) {
        String strArr[] = str.split(" ");
        for (String s : strArr) ss.add(s);
    }

    // print function
    public static void printFunc(String str, Set<String> ls) {
        System.out.print(str + ":");
        for (String l : ls) {
            System.out.print(" " + l);
        }
        System.out.println();
    }

    // math operator check
    public static boolean mathOpChecker(String str) {
        String theRegex = mathOpRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                Setting(regexMatcher.group().trim(), mathOpSet);
                ret = true;
            }
        }
        return ret;
    }

    // numeric value check
    public static boolean numericChecker(String str) {
        String theRegex = numericValuesRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                Setting(regexMatcher.group().trim(), numSet);
                ret = true;
            }
        }
        return ret;
    }

    // identifier check
    public static boolean identifierWithValueChecker(String str) {
        String theRegex = idWithValueRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                String strr = regexMatcher.group().trim();
                strr = idParserforValue(strr);
                Setting(strr, idSet);
                ret = true;
            }
        }
        return ret;
    }

    // identify comma.... it did not work
    public static boolean identifiercommaChecker(String str) {
        String theRegex = idWithCommaRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                String strr = regexMatcher.group().trim();
                strr = idParserforComma(strr);
                Setting(strr, idSet);
                ret = true;
            }
        }
        return ret;
    }

    // others check
    public static boolean othersChecker(String str) {
        String theRegex = OtherRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                Setting(regexMatcher.group().trim(), otherSet);
                ret = true;
            }
        }
        return ret;
    }

    // comparator operator check
    public static boolean compOpChecker(String str) {
        String theRegex = compOpRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                Setting(regexMatcher.group().trim(), compOpSet);
                ret = true;
            }
        }
        return ret;
    }

    // check keywords
    public static boolean keywordChecker(String str) {
        String theRegex = keywordsRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                Setting(regexMatcher.group().trim(), keySet);
                ret = true;
            }
        }
        return ret;
    }

    // checker function which takes string from buffer reader func
    // then pass it to different functions to check
    public static void checker(String str) {
        keywordChecker(str);
        mathOpChecker(str);
        compOpChecker(str);
        othersChecker(str);
        identifierWithValueChecker(str);
        identifiercommaChecker(str);
        numericChecker(str);
    }

    // buffer reader
    public static void readFromFile(String fileName) {
        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader("src\\CSE420Lab01\\" + fileName + ".txt"));
            while ((line = br.readLine()) != null) {
                checker(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // main function
    public static void main(String[] args) {
        readFromFile("task1");
        printFunc("Keywords", keySet);
        printFunc("Identifiers", idSet);
        printFunc("Math Operators", mathOpSet);
        printFunc("Logical Operators", compOpSet);
        printFunc("Numerical Values", numSet);
        printFunc("Others", otherSet);
    }

}
