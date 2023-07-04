package com.bridgelabz.tictactoegame;
import java.util.*;
/*
* As a Player would like to
start fresh by creating a tic
tac toe board - Create a TicTacToeGame class - Create method for every use case
and call from main
- Create a board of char[] of size 10
and assign empty space to each
element

-
0th index is ignored to make it

UC 1 user friendly*/
public class TicTactToeGame {
    public char[] board;
        public TicTactToeGame(){
            board= new char[10];//creating a board of size 10
            initializeBoard();
        }
    public void initializeBoard(){
            for(int i=0;i<board.length;i++){
                board[i]=' ';//Assigning empty space
            }
    }
    public void printBoard(){
        System.out.println(board[1]+" "+board[2]+ "  "+board[3]+ " ");
        System.out.println();
        System.out.println(board[4]+" "+board[5]+ "  "+board[6]+ " ");
        System.out.println();
        System.out.println(board[7]+" "+board[8]+ "  "+board[9]+ " ");

    }
    public boolean isBoardFull(){
            for (int i=1;i< board.length;i++){
                if(board[i]==' '){
                    return false;
                }
            }
            return true;
    }
    public boolean isWinner(char player){

            //Winning moves -123,456,789,145,257,369,159,357
            return (board[1]== player && board[2]==player && board[3]==player ||
                    board[4]== player && board[5]==player && board[6]==player ||
                    board[7]== player && board[8]==player && board[9]==player ||
                    board[1]== player && board[4]==player && board[5]==player ||
                    board[2]== player && board[5]==player && board[7]==player ||
                    board[3]== player && board[6]==player && board[9]==player ||
                    board[1]== player && board[5]==player && board[9]==player ||
                    board[3]== player && board[5]==player && board[7]==player );
    }
    public void play(){
            Scanner sc= new Scanner(System.in);
            char currentPlayer = 'X';
            while(true){
                System.out.println("Player"+ currentPlayer+ " turn.");
                System.out.println("Enter a position between 1-9: ");
                int position = sc.nextInt();
                if(position <1 || position >9 ||board[position] != ' '){
                    System.out.println("Invalid move");
                    continue;
                }
                board[position] =currentPlayer;
                printBoard();

                if(isWinner(currentPlayer)){
                    System.out.println(currentPlayer + "is the winner.");
                    break;
                }
                currentPlayer = (currentPlayer == 'X')? '0':'X';
            }
            sc.close();
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Tic tac Toe game.");
        TicTactToeGame game = new TicTactToeGame();
        game.play();
    }
}
