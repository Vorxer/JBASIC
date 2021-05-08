package compiler;

import error.SyntaxError;

import java.util.ArrayList;

public class ScriptRunner {

    Script script;

    ArrayList<Variable> variables = new ArrayList<>();

    int currentline = 0;

    public ScriptRunner(Script script) {
        this.script = script;
    }

    public void run() throws SyntaxError{

        for (int i = 0; i < script.getNumberOfLines(); i++) {

            Line line = script.getLineByNumber(i);

            String[] sections = line.instruction.split(" ",2);
            String keyword = sections[0];

            try {

                switch (keyword) {
                    case "GOTO":
                        i = script.resolveDynamicLineNumber(sections[1]);
                        break;

                    case "PRINT":
                        System.out.println(sections[1].split("\"")[1]);
                        break;

                    default:
                        throw new SyntaxError("Syntax error in line {}" + line.lineNo + " (" + i + ")");
                }
            }catch (Exception e){
                throw new SyntaxError("Syntax error in line {}" + line.lineNo + " (" + i + ")");
            }

        }

    }


}
