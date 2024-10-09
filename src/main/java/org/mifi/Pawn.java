package org.mifi;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean firstMove = false;
        if (line - toLine == 0 && column - toColumn == 0) return false;
        if (chessBoard.board[toLine][toColumn] != null) {
            if (chessBoard.board[toLine][toColumn].getSymbol().equals("K")) return false; // короля пешка взять не может
        }
        if (color.equals("White") && line == 1 || color.equals("Black") && line == 6) {
            firstMove = true;
        }
        if (firstMove) {
            if (Math.abs(toLine - line) == 2 && toColumn - column == 0) {
                if (chessBoard.board[toLine - line < 0 ? line - 1 : line + 1][column] != null) return false;
                if (chessBoard.board[toLine][column] != null) return false;
                return true;
            }
        }
        if (color.equals("White")) {
            if (toLine - line == 1 && toColumn - column == 0) {
                if (chessBoard.board[toLine][toColumn] == null) {
                    return true;
                }
            }

            if (chessBoard.board[toLine][toColumn] != null) {
                if (!chessBoard.board[toLine][toColumn].getColor().equals(color)) {
                    if (toLine - line == 1 && Math.abs(column - toColumn) == 1) {
                        return true;
                    }
                }
            }
        } else {
            if (line - toLine == 1 && toColumn - column == 0) {
                if (chessBoard.board[toLine][toColumn] == null) {
                    return true;
                }
            }

            if (chessBoard.board[toLine][toColumn] != null) {
                if (!chessBoard.board[toLine][toColumn].getColor().equals(color)) {
                    if (line - toLine == 1 && Math.abs(column - toColumn) == 1) {
                        return true;
                    }
                }
            }
        }


        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

}
