public class Cube {
    private Face front;
    private Face back;
    private Face left;
    private Face right;
    private Face top;
    private Face bottom;



    public Cube(Face front, Face back, Face left, Face right, Face top, Face bottom) {
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    public Face getFront() {
        return front;
    }

    public void setFront(Face front) {
        this.front = front;
    }

    public Face getBack() {
        return back;
    }

    public void setBack(Face back) {
        this.back = back;
    }

    public Face getLeft() {
        return left;
    }

    public void setLeft(Face left) {
        this.left = left;
    }

    public Face getRight() {
        return right;
    }

    public void setRight(Face right) {
        this.right = right;
    }

    public Face getTop() {
        return top;
    }

    public void setTop(Face top) {
        this.top = top;
    }

    public Face getBottom() {
        return bottom;
    }

    public void setBottom(Face bottom) {
        this.bottom = bottom;
    }


    public void rotateTopClockwise() {
        
        // Lagrer de to øverste stykkene fra Front (rød) siden
        Piece tempFrontUpLeft = front.getPiece(0, 1);
        Piece tempFrontUpRight = front.getPiece(1, 1);


        // Lagrer de to øverste stykkene fra Back (oransje) siden
        Piece tempBackUpLeft = back.getPiece(0, 1);
        Piece tempBackUpRight = back.getPiece(1, 1);


        // Lagrer de to øverste stykkene fra Left (grønn) siden
        Piece tempLeftUpLeft = left.getPiece(0, 1);
        Piece tempLeftUpRight = left.getPiece(1, 1);

        
        // Lagrer de to øverste stykkene fra Right (blå) siden
        Piece tempRightUpLeft = right.getPiece(0, 1);
        Piece tempRightUpRight = right.getPiece(1, 1);


        // Lagrer de to øverste stykkene fra Top (hvit) siden
        Piece tempTopUpLeft = top.getPiece(0, 1);
        Piece tempTopUpRight = top.getPiece(1, 1);

        // Lagrer de to nederste stykkene fra Top (hvit) siden
        Piece tempTopDownLeft = top.getPiece(0, 0);
        Piece tempTopDownRight = top.getPiece(1, 0);

        // Lagrer de to øverste stykkene fra Bottom (gul) siden
        Piece tempBottomUpLeft = bottom.getPiece(0, 1);
        Piece tempBottomUpRight = bottom.getPiece(1, 1);

        // Lagrer de to nederste stykkene fra Bottom (gul) siden
        Piece tempBottomDownLeft = bottom.getPiece(0, 0);
        Piece tempBottomDownRight = bottom.getPiece(1, 0);
    

        // Flytter de to øverste stykkene fra Right (blå) til Front (rød)
        front.setPiece(0, 1, tempRightUpLeft);
        front.setPiece(1, 1, tempRightUpRight);

        // Flytter de to øverste røde stykkene fra Front (rød) til Left (grønn)
        left.setPiece(0, 1, tempFrontUpLeft);
        left.setPiece(1, 1, tempFrontUpRight);

        // Flytter de to øverste stykkene fra Left (grønn) til Back (oransje)
        back.setPiece(0, 1, tempLeftUpLeft);
        back.setPiece(1, 1, tempLeftUpRight);

        // Flytter de to øverste stykkene fra Back (oransje) til Right (blå)
        right.setPiece(0, 1, tempBackUpLeft);
        right.setPiece(1, 1, tempBackUpRight);

    }

    public void rotateTopCounterClockwise() {
         // Lagrer de to øverste stykkene fra Front (rød) siden
        Piece tempFrontUpLeft = front.getPiece(0, 1);
        Piece tempFrontUpRight = front.getPiece(1, 1);


        // Lagrer de to øverste stykkene fra Back (oransje) siden
        Piece tempBackUpLeft = back.getPiece(0, 1);
        Piece tempBackUpRight = back.getPiece(1, 1);


        // Lagrer de to øverste stykkene fra Left (grønn) siden
        Piece tempLeftUpLeft = left.getPiece(0, 1);
        Piece tempLeftUpRight = left.getPiece(1, 1);

        
        // Lagrer de to øverste stykkene fra Right (blå) siden
        Piece tempRightUpLeft = right.getPiece(0, 1);
        Piece tempRightUpRight = right.getPiece(1, 1);

        right.setPiece(0, 1, tempFrontUpLeft);
        right.setPiece(1, 1, tempFrontUpRight);

        front.setPiece(0, 1, tempLeftUpLeft);
        front.setPiece(1, 1, tempLeftUpRight);

        left.setPiece(0, 1, tempBackUpLeft);
        left.setPiece(1, 1, tempBackUpRight);

        back.setPiece(0, 1, tempRightUpLeft);
        back.setPiece(1, 1, tempRightUpRight);
    }

    public void rotateBottomClockwise(){
        // Lagrer de to nederste stykkene fra Front (rød) siden
        Piece tempFrontDownLeft = front.getPiece(0, 0);
        Piece tempFrontDownRight = front.getPiece(1, 0);

        // Lagrer de to nederste stykkene fra Back (oransje) siden
        Piece tempBackDownLeft = back.getPiece(0, 0);
        Piece tempBackDownRight = back.getPiece(1, 0);

        // Lagrer de to nederste stykkene fra Left (grønn) siden
        Piece tempLeftDownLeft = left.getPiece(0, 0);
        Piece tempLeftDownRight = left.getPiece(1, 0);

        // Lagrer de to nederste stykkene fra Right (blå) siden
        Piece tempRightDownLeft = right.getPiece(0, 0);
        Piece tempRightDownRight = right.getPiece(1, 0);

        // Flytter de to øverste stykkene fra Right (blå) til Front (rød)
        front.setPiece(0, 0, tempRightDownLeft);
        front.setPiece(1, 0, tempRightDownRight);

        // Flytter de to øverste røde stykkene fra Front (rød) til Left (grønn)
        left.setPiece(0, 0, tempFrontDownLeft);
        left.setPiece(1, 0, tempFrontDownRight);

        // Flytter de to øverste stykkene fra Left (grønn) til Back (oransje)
        back.setPiece(0, 0, tempLeftDownLeft);
        back.setPiece(1, 0, tempLeftDownRight);

        // Flytter de to øverste stykkene fra Back (oransje) til Right (blå)
        right.setPiece(0, 0, tempBackDownLeft);
        right.setPiece(1, 0, tempBackDownRight);

    }

     public void rotateBottomCounterClockwise() {
        // Lagrer de to nederste stykkene fra Front (rød) siden
        Piece tempFrontDownLeft = front.getPiece(0, 0);
        Piece tempFrontDownRight = front.getPiece(1, 0);

        // Lagrer de to nederste stykkene fra Back (oransje) siden
        Piece tempBackDownLeft = back.getPiece(0, 0);
        Piece tempBackDownRight = back.getPiece(1, 0);

        // Lagrer de to nederste stykkene fra Left (grønn) siden
        Piece tempLeftDownLeft = left.getPiece(0, 0);
        Piece tempLeftDownRight = left.getPiece(1, 0);

        // Lagrer de to nederste stykkene fra Right (blå) siden
        Piece tempRightDownLeft = right.getPiece(0, 0);
        Piece tempRightDownRight = right.getPiece(1, 0);

        // Flytter de to øverste stykkene fra Right (blå) til Front (rød)
        right.setPiece(0, 0, tempFrontDownLeft);
        right.setPiece(1, 0, tempFrontDownRight);

        // Flytter de to øverste røde stykkene fra Front (rød) til Left (grønn)
        front.setPiece(0, 0, tempLeftDownLeft);
        front.setPiece(1, 0, tempLeftDownRight);

        // Flytter de to øverste stykkene fra Left (grønn) til Back (oransje)
        left.setPiece(0, 0, tempBackDownLeft);
        left.setPiece(1, 0, tempBackDownRight);

        // Flytter de to øverste stykkene fra Back (oransje) til Right (blå)
        back.setPiece(0, 0, tempRightDownLeft);
        back.setPiece(1, 0, tempRightDownRight);
    }
    

    public void rotateBackClockwise() {
      
    }

    public void rotateBackCounterClockwise() {

    }





    public void rotateLeftClockwise() {
        
    }

    public void rotateLeftCounterClockwise() {

    }

    public void rotateRightClockwise() {
       
    }

    public void rotateRightCounterClockwise() {

    }

    


    public void rotateFrontCounterClockwise() {
        
    }

    public void rotateFrontClockwise() {
        
    }

    

    
}
