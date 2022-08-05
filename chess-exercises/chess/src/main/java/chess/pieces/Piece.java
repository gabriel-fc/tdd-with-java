package chess.pieces;
import chess.pieces.types.*;
import chess.pieces.types.movementstrategy.Movements;
import chess.util.StringUtil;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Piece implements Serializable {

    private final Color color;
    private final char representation;
    private int rank;
    private int file;
    public enum Color {BLACK, WHITE, NONE}
    protected final Movements movements = new Movements();

    protected Piece(Color Color, char representation){
        this.color = Color;
        this.representation = representation;
    }

    public double getStrength(boolean isAloneInFile){

        //return getStrength(isAloneInFile);
        return 0;
    }

    public boolean isBlack(){return color == Color.BLACK;}
    public boolean isWhite(){return color == Color.WHITE;}

    public Color getColor() {
        return color;
    }



    public char getRepresentation(){
        return color == Color.BLACK ? Character.toUpperCase(representation) : representation;
    }

    public static Piece createWhitePawn(){
        return new Pawn(Color.WHITE);
    }
    public static Piece createBlackPawn(){
        return new Pawn(Color.BLACK);
    }

    public static Piece createWhiteQueen(){
        return new Queen(Color.WHITE);
    }

    public static Piece createBlackQueen(){
        return new Queen(Color.BLACK);
    }

    public static Piece createWhiteBishop(){
        return new Bishop(Color.WHITE);
    }

    public static Piece createBlackBishop(){
        return new Bishop(Color.BLACK);
    }

    public static Piece createWhiteRook(){
        return new Rook(Color.WHITE);
    }

    public static Piece createBlackRook(){
        return new Rook(Color.BLACK);
    }

    public static Piece createWhiteKing(){
        return new King(Color.WHITE);
    }

    public static Piece createBlackKing(){
        return new King(Color.BLACK);
    }

    public static Piece createWhiteKnight(){
        return new Knight(Color.WHITE);
    }

    public static Piece createBlackKnight(){
        return new Knight(Color.BLACK);
    }

    public static Piece noPiece(){
        return new NoPiece();
    }

    public abstract ArrayList<String> getPossibleMoves(String position);

    public void setPosition(int rank, int file){
        this.rank = rank;
        this.file = file;
    }

    public void setPosition(String position){
        this.rank = StringUtil.getRankFromInput(position);
        this.file = StringUtil.getFileFromInput(position);
    }

    public boolean isOpponent(Piece piece){
        return piece.getColor() != this.color;
    }

    public boolean equals(Piece that){
        return this.getClass() == that.getClass() &&
                this.color == that.getColor();
    }
}
