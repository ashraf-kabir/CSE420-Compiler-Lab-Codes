package test01;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;

public class lab01 {

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
    public static Set<String> stringSet = new HashSet<String>();
    public static Set<String> charSet = new HashSet<String>();
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
    public static void printer(String str, Set<String> ls) {
        System.out.print(str + ":");
        for (String l : ls) {
            System.out.print(" " + l);
        }
        System.out.println();
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
    
    // character check
    public static boolean charChecker(String str) {
        String theRegex = charRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                Setting(regexMatcher.group().trim(), charSet);
                ret = true;
            }
        }
        return ret;
    }

    // string check
    public static boolean stringChecker(String str) {
        String theRegex = stringRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                String strr = regexMatcher.group().trim();
                strr = strr.replaceAll(";", "");
                Setting(strr, stringSet);
                ret = true;
            }
        }
        return ret;
    }

    // numeric check
    public static boolean numericChecker(String str) {
        String theRegex = numericValuesRegx;
        boolean ret = false;

        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                //System.out.println(regexMatcher.group().trim());
                Setting(regexMatcher.group().trim(), numSet);
                ret = true;
            }
        }
        return ret;
    }
    
    // value check
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

    // identify comma
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

    public static String parserForNumeric(String str) {
        for (String ss : idSet) {
            str = str.replaceAll(ss, "");
        }
        str = str.replaceAll(charRegx, "");
        str = str.replaceAll(stringRegx, "");

        return str;
    }
    
    // checker function which takes string from buffer
    // then pass it to different functions of checker
    public static void checker(String str) {
        keywordChecker(str);
        mathOpChecker(str);
        compOpChecker(str);
        othersChecker(str);
        identifierWithValueChecker(str);
        identifiercommaChecker(str);
        stringChecker(str);
        charChecker(str);
        str = parserForNumeric(str);
        numericChecker(str);
    }

    // buffer reader
    public static void readFromFile(String fileName) {
        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader("src\\test01\\" + fileName + ".txt"));
            while ((line = br.readLine()) != null) {
                checker(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // main method
    public static void main(String[] args) {
        readFromFile("task1");
        printer("KeyWords", keySet);
        printer("Identifiers", idSet);
        printer("String values", stringSet);
        printer("Character values", charSet);
        printer("Mathematical operators", mathOpSet);
        printer("Logical operators", compOpSet);
        printer("Numerical values", numSet);
        printer("Others", otherSet);
    }

}
/*
parsing a string of characters is analyzing this string to find tokens, or items and then create a structure from the result.
 */