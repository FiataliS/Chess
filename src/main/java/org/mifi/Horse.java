package org.mifi;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line - toLine == 0 && column - toColumn == 0) return false;
        if (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1 || Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2)
            if (chessBoard.board[toLine][toColumn] != null) {
                if (!chessBoard.board[toLine][toColumn].getColor().equals(color))
                    return true;
            } else {
                return true;
            }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
