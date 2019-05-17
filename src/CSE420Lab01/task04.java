package CSE420Lab01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task04 {
    public static void main(String[] args) {

        String scheck = "a>b 4<=2 d==e 5!=4";
        String regLogOp = "<|>|=|<=|>=|==|!=";

        Pattern p = Pattern.compile(regLogOp);

        Matcher m = p.matcher(scheck);

        while (m.find()) {
            System.out.println(m.group());
        }

    }
}
