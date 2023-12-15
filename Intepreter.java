package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Intepreter{
    public static void main(String[] args){
        int[] memory = new int[0];          //15 vorgegebene Memory Allocations : dynamisch
        int AC = 0;                         //Noch keinen Wert
        int line = 0;                       //Die Linie in der sich der Intepreter befindet
        String[] Lines = askForFile();      //Neue StringArray erstellen wo jede zeile der Datei eingegeben ist.
        while (line < Lines.length){
            if (!Lines[line].equals("\n")){
                try{                        //Wir versuchen den Code auszuführen und sobald wir den error ArrayIndexOutOfBounds einfangen, printen wir auf der Console dass der Index der Memory Allocation grösser als die Memory selber ist und somit brechen wir den ganzen code dann ab
                    //System.out.println(Lines[line]);
                    String[] tmp = new String[2];
                    tmp = Lines[line].split(" ");   //Wir unterteilen die geladene linie durch die abstände in einem Temporären chache
                    if (tmp[0].equals("JMZ")){
                        line = JMZ(AC, Integer.parseInt(tmp[1]), line);
                    }
                    if (tmp[0].equals("WMR")){
                        memory = WMR(memory, Integer.parseInt(tmp[1]));
                    }
                    if (tmp[0].equals("LDA")){
                        AC = LDA(memory, Integer.parseInt(tmp[1]), line);
                    }
                    if (tmp[0].equals("LDI")){
                        AC = LDI(memory, Integer.parseInt(tmp[1]), line);
                    }
                    if (tmp[0].equals("STA")){
                        memory = STA(memory, Integer.parseInt(tmp[1]), AC);
                    }
                    if (tmp[0].equals("STI")){
                        memory = STI(memory, Integer.parseInt(tmp[1]), AC);
                    }
                    if (tmp[0].equals("ADD")){
                        AC = ADD(memory,AC, Integer.parseInt(tmp[1]));
                    }
                    if (tmp[0].equals("SUB")){
                        AC = SUB(memory,AC, Integer.parseInt(tmp[1]));
                    }
                    if (tmp[0].equals("HLT")){
                        HLT();
                    }
                    if (tmp[0].equals("JMP")){
                        line = JMP(Integer.parseInt(tmp[1]));
                    }
                    if (tmp[0].equals("SMV")){
                        SMV(memory, Integer.parseInt(tmp[1]));
                    }
                    line++;
                }catch (ArrayIndexOutOfBoundsException e){
                    break;
                }
            }
        }
    }

    public static String[] askForFile(){
        //https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line
        //Dieser code öffnet eine text Datei und lest sie Linie von Linie ab und fügt jede Linie in eine Liste von der ich alles ablesen kann
        String[] Lines = {};
        try {
			List<String> allLines = Files.readAllLines(Paths.get("RLE.Fibonacci.txt"));

			for (String line : allLines) {
				//System.out.println(line);
                Lines = StringArray.add(Lines, line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        return Lines;
    }

    //Intepreter Logik
    public static int ADD(int[] MEM, int AC, int ALLOC){
        return AC += MEM[ALLOC];
    }
    public static int SUB(int[] MEM, int AC, int ALLOC){
        return AC -= MEM[ALLOC];
    }
    public static int LDA(int[] MEM, int ALLOC, int debugLine){
        try{
            return MEM[ALLOC];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e+", please make sure that the allocation is valid: Error on line; "+(debugLine+1));
            return 0;
        }
    }
    public static int LDI(int[] MEM, int ALLOC, int debugLine){
        try{
            return LDA(MEM, MEM[ALLOC], debugLine);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e+", please make sure that the allocation is valid: Error on line; "+(debugLine+1));
            return 0;
        }
    }
    public static int[] STA(int[] MEM, int ALLOC, int VAL){
        try{
            MEM = IntArray.replaceItem(MEM, VAL, ALLOC);
        }
        catch(ArrayIndexOutOfBoundsException e){
            MEM = IntArray.add(MEM, VAL);
        }
        return MEM;
    }
    public static int[] STI(int[] MEM, int ALLOC, int VAL){
        try{
            MEM = IntArray.replaceItem(MEM, VAL, MEM[ALLOC]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            MEM = IntArray.add(MEM, VAL);
        }
        return MEM;
    }
    public static int JMP(int POS){
        return POS;
    }
    public static int JMZ(int AC, int POS, int CURR){
        if (AC == 0){
            return POS-1;
        }
        return CURR;
    }
    public static void HLT(){
        System.exit(1);
    }
    public static int[] WMR(int[] MEM, int VAL){
        MEM = IntArray.add(MEM, VAL);
        return MEM;
    }
    public static void SMV(int[] MEM, int ALLOC){
        System.out.println(MEM[ALLOC]);
    }
}