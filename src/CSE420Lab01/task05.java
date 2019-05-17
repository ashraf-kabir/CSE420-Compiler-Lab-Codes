package CSE420Lab01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task05 {
    public static void main(String[] args) {

        String scheck = "int a , b , c ;\n" +
                "float d , e ;\n" +
                "a = b = 5 ;\n" +
                "c = 6 ;\n" +
                "if ( a > b )\n" +
                "{\n" +
                "        \tc = a - b ;\n" +
                "        \te = d - 2.0 ;\n" +
                "}\n" +
                "else\n" +
                "{\n" +
                "        \td = e + 6.0 ;\n" +
                "        \tb = a + c ;\n" +
                "}\n";
        String regLogOp = "assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while|true|false|null";

        Pattern p = Pattern.compile(regLogOp);

        Matcher m = p.matcher(scheck);

        while (m.find()) {
            System.out.println(m.group());
        }

    }
}
