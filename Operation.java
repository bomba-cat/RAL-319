package project;

public class Operation{
    public static int Add(int x, int y){
        return x+y;
    }
    public static int Sub(int x, int y){
        return x-y;
    }
    public static double Div(double x, double y){
        return x/y;
    }
    public static int Mul(int x, int y){
        int initialVal = x;                         //x auf einer Chache speichern
        for (int i = 1; i < y; i++){                //Das y fache mal wiederholen
            x += initialVal;                        //x sollte mit dem Chache Wert addiert werden
        }
        return x;                                   //x returnen
    }
    public static void main(String[] args){
        int x = 12;
        int y = 42;
        System.out.println(Add(x,y));
        System.out.println(Mul(x,y));
        System.out.println(Sub(x,y));
        System.out.println(Div(x,y));
    }
}