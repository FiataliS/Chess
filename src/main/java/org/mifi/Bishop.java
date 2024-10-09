package org.mifi;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line - toLine == 0 && column - toColumn == 0) return false;
        if (Math.abs(line - toLine) - Math.abs(column - toColumn) == 0) { // проверяем на диоганаль
            for (int i = 1; i < Math.abs(line - toLine); i++) { // проверяем свободна ли дорога
                int markingLine = line > toLine ? line - i : line + i;
                int markingColumn = column > toColumn ? column - i : column + i;
                if (chessBoard.board[markingLine][markingColumn] != null) { // если на пути до точки есть фигура, то ход не возможен
                    return false;
                }
            }
            if (chessBoard.board[toLine][toColumn] != null) {
                if (chessBoard.board[toLine][toColumn].getColor().equals(color)) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }


}
