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
        ChessPiece chessPiece = chessBoard.board[line][column];
        if(chessBoard.board[toLine][ toColumn].getSymbol().equals("K")) return false; // короля пешка взять не может
        if (chessPiece.color.equals("White") && line == 1 || chessPiece.color.equals("Black") && line == 6) {
            firstMove = true;
        } else {
            firstMove = false;
        }

        if (firstMove) {
            if (Math.abs(line - toLine) == 2 || Math.abs(column - toColumn) == 2) return true;
        }

        if (Math.abs(line - toLine) == 1 || Math.abs(column - toColumn) == 1) return true;
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }


}
