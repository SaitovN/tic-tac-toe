package academy.devonline.java.basic.section01_setup.game;

import java.util.Random;
import java.util.Scanner;

public class gigiggTicTacToe {
    public static void main(String[] args) {
        System.out.println("Use the following table to specify a cell using numbers from 1 and 9 ");
        p2rintTableMap();
        char[][] gametable = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        if (new Random().nextBoolean()) {
            xodUser(gametable);
            printGame(gametable);
        }
        while (true) {
            xodUser(gametable);
            printGame(gametable);
            if (isUser(gametable)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isDraw(gametable)) {
                System.out.println("Sorry Draw!");
                break;
            }
            xodComputer(gametable);
            printGame(gametable);
            if (isComputer(gametable)) {
                System.out.println("COMPUTER WIN!");
                break;
            }
            if (isDraw(gametable)) {
                System.out.println("Sorry Draw!");
                break;
            }


        }

        System.out.println(" G A M E   O V E R !");


    }

    private static void p2rintTableMap() {

      /*  System.out.println("-------------------");
        System.out.println("|  7  |  8  |  9  |");
        System.out.println("-------------------");
        System.out.println("|  4  |  5  |  6  |");
        System.out.println("-------------------");
        System.out.println("|  1  |  2  |  3  |");
        System.out.println("-------------------");*/
        char[][] maptabel = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}
        };
        printGame(maptabel);


    }

/*    private static void printGamell(char[][] gametable) {
        System.out.println("-------------------");
        System.out.println("| " + gametable[0][0] + " | " + gametable[0][1] + "  |  " + gametable[0][2] + "  |");
        System.out.println("-------------------");
        System.out.println("| " + gametable[1][0] + " | " + gametable[1][1] + "  |  " + gametable[1][2] + "  |");
        System.out.println("-------------------");
        System.out.println("| " + gametable[2][0] + " | " + gametable[2][1] + "  |  " + gametable[2][2] + "  |");
        System.out.println("-------------------");

    }*/

    private static void printGame(char[][] gametable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gametable[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }


    private static void xodUser(char[][] gametable) {
        while (true) {
            System.out.println("Plase type  number between 1 and 9 :");
            String string = new Scanner(System.in).nextLine();
            if (string.length() == 1) {
                char digit = string.charAt(0);
                if (digit >= '1' && digit <= '9') {
                    if (xodUserer(gametable, digit)) {
                        return;
                    }
                }
            }


        }

    }


    private static boolean xodUserer(char[][] gametable, char digit) {
        char[][] maptabel = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}
        };
        boolean flag = true;
        for (int i = 0; i < maptabel.length; i++) {
            for (int j = 0; j < maptabel[i].length; j++) {
                if (maptabel[i][j] == digit) {
                    if (gametable[i][j] == ' ') {
                        gametable[i][j] = 'X';
                        return true;
                    } else {
                        System.out.println("Can make a move because the call is not free! Try again!");
                        return false;
                    }
                }
            }

        }
        return false;
    }


    private static void xodComputer(char[][] gametable) {

        Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int cow = random.nextInt(3);
            if (gametable[row][cow] == ' ') {
                gametable[row][cow] = '0';
                return;
            }

        }

    }

    private static boolean isUser(char[][] gametable) {
        return winner(gametable, 'X');


    }


    ;


    private static boolean isComputer(char[][] gametable) {


        return winner(gametable, '0');
       /* if(gametable[0][0] == gametable[0][1] && gametable[0][0] == gametable[0][2] & gametable[0][0] == '0') {
        return true;
        }
        if(gametable[1][0] == gametable[1][1] && gametable[1][0] == gametable[1][2] & gametable[1][0] == '0') {
            return true;
        }if(gametable[2][0] == gametable[2][1] && gametable[2][0] == gametable[2][2] & gametable[2][0] == '0') {
            return true;
        }*/


    }

    private static boolean winner(char[][] gametable, char ch) {

        for (int i = 0; i < 3; i++) {
            if (gametable[i][0] == gametable[i][1] && gametable[i][0] == gametable[i][2] & gametable[i][0] == ch) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (gametable[0][i] == gametable[1][i] && gametable[0][i] == gametable[2][i] & gametable[0][i] == ch) {
                return true;
            }

        }
        if (gametable[1][1] == gametable[0][0] && gametable[0][0] == gametable[2][2] & gametable[0][0] == ch) {
            return true;
        }
        if (gametable[0][2] == gametable[1][1] && gametable[0][2] == gametable[2][2] & gametable[0][2] == ch) {
            return true;
        }


        return false;
    }

    private static boolean isDraw(char[][] gametable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                    if (gametable[i][j]==' '){
                        return false;
                    }
            }
        }
        return true;
    }
}