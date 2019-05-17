package CSE420Lab01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task03 {
    public static void main(String[] args) {

        String scheck = "5 + 7 - 6";
        String regMathOp = "[+-/*]";

        Pattern p = Pattern.compile(regMathOp);

        Matcher m = p.matcher(scheck);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
