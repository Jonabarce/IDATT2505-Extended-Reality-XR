import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import com.jogamp.opengl.util.Animator;


public class Main implements GLEventListener {
    private Cube cube;
    private static final float PIECE_SIZE = 0.5f;
    private static final float PIECE_SPACING = 0.05f;
    private float rotationX = 0.0f;
    private float rotationY = 0.0f;
    private float frontRotationAngle = 0;


    public Main() {
        // Initialisering av kube der hver side har en ensartet farge.
        Face front = new Face(new Piece("red", "", ""), new Piece("red", "", ""), new Piece("red", "", ""), new Piece("red", "", ""));
        Face back = new Face(new Piece("orange", "", ""), new Piece("orange", "", ""), new Piece("orange", "", ""), new Piece("orange", "", ""));
        Face left = new Face(new Piece("green", "", ""), new Piece("green", "", ""), new Piece("green", "", ""), new Piece("green", "", ""));
        Face right = new Face(new Piece("blue", "", ""), new Piece("blue", "", ""), new Piece("blue", "", ""), new Piece("blue", "", ""));
        Face top = new Face(new Piece("white", "", ""), new Piece("white", "", ""), new Piece("white", "", ""), new Piece("white", "", ""));
        Face bottom = new Face(new Piece("yellow", "", ""), new Piece("yellow", "", ""), new Piece("yellow", "", ""), new Piece("yellow", "", ""));
    
        cube = new Cube(front, back, left, right, top, bottom);
    }

    private void drawPartialRotation(GL2 gl) {
        if (frontRotationAngle < 90) {
            gl.glRotatef(frontRotationAngle, 0f, 0f, 1f); // Roter rundt Z-aksen for front ansikt
            frontRotationAngle += 5; // Increment angle for next frame
        }
    }

    private void updateRotation() {
        if (rotationX < 360.0f) {
            rotationX += 0.5f;
        } else if (rotationY < 360.0f) {
            rotationY += 0.5f;
        } else {
            rotationX = 0.0f;
            rotationY = 0.0f;
        }
    }

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Rubik's Cube");
        GLCanvas canvas = new GLCanvas();
        Main main = new Main();
        canvas.addGLEventListener(main);
        frame.add(canvas);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        Animator animator = new Animator(canvas);
        animator.start();
    
        canvas.requestFocusInWindow();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();
    gl.glClearColor(0f, 0f, 0f, 1f); // Set background color to black
    gl.glEnable(GL2.GL_DEPTH_TEST);  // <-- Add this line
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        updateRotation(); // Oppdater rotasjonen

        gl.glPushMatrix(); // Lagrer den nåværende transformasjonsmatrisen
        gl.glRotatef(rotationX, 1.0f, 0.0f, 0.0f); // Roter rundt X-aksen
        gl.glRotatef(rotationY, 0.0f, 1.0f, 0.0f); // Roter rundt Y-aksen

        drawFace(gl, cube.getFront(), 0f, 0f, 0.5f);

        gl.glPushMatrix();
        gl.glRotatef(180, 0f, 1f, 0f);
        drawFace(gl, cube.getBack(), 0f, 0f, 0.5f);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotatef(-90, 0f, 1f, 0f);
        drawFace(gl, cube.getLeft(), 0f, 0f, 0.5f);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotatef(90, 0f, 1f, 0f);
        drawFace(gl, cube.getRight(), 0f, 0f, 0.5f);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotatef(-90, 1f, 0f, 0f);
        drawFace(gl, cube.getTop(), 0f, 0f, 0.5f);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glRotatef(90, 1f, 0f, 0f);
        drawFace(gl, cube.getBottom(), 0f, 0f, 0.5f);
        gl.glPopMatrix();

        gl.glPopMatrix();
    
    }


    private void drawFace(GL2 gl, Face face, float offsetX, float offsetY, float offsetZ) {
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                Piece piece = face.getPiece(x, y);
                
                // Juster posisjonen for hver brikke basert på indeksen
                float adjustedOffsetX = offsetX + (x - 0.5f) * (PIECE_SIZE + PIECE_SPACING);
                float adjustedOffsetY = offsetY + (y - 0.5f) * (PIECE_SIZE + PIECE_SPACING);
    
                drawPiece(gl, piece, adjustedOffsetX, adjustedOffsetY, offsetZ);
            }
        }
    }
    
    private void drawPiece(GL2 gl, Piece piece, float offsetX, float offsetY, float offsetZ) {
        String color = piece.getColor1();
        switch (color) {
            case "red":
                gl.glColor3f(1f, 0f, 0f);
                break;
            case "green":
                gl.glColor3f(0f, 1f, 0f);
                break;
            case "blue":
                gl.glColor3f(0f, 0f, 1f);
                break;
            case "yellow":
                gl.glColor3f(1f, 1f, 0f);
                break;
            case "white":
                gl.glColor3f(1f, 1f, 1f);
                break;
            case "orange":
                gl.glColor3f(1f, 0.5f, 0f);
                break;
        }
    
        float halfSize = PIECE_SIZE / 2;
    
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3f(-halfSize + offsetX, -halfSize + offsetY, offsetZ);
        gl.glVertex3f(halfSize + offsetX, -halfSize + offsetY, offsetZ);
        gl.glVertex3f(halfSize + offsetX, halfSize + offsetY, offsetZ);
        gl.glVertex3f(-halfSize + offsetX, halfSize + offsetY, offsetZ);
        gl.glEnd();
    }

    private void drawCube(GL2 gl, Piece piece, float offsetX, float offsetY, float offsetZ) {
        float depth = PIECE_SPACING;  // Antar at dybden av hvert stykke er samme som PIECE_SPACING
    
        // Tegn forside
        drawPiece(gl, piece, offsetX, offsetY, offsetZ + depth/2);
    
        // Tegn bakside
        drawPiece(gl, piece, offsetX, offsetY, offsetZ - depth/2);
    
        // Tegn venstre side
        gl.glPushMatrix();
        gl.glRotatef(-90, 0f, 1f, 0f);
        drawPiece(gl, piece, offsetX, offsetY, offsetZ);
        gl.glPopMatrix();
    
        // Tegn høyre side
        gl.glPushMatrix();
        gl.glRotatef(90, 0f, 1f, 0f);
        drawPiece(gl, piece, offsetX, offsetY, offsetZ);
        gl.glPopMatrix();
    
        // Tegn topp
        gl.glPushMatrix();
        gl.glRotatef(-90, 1f, 0f, 0f);
        drawPiece(gl, piece, offsetX, offsetY, offsetZ);
        gl.glPopMatrix();
    
        // Tegn bunn
        gl.glPushMatrix();
        gl.glRotatef(90, 1f, 0f, 0f);
        drawPiece(gl, piece, offsetX, offsetY, offsetZ);
        gl.glPopMatrix();
    }
    
    
    
    

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        // Handle window resizing here if necessary
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // Cleanup resources if any
    }
}
