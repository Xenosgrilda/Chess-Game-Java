package models.chess;

import models.boardgame.Board;
import models.boardgame.Piece;
import models.boardgame.Position;

// This class needs to be abstract due to its superClass
// The implementation will occur on /pieces
public abstract class ChessPiece extends Piece{
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }

    // Getters and Setters
    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void increaseMoveCount(){
        this.moveCount++;
    }

    public void decreaseMoveCount(){
        this.moveCount--;
    }

    // Methods
    // Get a ChessPosition based on a Board Position
    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(this.pos);
    }

    // This method will tell if there is a opponent piece in the way
    protected boolean isThereOpponentPiece(Position pos){
        ChessPiece piece = (ChessPiece) getBoard().piece(pos);

        // Checking if there is a piece in that position and if its from the opposite team
        return  piece != null && piece.getColor() != this.getColor();
    }
}