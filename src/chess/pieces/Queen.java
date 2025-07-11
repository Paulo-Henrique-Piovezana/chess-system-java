package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getcolumns()];
		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getcolumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getcolumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
			p.setcolumn(p.getcolumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getcolumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
			p.setcolumn(p.getcolumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getcolumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getcolumn()] = true;
		}

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
