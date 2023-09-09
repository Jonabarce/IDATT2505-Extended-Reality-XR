
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jogamp.opengl.util.Animator;
import java.awt.*;

import com.jogamp.opengl.glu.GLU;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;






public class Main implements GLEventListener {
    private Cube cube;
    private static final float PIECE_SIZE = 0.5f;
    private static final float PIECE_SPACING = 0.05f;
    private float rotationX = 0.0f;
    private float rotationY = 0.0f;
    private static Point lastMousePoint;


    public Main() {
        cube = loadCubeFromFile("cube.csv");
    }

        public void saveCubeToFile(Cube cube, String filename) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            // For hver side av kuben:
            for (Face face : new Face[]{cube.getFront(), cube.getBack(), cube.getLeft(), cube.getRight(), cube.getTop(), cube.getBottom()}) {
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        writer.print(face.getPiece(x, y).getColor1());
                        writer.print(",");  // separerer med komma for CSV
                    }
                }
                writer.println();  // ny linje for hver side av kuben
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Cube loadCubeFromFile(String filename) {
    try (Scanner scanner = new Scanner(new File(filename))) {
        List<Face> faces = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] pieces = line.split(",");
            Face face = new Face(
                new Piece(pieces[0]), new Piece(pieces[1]),
                new Piece(pieces[2]), new Piece(pieces[3])
            );
            faces.add(face);
        }

        return new Cube(faces.get(0), faces.get(1), faces.get(2), faces.get(3), faces.get(4), faces.get(5));

        } catch (FileNotFoundException e) {
            // Fil ikke funnet, returner en ny kube
            return initializeFreshCube();
        }
    }

    public Cube initializeFreshCube() {
        Face front = new Face(new Piece("red"), new Piece("red"), new Piece("red"), new Piece("red"));
        Face back = new Face(new Piece("orange"), new Piece("orange"), new Piece("orange"), new Piece("orange"));
        Face left = new Face(new Piece("green"), new Piece("green"), new Piece("green"), new Piece("green"));
        Face right = new Face(new Piece("blue"), new Piece("blue"), new Piece("blue"), new Piece("blue"));
        Face top = new Face(new Piece("white"), new Piece("white"), new Piece("white"), new Piece("white"));
        Face bottom = new Face(new Piece("yellow"), new Piece("yellow"), new Piece("yellow"), new Piece("yellow"));

        return new Cube(front, back, left, right, top, bottom);
    }


    

    



    public static void main(String[] args) {
        final JFrame frame = new JFrame("Rubik's Cube");
        GLCanvas canvas = new GLCanvas();
        Main main = new Main();
        canvas.addGLEventListener(main);

        JButton btnTopClockwise = new JButton("Top Clockwise");
        btnTopClockwise.addActionListener(e -> main.cube.rotateTopClockwise());

        JButton btnTopCounterClockwise = new JButton("Top Counter Clockwise");
        btnTopCounterClockwise.addActionListener(e -> main.cube.rotateTopCounterClockwise());

        JButton btnBottomClockwise = new JButton("Bottom Clockwise");
        btnBottomClockwise.addActionListener(e -> main.cube.rotateBottomClockwise());

        JButton btnBottomCounterClockwise = new JButton("Bottom Counter Clockwise");
        btnBottomCounterClockwise.addActionListener(e -> main.cube.rotateBottomCounterClockwise());

        JButton rotateLeftAboutXAxisUp = new JButton("Rotate left about x axis up");
        rotateLeftAboutXAxisUp.addActionListener(e -> main.cube.rotateLeftSideAboutXAxisUp());

        JButton rotateLeftAboutXAxisDown = new JButton("Rotate left about x axis down");
        rotateLeftAboutXAxisDown.addActionListener(e -> main.cube.rotateLeftSideAboutXAxisDown());

        JButton rotateRightAboutXAxisUp = new JButton("Rotate right about x axis up");
        rotateRightAboutXAxisUp.addActionListener(e -> main.cube.rotateRightSideAboutXAxisUp());

        JButton rotateRightAboutXAxisDown = new JButton("Rotate right about x axis down");
        rotateRightAboutXAxisDown.addActionListener(e -> main.cube.rotateRightSideAboutXAxisDown());

        JButton rotateFrontSideAboutZAxisClockWise = new JButton("Rotate front side about z axis clockwise");
        rotateFrontSideAboutZAxisClockWise.addActionListener(e -> main.cube.rotateFrontSideAboutZAxisClockWise());

        JButton rotateFrontSideAboutZAxisCounterClockWise = new JButton("Rotate front side about z axis counter clockwise");
        rotateFrontSideAboutZAxisCounterClockWise.addActionListener(e -> main.cube.rotateFrontSideAboutZAxisCounterClockWise());

        JButton rotateBackSideAboutZAxisClockWise = new JButton("Rotate back side about z axis clockwise");
        rotateBackSideAboutZAxisClockWise.addActionListener(e -> main.cube.rotateBackSideAboutZAxisClockWise());

        JButton  rotateBackSideAboutZAxisCounterClockWise = new JButton("Rotate back side about z axis counter clockwise");
        rotateBackSideAboutZAxisCounterClockWise.addActionListener(e -> main.cube.rotateBackSideAboutZAxisCounterClockWise());
        




        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(14, 1));
        
        buttonPanel.add(btnTopClockwise);
        buttonPanel.add(btnTopCounterClockwise);

        buttonPanel.add(btnBottomClockwise);
        buttonPanel.add(btnBottomCounterClockwise);

        buttonPanel.add(rotateLeftAboutXAxisUp);
        buttonPanel.add(rotateLeftAboutXAxisDown);

        buttonPanel.add(rotateRightAboutXAxisUp);
        buttonPanel.add(rotateRightAboutXAxisDown);

        buttonPanel.add(rotateFrontSideAboutZAxisClockWise);
        buttonPanel.add(rotateFrontSideAboutZAxisCounterClockWise);

        buttonPanel.add(rotateBackSideAboutZAxisClockWise);
        buttonPanel.add(rotateBackSideAboutZAxisCounterClockWise);

        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.EAST);
        frame.add(canvas, BorderLayout.CENTER);

        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Animator animator = new Animator(canvas);
        animator.start();

        canvas.requestFocusInWindow();

        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (lastMousePoint != null) {
                    float deltaX = e.getX() - lastMousePoint.x;
                    float deltaY = e.getY() - lastMousePoint.y;
        
                    main.rotationX += deltaY * 0.5f; 
                    main.rotationY += deltaX * 0.5f; 
        
                    canvas.display();
                }
                lastMousePoint = e.getPoint();
            }
        
            @Override
            public void mouseReleased(MouseEvent e) {
                lastMousePoint = null;
            }
        });
    }



    @Override
    public void init(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();
    gl.glClearColor(0f, 0f, 0f, 1f);
    gl.glEnable(GL2.GL_DEPTH_TEST);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();

        GLU glu = new GLU();
        glu.gluLookAt(3, 3, 3, 0, 0, 0, 0, 1, 0);

        gl.glPushMatrix(); 
        gl.glRotatef(rotationX, 1.0f, 0.0f, 0.0f); 
        gl.glRotatef(rotationY, 0.0f, 1.0f, 0.0f); 

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

    
    
    
    
    

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    GL2 gl = drawable.getGL().getGL2();
    if (height <= 0) { 
        height = 1;
    }
    float aspect = (float) width / (float) height;

    gl.glViewport(0, 0, width, height);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();

    GLU glu = new GLU();
    glu.gluPerspective(45.0, aspect, 0.1, 100.0);

    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity();
}

    @Override
    public void dispose(GLAutoDrawable drawable) {
        saveCubeToFile(cube, "cube.csv");

    }
}
