package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
    public class AI {
        static Scanner in;
        static String[] board;
        static String turn;
        static String ty;

        public static void main(String[] args) {
            in = new Scanner(System.in);

            System.out.println("type one for single player two for a 2 player game");
            ty = in.nextLine();
            if (ty == "one"){
                //go to ai coding game Diffrent class
            }else if (ty == "two"){
                //go to multiplayer code Diffrent class
            }

            board = new String[9];
            turn = "X";
            String winner = null;
            populateEmptyBoard();

            System.out.println("Welcome to 2 Player Tic Tac Toe.");
            System.out.println("--------------------------------");
            printBoard();
            System.out.println("X's will play first. Enter a slot number to place X in:");

            while (winner == null) {
                int numInput;

                //this checks  for invalid input
                try {
                    numInput = in.nextInt();
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println("Invalid input; re-enter slot number:");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
                //this sets the square to x or o and then makes turn = o or x
                if (board[numInput-1].equals(String.valueOf(numInput))) {
                    board[numInput-1] = turn;
                    /*if (turn.equals("X")) {
                        turn = "O";
                    } else {
                        turn = "X";
                    }*/

                    //then prints current board/ checks winner
                    printBoard();
                    winner = checkWinner();

                    if(winner=="0"||winner=="X") {
                        System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
                        System.exit(0);
                    }

                } else {
                    System.out.println("Slot already taken; re-enter slot number:");
                    continue;
                }
                winner = randvalue();

            }
            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("It's a draw! Thanks for playing.");
            } else {
                System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
            }
        }

        static String checkWinner() {
            for (int a = 0; a < 8; a++) {
                String line = null;
                switch (a) {
                    case 0:
                        line = board[0] + board[1] + board[2];
                        break;
                    case 1:
                        line = board[3] + board[4] + board[5];
                        break;
                    case 2:
                        line = board[6] + board[7] + board[8];
                        break;
                    case 3:
                        line = board[0] + board[3] + board[6];
                        break;
                    case 4:
                        line = board[1] + board[4] + board[7];
                        break;
                    case 5:
                        line = board[2] + board[5] + board[8];
                        break;
                    case 6:
                        line = board[0] + board[4] + board[8];
                        break;
                    case 7:
                        line = board[2] + board[4] + board[6];
                        break;
                }
                if (line.equals("XXX")) {
                    return "X";
                } else if (line.equals("OOO")) {
                    return "O";
                }
            }

            for (int a = 0; a < 9; a++) {
                if (Arrays.asList(board).contains(String.valueOf(a+1))) {
                    break;
                }
                else if (a == 8) return "draw";
            }

            System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
            return null;
        }

        static void printBoard() {
            System.out.println("/---|---|---\\");
            System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
            System.out.println("|-----------|");
            System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
            System.out.println("|-----------|");
            System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
            System.out.println("\\---|---|---/");
        }

        static void populateEmptyBoard() {
            for (int a = 0; a < 9; a++) {
                board[a] = String.valueOf(a+1);
            }
        }

        public static String randvalue(){
            Random rand = new Random();
            int value = rand.nextInt(9)+1;
            if (board[value-1].equals(String.valueOf(value))){
                board[value-1] = "O";
            }else{
                randvalue();
            }

            printBoard();
            return checkWinner();
        }
    }