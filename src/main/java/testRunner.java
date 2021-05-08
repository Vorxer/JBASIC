import compiler.Line;
import compiler.Script;
import compiler.ScriptRunner;
import error.SyntaxError;

import java.util.ArrayList;
import java.util.Scanner;

public class testRunner {

    public static void main(String[] args) {
        String thisLine = "";

        ArrayList<Line> lines = new ArrayList<>();

        try {
            while (!thisLine.equals("END")) {
                Scanner input = new Scanner(System.in);
                thisLine = input.nextLine();

                if (!thisLine.equals("END")) {
                    lines.add(new Line(thisLine));
                }


            }

            Script script = new Script(lines);

            ScriptRunner scriptRunner = new ScriptRunner(script);

            System.out.println(script.toString());

            scriptRunner.run();

        }catch (SyntaxError e){
            System.out.println(e.getMessage());
        }

    }

}
