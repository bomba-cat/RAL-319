package project;

public class Fibonacci{
    public static int fi(int num){              //Methode Fibonacci erstellt mit einem input Parameter "n"
        int first = 0;                          //Die erste Fibonacci Zahl aufgeschrieben
        int second = 1;                         //Die zweite Fibonacci Zahl aufgeschrieben
        int result = 0;                         //Das Resultat sollte hier ausgegeben werden
        for (int i = 1; i < num; i++){          //Einen For Loop erstellt um die n'te fibonacci zahl auszufinden
            result = first + second;            //Erste Zahl + die Zweite Zahl auf das Resultat gespeichert
            first = second;                     //Die erste Zahl sollte nun die zweiter werden
            second = result;                    //Die zweite Zahl sollte nun die erste werden
        }
        return result;                          //Das Resultat feturnen
    }
    public static void main(String[] args){
        System.out.println((double) fi(34)/fi(33));
        System.out.println(fi(9));
        System.out.println(fi(10));
        System.out.println(fi(11));
    }
}