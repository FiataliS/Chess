package org.mifi;

public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //// деоганаль
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
        //горизонталь и вертикаль
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
        return "Q";
    }
}
