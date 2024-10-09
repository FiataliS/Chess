package org.mifi;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line - toLine == 0 && column - toColumn == 0) return false;
        if (line - toLine == 0 || column - toColumn == 0) {// убеждаемся что ход по горизонтали или вертикали.


            if (color.equals("White")) {
                int start = line - toLine != 0 ? line + 1 : column + 1;
                int finish = line - toLine != 0 ? toLine : toColumn;
                for (int i = start; i < finish; i++) {
                    if (line - toLine != 0) {
                        if (chessBoard.board[i][column] != null) {
                            return false;
                        }
                    } else {
                        if (chessBoard.board[line][i] != null) {
                            return false;
                        }
                    }
                }
            } else {
                int start = line - toLine != 0 ? line - 1 : column - 1;
                int finish = line - toLine != 0 ? toLine : toColumn;
                for (int i = start; i > finish; i--) {
                    if (line - toLine != 0) {
                        if (chessBoard.board[i][column] != null) {
                            return false;
                        }
                    } else {
                        if (chessBoard.board[line][i] != null) {
                            return false;
                        }
                    }
                }
            }

            if (chessBoard.board[toLine][toColumn] != null) {
                if (!chessBoard.board[toLine][toColumn].getColor().equals(color)) return true;
            } else {
                return true;
            }

        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }


}
