package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getcolumns()];

		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getcolumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getcolumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getcolumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getcolumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// nw
		p.setValues(position.getRow() - 1, position.getcolumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// ne
		p.setValues(position.getRow() - 1, position.getcolumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// sw
		p.setValues(position.getRow() + 1, position.getcolumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// se
		p.setValues(position.getRow() + 1, position.getcolumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		return mat;

	}

}
