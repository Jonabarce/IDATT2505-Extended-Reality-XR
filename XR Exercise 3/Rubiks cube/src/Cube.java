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

    public void rotateFrontClockwise() {
        Face oldFront = getFront();
    
        // roter front ansikt
        setFront(new Face(oldFront.getPiece(1,0), oldFront.getPiece(0,0),
                          oldFront.getPiece(1,1), oldFront.getPiece(0,1)));
    
        // Håndtere endringer i andre sider som følge av denne rotasjonen også...
        // Eks: Top, Bottom, Left, Right endrer seg også når Front roteres.
    }

    

    
}
