package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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

		// Castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// castling kingside
			if (getMoveCount() == 0 && !chessMatch.getCheck()) {
				Position posT1 = new Position(position.getRow(), position.getcolumn() + 3);
				if (getBoard().positionExists(posT1) && testRookCastling(posT1)) {
					Position p1 = new Position(position.getRow(), position.getcolumn() + 1);
					Position p2 = new Position(position.getRow(), position.getcolumn() + 2);
					if (getBoard().positionExists(p1) && getBoard().positionExists(p2) && getBoard().piece(p1) == null
							&& getBoard().piece(p2) == null) {
						mat[position.getRow()][position.getcolumn() + 2] = true;
					}
				}
			}

			// castling queenside
			if (getMoveCount() == 0 && !chessMatch.getCheck()) {
				Position posT2 = new Position(position.getRow(), position.getcolumn() - 4);
				if (getBoard().positionExists(posT2) && testRookCastling(posT2)) {
					Position p1 = new Position(position.getRow(), position.getcolumn() - 1);
					Position p2 = new Position(position.getRow(), position.getcolumn() - 2);
					Position p3 = new Position(position.getRow(), position.getcolumn() - 3);
					if (getBoard().positionExists(p1) && getBoard().positionExists(p2) && getBoard().positionExists(p3)
							&& getBoard().piece(p1) == null && getBoard().piece(p2) == null
							&& getBoard().piece(p3) == null) {
						mat[position.getRow()][position.getcolumn() - 2] = true;
					}
				}
			}
		}

		return mat;

	}

}
