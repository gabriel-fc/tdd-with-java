package chess.board;

import chess.util.StringUtil;

import static chess.util.StringUtil.NEWLINE;

public class BoardInterface {
    private BoardInterface(){};

    public static String printRank(int id, Board board) {
        StringBuilder buffer = new StringBuilder();
        for (char file: StringUtil.FILES) {
            buffer.append(board.getPiece(file + Integer.toString(id)).getRepresentation());
        }
        return buffer.toString();
    }

    public static String printBoard(Board board) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 8; i > 0 ; i--) {
            buffer.append(printRank(i, board));
            buffer.append(NEWLINE);
        }
        return buffer.toString();
    }
}
