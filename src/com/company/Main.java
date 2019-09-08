package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int row = 8;
        int column = 8;
        int queen = 8;


        int[][] board = new int[row+2][column+2];
        intersection(queen,board);


    }



    public static int[][] intersection(int n,int [][] board){
        Random rnd = new Random();
        int randomRow = rnd.nextInt(8)+1;
        int randomColumn = rnd.nextInt(8)+1;


        if(n==0){

            return board;
        }else {
            if (board[randomRow][randomColumn] == 0) {

                addQueens(randomRow,randomColumn,board);


                } else if (board[randomRow][randomColumn] == -1 || board[randomRow][randomColumn] == 1) {
//if all index are full of either 1 or -1 but there is still a queen left, start again.

                for (int i = 1; i <= board[randomRow].length-1; i++) {
                    for (int j = 1; j <= board[randomColumn].length-1; j++) {
                        if(board[i][j] == -1 || board[i][j] == 1){
                            continue;
                        }

                    }

                }



                intersection(n,board);
                }


        }
        return intersection(n-1,board);
    }



    public static void addQueens(int randomRow,int randomColumn,int [][] board){


        board[randomRow][randomColumn] = -1;

        for (int i = 1; i <= board[randomRow].length-1; i++) {
            for (int j = 1; j <= board[randomColumn].length-1; j++) {
                if (!(board[randomRow][j] == -1)) {
                    board[randomRow][j] = 1;
                }

                if (!(board[j][randomColumn] == -1)) {
                    board[j][randomColumn] = 1;
                }
            }
        }
        if (!(board[randomRow + 1][randomColumn + 1] == -1)) {
            board[randomRow + 1][randomColumn + 1] = 1;
        }
        if (!(board[randomRow + 1][randomColumn - 1] == -1)) {
            board[randomRow + 1][randomColumn - 1] = 1;
        }
        if (!(board[randomRow - 1][randomColumn + 1] == -1)) {
            board[randomRow - 1][randomColumn + 1] = 1;
        }
        if (!(board[randomRow - 1][randomColumn - 1] == -1)) {
            board[randomRow - 1][randomColumn - 1] = 1;
        }
    }

}


