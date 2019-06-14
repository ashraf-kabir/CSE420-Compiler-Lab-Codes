package CSE420Lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class lexicalAnalysis {

    public static void main(String[] args) throws FileNotFoundException {
        HashSet<String> keywords = new HashSet<String>();
        HashSet<String> math = new HashSet<String>();
        HashSet<String> log = new HashSet<String>();
        HashSet<String> num = new HashSet<String>();
        HashSet<String> others = new HashSet<String>();
        HashSet<String> id = new HashSet<String>();

        // taking input from file
        File f = new File("E:\\workspaces\\CSE420-Lab\\src\\CSE420Lab01\\input.txt");
        Scanner sc = new Scanner(f);
        String line = "";
        while (sc.hasNext()) {
            line = sc.next();

            //Finding keywords
            if (line.equals("abstract")
                    || line.equals("assert")
                    || line.equals("boolean")
                    || line.equals("break")
                    || line.equals("byte")
                    || line.equals("case")
                    || line.equals("catch")
                    || line.equals("char")
                    || line.equals("class")
                    || line.equals("const")
                    || line.equals("continue")
                    || line.equals("default")
                    || line.equals("do")
                    || line.equals("double")
                    || line.equals("else")
                    || line.equals("enum")
                    || line.equals("extends")
                    || line.equals("final")
                    || line.equals("finally")
                    || line.equals("float")
                    || line.equals("for")
                    || line.equals("goto")
                    || line.equals("if")
                    || line.equals("implements")
                    || line.equals("import")
                    || line.equals("instanceof")
                    || line.equals("int")
                    || line.equals("interface")
                    || line.equals("long")
                    || line.equals("native")
                    || line.equals("new")
                    || line.equals("package")
                    || line.equals("private")
                    || line.equals("protected")
                    || line.equals("public")
                    || line.equals("return")
                    || line.equals("short")
                    || line.equals("static")
                    || line.equals("strictfp")
                    || line.equals("super")
                    || line.equals("switch")
                    || line.equals("synchronized")
                    || line.equals("this")
                    || line.equals("throw")
                    || line.equals("throws")
                    || line.equals("transient")
                    || line.equals("try")
                    || line.equals("void")
                    || line.equals("volatile")
                    || line.equals("while")
                    || line.equals("true")
                    || line.equals("false")
                    || line.equals("null")) {
                keywords.add(line);
            }

            //Finding numbers
            else if (line.matches("[0-9]*[.0-9]?[0-9]*")) {
                num.add(line);
            }

            //Finding math operators
            else if (line.matches("[+-/*]")) {
                math.add(line);
            }

            //Finding logic operators
            else if (line.matches("[< | > | = | < = | > = | ==]")) {
                log.add(line);
            }

            //Finding others
            else if (line.matches("[; | , | . | ( | ) | { | } | [ | ]]")) {
                others.add(line);
            }

            //Finding identifiers
            else {
                id.add(line);
            }
        }

        Iterator<String> itr = keywords.iterator();
        System.out.print("Keywords: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("");

        itr = id.iterator();
        System.out.print("Identifiers: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("");

        itr = math.iterator();
        System.out.print("Math Operators: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("");

        itr = log.iterator();
        System.out.print("Logical Operators: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("");

        itr = num.iterator();
        System.out.print("Numerical Values: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("");

        itr = others.iterator();
        System.out.print("Others: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("");
    }

}
