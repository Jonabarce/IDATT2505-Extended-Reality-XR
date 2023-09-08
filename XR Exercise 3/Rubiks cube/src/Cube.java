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
        top.rotateClockwise();
        Piece temp = front.getPiece(0, 0);
        front.setPiece(0, 0, left.getPiece(0, 0));
        left.setPiece(0, 0, back.getPiece(0, 0));
        back.setPiece(0, 0, right.getPiece(0, 0));
        right.setPiece(0, 0, temp);
    }

    public void rotateBackClockwise() {
        back.rotateClockwise();
        Piece temp = top.getPiece(0, 0);
        top.setPiece(0, 0, left.getPiece(0, 1));
        left.setPiece(0, 1, bottom.getPiece(0, 1));
        bottom.setPiece(0, 1, right.getPiece(1, 0));
        right.setPiece(1, 0, temp);
    }

    public void rotateBackCounterClockwise() {
        back.rotateCounterClockwise();
        Piece temp = top.getPiece(0, 0);
        top.setPiece(0, 0, right.getPiece(1, 0));
        right.setPiece(1, 0, bottom.getPiece(0, 1));
        bottom.setPiece(0, 1, left.getPiece(0, 1));
        left.setPiece(0, 1, temp);
    }

    public void rotateBottomClockwise() {
        bottom.rotateClockwise();
        Piece temp = front.getPiece(1, 0);
        front.setPiece(1, 0, left.getPiece(1, 0));
        left.setPiece(1, 0, back.getPiece(1, 0));
        back.setPiece(1, 0, right.getPiece(1, 0));
        right.setPiece(1, 0, temp);
    }

    public void rotateBottomCounterClockwise() {
        bottom.rotateCounterClockwise();
        Piece temp = front.getPiece(1, 0);
        front.setPiece(1, 0, right.getPiece(1, 0));
        right.setPiece(1, 0, back.getPiece(1, 0));
        back.setPiece(1, 0, left.getPiece(1, 0));
        left.setPiece(1, 0, temp);
    }

    public void rotateLeftClockwise() {
        left.rotateClockwise();
        Piece temp = top.getPiece(0, 0);
        top.setPiece(0, 0, back.getPiece(0, 1));
        back.setPiece(0, 1, bottom.getPiece(0, 0));
        bottom.setPiece(0, 0, front.getPiece(0, 0));
        front.setPiece(0, 0, temp);
    }

    public void rotateLeftCounterClockwise() {
        left.rotateCounterClockwise();
        Piece temp = top.getPiece(0, 0);
        top.setPiece(0, 0, front.getPiece(0, 0));
        front.setPiece(0, 0, bottom.getPiece(0, 0));
        bottom.setPiece(0, 0, back.getPiece(0, 1));
        back.setPiece(0, 1, temp);
    }

    public void rotateRightClockwise() {
        right.rotateClockwise();
        Piece temp = top.getPiece(0, 1);
        top.setPiece(0, 1, front.getPiece(0, 1));
        front.setPiece(0, 1, bottom.getPiece(0, 1));
        bottom.setPiece(0, 1, back.getPiece(0, 0));
        back.setPiece(0, 0, temp);
    }

    public void rotateRightCounterClockwise() {
        right.rotateCounterClockwise();
        Piece temp = top.getPiece(0, 1);
        top.setPiece(0, 1, back.getPiece(0, 0));
        back.setPiece(0, 0, bottom.getPiece(0, 1));
        bottom.setPiece(0, 1, front.getPiece(0, 1));
        front.setPiece(0, 1, temp);
    }

    

    public void rotateTopCounterClockwise() {
        top.rotateCounterClockwise();
        Piece temp = front.getPiece(0, 0);
        front.setPiece(0, 0, right.getPiece(0, 0));
        right.setPiece(0, 0, back.getPiece(0, 0));
        back.setPiece(0, 0, left.getPiece(0, 0));
        left.setPiece(0, 0, temp);
    }

    public void rotateFrontCounterClockwise() {
        front.rotateCounterClockwise();
        Piece temp = top.getPiece(0, 1);
        top.setPiece(0, 1, right.getPiece(0, 0));
        right.setPiece(0, 0, bottom.getPiece(1, 0));
        bottom.setPiece(1, 0, left.getPiece(1, 1));
        left.setPiece(1, 1, temp);
    }

    public void rotateFrontClockwise() {
        front.rotateClockwise();
        Piece temp = top.getPiece(0, 1);
        top.setPiece(0, 1, left.getPiece(1, 1));
        left.setPiece(1, 1, bottom.getPiece(1, 0));
        bottom.setPiece(1, 0, right.getPiece(0, 0));
        right.setPiece(0, 0, temp);
    }

    

    
}
