package boardgame;

public class Board {

	private int rows;
	private int colums;
	private Piece[][] piece;

	public Board(int rows, int colums) {
		this.rows = rows;
		this.colums = colums;
		piece = new Piece[rows][colums];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColums() {
		return colums;
	}

	public void setColums(int colums) {
		this.colums = colums;
	}

	
}
