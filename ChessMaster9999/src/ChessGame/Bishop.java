package ChessGame;

import javafx.scene.image.Image;

public class Bishop extends chessPiece {
	public Bishop(int x, int y, boolean white) {
		super(x, y, white, chessBoard);
		charCode = white ? "\u2657" : "\u265D";
		pieceImg = new Image(chessPiece.class.getResource(white ? "img/WB.png" : "img/BB.png").toExternalForm());
	}

	@Override
	protected void placeThreats(chessPiece[][] board) {
		super.placeThreatsDiagonal(board);
	}
	
	@Override
	protected boolean legalMove(int x, int y) {
		return (super.legalMove(x, y) && (Math.abs(this.xCoordinate - x) == Math.abs(this.yCoordinate - y)));
	}
}
