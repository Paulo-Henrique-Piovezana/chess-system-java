package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
	    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getcolumns()];
	    Position p = new Position(0, 0);

	    // NW
	    p.setValues(position.getRow() - 1, position.getcolumn() - 1);
	    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	        mat[p.getRow()][p.getcolumn()] = true;
	        p.setValues(p.getRow() - 1, p.getcolumn() - 1);
	    }
	    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	        mat[p.getRow()][p.getcolumn()] = true;
	    }

	    // NE
	    p.setValues(position.getRow() - 1, position.getcolumn() + 1);
	    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	        mat[p.getRow()][p.getcolumn()] = true;
	        p.setValues(p.getRow() - 1, p.getcolumn() + 1);
	    }
	    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	        mat[p.getRow()][p.getcolumn()] = true;
	    }

	    // SE
	    p.setValues(position.getRow() + 1, position.getcolumn() + 1);
	    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	        mat[p.getRow()][p.getcolumn()] = true;
	        p.setValues(p.getRow() + 1, p.getcolumn() + 1);
	    }
	    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	        mat[p.getRow()][p.getcolumn()] = true;
	    }

	    // SW
	    p.setValues(position.getRow() + 1, position.getcolumn() - 1);
	    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	        mat[p.getRow()][p.getcolumn()] = true;
	        p.setValues(p.getRow() + 1, p.getcolumn() - 1);
	    }
	    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	        mat[p.getRow()][p.getcolumn()] = true;
	    }

	    return mat;
	}
}
