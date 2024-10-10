package org.mifi;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return attackKing(chessBoard, line, column, toLine, toColumn);
    }

    public boolean attackKing(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line - toLine == 0 && column - toColumn == 0) return false;
        if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) return true;
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        board.board[line][column] = new King(color);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null) {
                    if (board.board[i][j].getSymbol().equals(this.getSymbol()) && board.board[i][j].getColor().equals(this.color))
                        continue;
                    if (board.board[i][j].getSymbol().equals(this.getSymbol()) && !board.board[i][j].getColor().equals(this.color)) {
                        if (((King) board.board[i][j]).attackKing(board, i, j, line, column)) { //Пришлось добавить приведение типов в связи с выводом метода атаки короля.. иначе происходит рекурсия и ошибка переполнения стека.
                            board.board[line][column] = null;
                            return true;
                        }
                        continue;
                    }
                    if (!board.board[i][j].color.equals(this.color) && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        System.out.println(board.board[i][j].getSymbol() + board.board[i][j].getColor());
                        board.board[line][column] = null;
                        return true;
                    }
                }
            }
        }
        board.board[line][column] = null;
        return false;
    }
}
