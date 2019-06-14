package CSE420Lab01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task01 {
    public static void main(String[] args) {

        String scheck = "House 15, Road 2, Shyamoli, Dhaka 1207";
        String regNum = "\\d+";

        Pattern p = Pattern.compile(regNum);
        Matcher m = p.matcher(scheck);

        while (m.find()) {
            System.out.println(m.group());
        }

    }
}
