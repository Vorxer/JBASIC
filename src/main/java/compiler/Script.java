package compiler;

import error.SyntaxError;

import java.util.ArrayList;
import java.util.Arrays;

public class Script {

    ArrayList<Line> linesAL;
    Line[] lines;

    public Script(ArrayList<Line> lines) {
        this.linesAL = lines;
        this.lines = lines.stream().toArray( n -> new Line[n]);
    }

//    public Line getLineByDynamicNumber(String dynamicNumber){
//        return null;
//    };

    public Line getLineByNumber(int number){
        return lines[number];
    }

    public int resolveDynamicLineNumber(String number) throws SyntaxError{
        int counter = 0;
        for (Line line: linesAL) {
            if (line.lineNo.equals(number)){
                return counter-1;
            }
            counter++;
        }
        throw new SyntaxError("Unable to find line number " + number);
    }

    public int getNumberOfLines(){
        return lines.length;
    }

    @Override
    public String toString() {
        return "Script{" +
                "lines=" + Arrays.toString(lines) +
                '}';
    }
}
