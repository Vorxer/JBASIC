package compiler;

import error.SyntaxError;

public class Line {
    String lineNo;
    String instruction;

    public Line(String line) throws SyntaxError{
        try {
            String[] parts = line.split(" ", 2);
            this.lineNo = parts[0];
            this.instruction = parts[1];
        }catch (Exception e){
            throw new SyntaxError("Unable to parse line { " + line + " } into executable instruction");
        }
    }

    public String command(){
        return instruction.split(" ")[0];
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineNo='" + lineNo + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
