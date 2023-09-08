import java.util.ArrayList;
import java.util.List;

public class Face {
    final int SIZE = 2; 
    private Piece[][] pieces;

    public Face(Piece piece1, Piece piece2, Piece piece3, Piece piece4) {
        pieces = new Piece[SIZE][SIZE];
        pieces[0][0] = piece1;
        pieces[0][1] = piece2;
        pieces[1][0] = piece3;
        pieces[1][1] = piece4;
    }

    public Piece getPiece(int x, int y) {
        return pieces[x][y];
    }

    public void setPiece(int x, int y, Piece piece) {
        pieces[x][y] = piece;
    }








}
