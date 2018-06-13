package ChessGame;

import javafx.scene.image.Image;

public class Knight extends chessPiece {

	public Knight(int x, int y, boolean white) {
		super(x, y, white, chessBoard);
		charCode = white ? "\u2658" : "\u265E";
		pieceImg = new Image(chessPiece.class.getResource(white ? "img/WN.png" : "img/BN.png").toExternalForm());
	}
	
	@Override
	protected boolean legalMove(int x, int y) {
		return (super.legalMove(x, y) && chessBoard.getThreatBoard().get(x).get(y).contains(this));
	}

	@Override
	protected void placeThreats(chessPiece[][] board) {
		for (int i = this.yCoordinate - 2; i <= this.yCoordinate + 2; i+=4) {
			if (i < 0  || i > 7) {continue;}
			if (this.xCoordinate + 1 <= 7) {chessBoard.updateThreatBoard(this.xCoordinate + 1, i, this);}
			if (this.xCoordinate - 1 >= 0) {chessBoard.updateThreatBoard(this.xCoordinate - 1, i, this);}
		}
		for (int i = this.xCoordinate - 2; i <= this.xCoordinate + 2; i+=4) {
			if (i < 0  || i > 7) {continue;}
			if (this.yCoordinate + 1 <= 7) {chessBoard.updateThreatBoard(i, this.yCoordinate + 1, this);}
			if (this.yCoordinate - 1 >= 0) {chessBoard.updateThreatBoard(i, this.yCoordinate - 1, this);}
		}
	}
}
