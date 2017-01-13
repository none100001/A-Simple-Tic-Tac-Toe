package com.rajkin3.tictactoe;

public class TicTacToe {
    public static final int BOARD_SIZE = 9;
    public static final char COMPUTER_PLAYER = 'X';
    public static final char HUMAN_PLAYER = 'O';
    public static final char OPEN_SPOT = ' ';
    public int LEVEL;
    private char[] mBoard;

    public static class ChessBoard {
        int level;
        int value;
        int f1x;
     

        public ChessBoard(int x, int value, int level) {
            f1x = x;
            this.value = value;
            this.level = level;
        }
    }

    public TicTacToe() {
        LEVEL = 0;
        mBoard = new char[BOARD_SIZE];
    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            mBoard[i] = OPEN_SPOT;
        }
    }

    public boolean setMove(char player, int location) {
        if (location < 0 || location >= BOARD_SIZE || mBoard[location] != OPEN_SPOT) {
            return false;
        }
        mBoard[location] = player;
        return true;
    }

    public int random(int l, int r) {
        return ((int) (Math.random() * ((double) ((r + 1) - l)))) + l;
    }

    public static char swap(char u) {
        return u == COMPUTER_PLAYER ? HUMAN_PLAYER : COMPUTER_PLAYER;
    }

    public ChessBoard play(char turn, int level) {
        int get = checkForWinner();
        if (get == 1) {
            return new ChessBoard(0, 10, level);
        }
        if (get == 0) {
            return new ChessBoard(0, -10, level);
        }
        if (get == 1111) {
            return new ChessBoard(0, 0, level);
        }
        int max = -10;
        int min = 10;
        int l = -10;
        int x = 0;
        for (int c = 0; c < BOARD_SIZE; c++) {
            if (mBoard[c] == OPEN_SPOT && level<LEVEL) {
                mBoard[c] = turn;
                ChessBoard t = play(swap(turn), level + 1);
                if (turn == COMPUTER_PLAYER) {
                    if (t.value > max) {
                        l = t.level;
                        max = t.value;
                        x = c;
                        //mBoard[c] = OPEN_SPOT;
                        //break;
                    } else if (t.value == max) {
                        if (l == -10) {
                            l = t.level;
                            max = t.value;
                            x = c;
                        } else if (t.level < l) {
                            l = t.level;
                            max = t.value;
                            x = c;
                            //mBoard[c] = OPEN_SPOT;
                            //break;
                        }
                    }
                } else if (t.value < min) {
                    l = t.level;
                    min = t.value;
                    x = c;
                    //mBoard[c] = OPEN_SPOT;
                    //break;
                } else if (t.value == min) {
                    if (l == -10) {
                        l = t.level;
                        min = t.value;
                        x = c;
                    } else if (t.level < l) {
                        l = t.level;
                        min = t.value;
                        x = c;
                        //mBoard[c] = OPEN_SPOT;
                        //break;
                    }
                }
                mBoard[c] = OPEN_SPOT;
            }
        }
        if (turn == COMPUTER_PLAYER) {
            return new ChessBoard(x, max, l);
        }
        return new ChessBoard(x, min, l);
    }

    public boolean isfilled() {
        for (int c = 0; c < BOARD_SIZE; c++) {
            if (mBoard[c] == OPEN_SPOT) {
                return false;
            }
        }
        return true;
    }

    public int checkForWinner() {
        if (mBoard[0] == COMPUTER_PLAYER && mBoard[1] == COMPUTER_PLAYER && mBoard[2] == COMPUTER_PLAYER) {
            return 1;
        }
        if (mBoard[3] == COMPUTER_PLAYER && mBoard[4] == COMPUTER_PLAYER && mBoard[5] == COMPUTER_PLAYER) {
            return 1;
        }
        if (mBoard[6] == COMPUTER_PLAYER && mBoard[7] == COMPUTER_PLAYER && mBoard[8] == COMPUTER_PLAYER) {
            return 1;
        }
        if (mBoard[0] == COMPUTER_PLAYER && mBoard[3] == COMPUTER_PLAYER && mBoard[6] == COMPUTER_PLAYER) {
            return 1;
        }
        if (mBoard[1] == COMPUTER_PLAYER && mBoard[4] == COMPUTER_PLAYER && mBoard[7] == COMPUTER_PLAYER) {
            return 1;
        }
        if (mBoard[2] == COMPUTER_PLAYER && mBoard[5] == COMPUTER_PLAYER && mBoard[8] == COMPUTER_PLAYER) {
            return 1;
        }
        if (mBoard[0] == COMPUTER_PLAYER && mBoard[4] == COMPUTER_PLAYER && mBoard[8] == COMPUTER_PLAYER) {
            return 1;
        }
        if (mBoard[2] == COMPUTER_PLAYER && mBoard[4] == COMPUTER_PLAYER && mBoard[6] == COMPUTER_PLAYER) {
            return 1;
        }
        if (mBoard[0] == HUMAN_PLAYER && mBoard[1] == HUMAN_PLAYER && mBoard[2] == HUMAN_PLAYER) {
            return 0;
        }
        if (mBoard[3] == HUMAN_PLAYER && mBoard[4] == HUMAN_PLAYER && mBoard[5] == HUMAN_PLAYER) {
            return 0;
        }
        if (mBoard[6] == HUMAN_PLAYER && mBoard[7] == HUMAN_PLAYER && mBoard[8] == HUMAN_PLAYER) {
            return 0;
        }
        if (mBoard[0] == HUMAN_PLAYER && mBoard[3] == HUMAN_PLAYER && mBoard[6] == HUMAN_PLAYER) {
            return 0;
        }
        if (mBoard[1] == HUMAN_PLAYER && mBoard[4] == HUMAN_PLAYER && mBoard[7] == HUMAN_PLAYER) {
            return 0;
        }
        if (mBoard[2] == HUMAN_PLAYER && mBoard[5] == HUMAN_PLAYER && mBoard[8] == HUMAN_PLAYER) {
            return 0;
        }
        if (mBoard[0] == HUMAN_PLAYER && mBoard[4] == HUMAN_PLAYER && mBoard[8] == HUMAN_PLAYER) {
            return 0;
        }
        if (mBoard[2] == HUMAN_PLAYER && mBoard[4] == HUMAN_PLAYER && mBoard[6] == HUMAN_PLAYER) {
            return 0;
        }
        if (isfilled()) {
            return 1111;
        }
        return 11;
    }
    
    public int getComputerMove() {
        int ax = play(COMPUTER_PLAYER, 0).f1x;
        return ax;
        
    }
}
