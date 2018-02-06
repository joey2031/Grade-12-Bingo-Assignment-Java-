package bingo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class BingoAssignment {

    static ArrayList<Integer> B = new ArrayList<Integer>();
    static ArrayList<Integer> I = new ArrayList<Integer>();
    static ArrayList<Integer> N = new ArrayList<Integer>();
    static ArrayList<Integer> G = new ArrayList<Integer>();
    static ArrayList<Integer> O = new ArrayList<Integer>();
    static ArrayList<Integer> roll = new ArrayList<Integer>();
    static ArrayList<Integer> called = new ArrayList<Integer>();
    static int[][] card = new int[5][5];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("B       I       N       G       O");

        populate(); // to set the ranges
        bdisplay();
        idisplay();
        ndisplay(); // to put ranges in rows
        gdisplay();
        odisplay();
        display(card); // displays the card

        //boolean run = false;
        //do {
        while (true) {
            roll();
            display(card);
            System.out.println("enter any key");
            String word = input.next();
            vcheck();
            hcheck();
            dcheck();

            if (vcheck() == true || hcheck() == true || dcheck() == true) {
                System.out.println("Do you want to play again? (yes or no)");
                String desicion = input.next();
                if (desicion.equals("no")) {
                    System.out.println("ok, thanks for playing");
                    System.out.println("Thankyou Mr.G for helping me with this project :)");
                    break;
                } else {
                    populate(); // to set the ranges
                    bdisplay();
                    idisplay();
                    ndisplay(); // to put ranges in rows
                    gdisplay();
                    odisplay();
                    display(card);
                    roll();
                    System.out.println("enter any key");
                    word = input.next();
                    vcheck();
                    hcheck();
                    dcheck();

                }
            }
        }


//
//        Class2  window = new Class2();
//        window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        window.setSize (456, 123);
//        window.setVisible(true);
        //dont use sout for j frame
        //first make without jframe
        //while (true) {
//            Random rand = new Random();
    }
    //Another method to display the card

    static void display(int[][] card) {
        for (int i = 0; i < card.length; i++) { // tranverse rows
            System.out.println("");
            for (int j = 0; j < card[i].length; j++) { // tranverse coloumns
                System.out.print(card[i][j] + " " + "\t");
            }
        }
        System.out.println("");
    }

    public static void populate() {  //to populate the lists
        for (int i = 1; i <= 15; i++) {
            B.add(i);
            Collections.shuffle(B);

        }
        for (int i = 16; i <= 30; i++) {
            I.add(i);
            Collections.shuffle(I);
        }
        for (int n = 31; n <= 45; n++) {
            N.add(n);
            Collections.shuffle(N);
        }
        for (int g = 46; g <= 60; g++) {
            G.add(g);
            Collections.shuffle(G);
        }
        for (int o = 61; o <= 75; o++) {
            O.add(o);
            Collections.shuffle(O);
        }

        for (int i = 1; i <= 75; i++) {
            roll.add(i); // adds the numbers in the check list
        }
    }

    public static void bdisplay() { // to give the coloums ranges

        for (int i = 0; i < 5; i++) {
            card[i][0] = (int) B.get(i);
        }
    }

    public static void idisplay() {
        for (int i = 0; i < 5; i++) {
            card[i][1] = (int) I.get(i);

        }
    }

    public static void ndisplay() {
        for (int i = 0; i < 5; i++) {
            card[i][2] = (int) N.get(i);
        }
    }

    public static void gdisplay() {
        for (int i = 0; i < 5; i++) {
            card[i][3] = (int) G.get(i);
        }
    }

    public static void odisplay() {
        for (int i = 0; i < 5; i++) {
            card[i][4] = (int) O.get(i);

        }
    }

    public static void b() {
        for (int i = 1; i <= 15; i++) {
            B.add(i);
        }
        Collections.shuffle(B); //shuffles the lsit
// removes the number I call from the array list so it will not repeat.

    }

    public static void i() {

        for (int i = 16; i <= 30; i++) {
            I.add(i);
        }
        Collections.shuffle(I);

    }

    public static void n() {
        for (int n = 31; n <= 45; n++) {
            N.add(n);
        }
        Collections.shuffle(N);

    }

    public static void g() {
        for (int g = 46; g <= 60; g++) {
            G.add(g);
        }
        Collections.shuffle(G);

    }

    public static void o() {
        for (int o = 61; o <= 75; o++) {
            O.add(o);
        }
        Collections.shuffle(O);

    }
/// method to roll the numbers
    public static void roll() {
        int random = (int) (Math.random() * (roll.size() - 1) + 0); // numbers are indexes not the actual number you will be genrating
        // thoes numbers are in the list.
        // System.out.println(random); // but you want the number NOT THE INDEX!!!
        int number = roll.get(random);
        System.out.println("The number generated is: " + number);
        roll.remove(random);
        called.add(random); // so I can display the number I called
        for (int i = 0; i < card.length; i++) { // rows
            for (int j = 0; j < card[i].length; j++) { //coloums
                if (card[i][j] == number) {
                    card[i][j] = 0;
                }

            }

        }
    }
/// method to check vertical
    public static boolean vcheck() {
        for (int i = 0; i < card.length; i++) { // rows
            int sum = 0;
            for (int j = 0; j < card.length; j++) { // what coloum
                sum = sum + card[i][j]; // last sum plus the number in the cordinate
            }
            if (sum == 0) {
                System.out.println("BINGO");
                System.out.println("The numbers called is " + called);
                return true;

            }

        }
        return false;

    }
/// method to check horizintal
    public static boolean hcheck() {
        for (int j = 0; j < card.length; j++) {
            int sum = 0;
            for (int i = 0; i < card.length; i++) { // rows
                sum = sum + card[j][i]; // last sum plus the number in the cordinate
            }
            if (sum == 0) {
                System.out.println("BINGO");
                System.out.println("The numbers called is " + called);
                return true;
            }

        }
        return false;

    }
/// method to check diganial
    public static boolean dcheck() {
        if ((card[0][0] == 0 && card[1][1] == 0 && card[2][2] == 0 && card[3][3] == 0 && card[4][4] == 0) || (card[0][4] == 0 && card[1][3] == 0 && card[2][2] == 0 && card[3][1] == 0 && card[4][0] == 0)) {
            System.out.println("BINGO");
            System.out.println("The numbers called is " + called);
            return true;
        } else {
            return false;
        }
    }

}
