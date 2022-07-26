package chess.board;

import chess.pieces.Piece;
import chess.pieces.types.NoPiece;
import chess.util.StringUtil;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Board implements Iterable<Piece[]>, Serializable{
    private Piece[][] board;
    private int piecesCount;

    public Board(){
        board = new Piece[8][8];
        piecesCount = 0;
    }

    public static boolean isValidIndex(int file){
        return file >= 0 && file < 8;
    }


    public static boolean isValidPosition(String position){
        return isValidIndex(StringUtil.getRankFromInput(position)) &&
        isValidIndex(StringUtil.getFileFromInput(position));
    }


    public void setEmptyRank(int rank){
        for (int file = 0; file < 8; file++) {
            put(StringUtil.setPosition(file, rank), Piece.noPiece());
        }
    }
    public void setEmptyBoard(){
        for (int rank = 0; rank < 8; rank++) {
            setEmptyRank(rank);
        }
    }


    public void initialize() {

        //Rank 1: white pieces
        put("a1", Piece.createWhiteRook());
        put("b1", Piece.createWhiteKnight());
        put("c1", Piece.createWhiteBishop());
        put("d1", Piece.createWhiteQueen());
        put("e1", Piece.createWhiteKing());
        put("f1", Piece.createWhiteBishop());
        put("g1", Piece.createWhiteKnight());
        put("h1", Piece.createWhiteRook());

        //rank 2: white pawns
        put("a2", Piece.createWhitePawn());
        put("b2", Piece.createWhitePawn());
        put("c2", Piece.createWhitePawn());
        put("d2", Piece.createWhitePawn());
        put("e2", Piece.createWhitePawn());
        put("f2", Piece.createWhitePawn());
        put("g2", Piece.createWhitePawn());
        put("h2", Piece.createWhitePawn());


        //fill the next 4 ranks with blank space
        for (int rank = 2; rank < 6; rank++) {
            for (int file = 0; file < 8; file++) {
                board[rank][file] = new NoPiece();
            }
        }

        //rank 7: black pawns
        put("a7", Piece.createBlackPawn());
        put("b7", Piece.createBlackPawn());
        put("c7", Piece.createBlackPawn());
        put("d7", Piece.createBlackPawn());
        put("e7", Piece.createBlackPawn());
        put("f7", Piece.createBlackPawn());
        put("g7", Piece.createBlackPawn());
        put("h7", Piece.createBlackPawn());

        //rank 8: black pieces
        put("a8", Piece.createBlackRook());
        put("b8", Piece.createBlackKnight());
        put("c8", Piece.createBlackBishop());
        put("d8", Piece.createBlackQueen());
        put("e8", Piece.createBlackKing());
        put("f8", Piece.createBlackBishop());
        put("g8", Piece.createBlackKnight());
        put("h8", Piece.createBlackRook());
    }
    public Piece getPiece(String position){
        int rank = StringUtil.getRankFromInput(position);
        int file = StringUtil.getFileFromInput(position);
        try{
            return board[rank][file];

        }catch (IndexOutOfBoundsException e) {
            String wrongPosition = file + Integer.toString(rank);
            System.out.println("Error! trying to access non-existing position (" + wrongPosition + ") " +
                    "inside getPiece method");
            System.out.println(e.getMessage());
            System.exit(-1);
            return null;
        }
    }

    public int getPiecesCount() {
        return piecesCount;
    }

    public boolean isAloneInTheFile(char rep, int file){
        int count = 0;
        for (int i = 7; i >= 0; i--) {
            Piece piece = getPiece(StringUtil.setPosition(file, i));
            if (piece.getRepresentation() == rep) {
                count++;
                if(count > 1) return false;
            }
        }
        return true;
    }

    public double getStrengthByFile(Piece.Color color, int file){
        double strength = 0;
        for (int i = 0; i < 8; i++) {
            Piece piece = board[i][file];
            if (color == piece.getColor())
                strength += piece.getStrength(isAloneInTheFile(piece.getRepresentation(), file));
        }
        return strength;
    }

    public double getStrength(Piece.Color color){
        double strength = 0;
        for (int file = 0; file < 8; file++) {
            strength += getStrengthByFile(color, file);
        }
        return  strength;
    }

    public void put(String position, Piece piece){
        int rank = StringUtil.getRankFromInput(position);
        int file = StringUtil.getFileFromInput(position);
        board[rank][file] = piece;
        piece.setPosition(position);
        incrementCount();
    }

    private void incrementCount(){piecesCount++;}
    public boolean isPositionEmpty(String position){
        return getPiece(position).getClass() == NoPiece.class;
    }
    @Override
    public Iterator<Piece[]> iterator() {return Arrays.asList(board).iterator();}

    private void persistPieces(ObjectOutputStream output){
    }

    public boolean equals(Object that){
        return (that.getClass() == Board.class &&
                compareBoard((Board)that));

    }

    private boolean compareBoard(Board that){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(!board[i][j].equals(that.getPiece(StringUtil.setPosition(j, i)))) return false;
            }
        }
        return true;
    }
}