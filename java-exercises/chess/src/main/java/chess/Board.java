package chess;

import chess.pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    private ArrayList<HashMap<Character, Piece>> board;


    char[] files = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    public void setEmptyRank(int rank){
        for (char file: files) {
            placePiece(Piece.noPiece(), StringUtil.setInput(file, rank));
        }
    }
    public void setEmptyBoard(){
        for (int i = 0; i < 8; i++) {
            setEmptyRank(i);
        }
    }


    public void initialize() {
        Piece.resetCounter();
        board = new ArrayList<>();
        //Rank 1: white pieces
        board.add(new HashMap<>());
        board.get(0).put('a', Piece.createWhiteRook());
        board.get(0).put('b', Piece.createWhiteKnight());
        board.get(0).put('c', Piece.createWhiteBishop());
        board.get(0).put('d', Piece.createWhiteQueen());
        board.get(0).put('e', Piece.createWhiteKing());
        board.get(0).put('f', Piece.createWhiteBishop());
        board.get(0).put('g', Piece.createWhiteKnight());
        board.get(0).put('h', Piece.createWhiteRook());

        //rank 2: white pawns
        board.add(new HashMap<>());
        board.get(1).put('a', Piece.createWhitePawn());
        board.get(1).put('b', Piece.createWhitePawn());
        board.get(1).put('c', Piece.createWhitePawn());
        board.get(1).put('d', Piece.createWhitePawn());
        board.get(1).put('e', Piece.createWhitePawn());
        board.get(1).put('f', Piece.createWhitePawn());
        board.get(1).put('g', Piece.createWhitePawn());
        board.get(1).put('h', Piece.createWhitePawn());

        //fill the next 4 ranks with blank space
        for (int i = 2; i < 6; i++) {
            board.add(new HashMap<>());
            for (char key: files) {
                board.get(i).put(key, Piece.noPiece());
            }
        }

        //rank 7: black pieces
        board.add(new HashMap<>());
        board.get(6).put('a', Piece.createBlackPawn());
        board.get(6).put('b', Piece.createBlackPawn());
        board.get(6).put('c', Piece.createBlackPawn());
        board.get(6).put('d', Piece.createBlackPawn());
        board.get(6).put('e', Piece.createBlackPawn());
        board.get(6).put('f', Piece.createBlackPawn());
        board.get(6).put('g', Piece.createBlackPawn());
        board.get(6).put('h', Piece.createBlackPawn());

        //Rank 8: Black pawns
        board.add(new HashMap<>());
        board.get(7).put('a', Piece.createBlackRook());
        board.get(7).put('b', Piece.createBlackKnight());
        board.get(7).put('c', Piece.createBlackBishop());
        board.get(7).put('d', Piece.createBlackQueen());
        board.get(7).put('e', Piece.createBlackKing());
        board.get(7).put('f', Piece.createBlackBishop());
        board.get(7).put('g', Piece.createBlackKnight());
        board.get(7).put('h', Piece.createBlackRook());
    }



    public int pieceCount() {
        return Piece.getCounter();
    }
    public Piece getPiece(String position){
        int rank = StringUtil.getRankFromInput(position);
        char file = StringUtil.getFileFromInput(position);
        try{
            return board.get(rank).get(file);

        }catch (IndexOutOfBoundsException e) {
            String wrongPosition = file + Integer.toString(rank);
            System.out.println("Error! trying to access non-existing position (" + wrongPosition + ") " +
                    "inside getPiece method");
            System.out.println(e.getMessage());
            System.exit(-1);
            return null;
        }
    }

    public boolean isAloneInTheFile(char rep, char file){
        int count = 0;
        for (int i = 7; i >= 0; i--) {
            Piece piece = board.get(i).get(file);
            if (piece.getRepresentation() == rep) {
                count++;
                if(count > 1) return false;
            }

        }
        return true;
    }

    public double getStrengthByFile(Piece.Color color, char file){
        double strength = 0;
        for (int i = 0; i < 8; i++) {
            Piece piece = board.get(i).get(file);
            if (color == piece.getColor())
                strength += piece.getStrength(isAloneInTheFile(piece.getRepresentation(), file));
        }
        return strength;
    }

    public double getStrength(Piece.Color color){
        double strength = 0;
        for (char file: files) {
            double value = getStrengthByFile(color, file);
            strength += value;

        }
        return  strength;
    }


    public void placePiece(Piece piece, String position){
        int rank = StringUtil.getRankFromInput(position);
        char file = StringUtil.getFileFromInput(position);
        board.get(rank).put(file, piece);

    }
}

