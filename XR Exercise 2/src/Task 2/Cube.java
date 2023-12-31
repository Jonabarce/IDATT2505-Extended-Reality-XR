import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;



public class Cube implements GLEventListener {
    
    @Override
public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity();
    gl.glTranslatef(0f, 1f, -5f);

    // Face1
    gl.glColor3f(1.0f, 0.0f, 0.0f);
    gl.glBegin(GL2.GL_LINE_LOOP);
    gl.glVertex3f(-0.1f, 0.0f, 0.0f);
    gl.glVertex3f(0.4f, 0.0f, 0.0f);
    gl.glVertex3f(0.4f, -0.3f, 0.0f);
    gl.glVertex3f(-0.1f, -0.3f, 0.0f);
    gl.glEnd();

    // Face2
    gl.glColor3f(1.0f, 1.0f, 0.0f);
    gl.glBegin(GL2.GL_LINE_LOOP);
    gl.glVertex3f(-0.1f, -0.3f, 0.0f);
    gl.glVertex3f(-0.1f, -0.3f, 1.0f);
    gl.glVertex3f(-0.1f, 0.0f, 1.0f);
    gl.glVertex3f(-0.1f, 0.0f, 0.0f);
    gl.glEnd();

    // Face3
    gl.glColor3f(1.0f, 0.0f, 1.0f);
    gl.glBegin(GL2.GL_LINE_LOOP);
    gl.glVertex3f(-0.1f, 0.0f, 0.0f);
    gl.glVertex3f(-0.1f, 0.0f, 1.0f);
    gl.glVertex3f(0.4f, 0.0f, 1.0f);
    gl.glVertex3f(0.4f, 0.0f, 0.0f);
    gl.glEnd();

    // Face4
    gl.glColor3f(0.0f, 1.0f, 1.0f);
    gl.glBegin(GL2.GL_LINE_LOOP);
    gl.glVertex3f(0.4f, 0.0f, 0.0f);
    gl.glVertex3f(0.4f, 0.0f, 1.0f);
    gl.glVertex3f(0.4f, -0.3f, 1.0f);
    gl.glVertex3f(0.4f, -0.3f, 0.0f);
    gl.glEnd();

    // Face5
    gl.glColor3f(0.0f, 1.0f, 0.0f);
    gl.glBegin(GL2.GL_LINE_LOOP);
    gl.glVertex3f(0.4f, -0.3f, 0.0f);
    gl.glVertex3f(-0.1f, -0.3f, 0.0f);
    gl.glVertex3f(-0.1f, -0.3f, 1.0f);
    gl.glVertex3f(0.4f, -0.3f, 1.0f);
    gl.glEnd();

    // Face6
    gl.glColor3f(0.0f, 0.0f, 1.0f);
    gl.glBegin(GL2.GL_LINE_LOOP);
    gl.glVertex3f(0.4f, -0.3f, 1.0f);
    gl.glVertex3f(-0.1f, -0.3f, 1.0f);
    gl.glVertex3f(-0.1f, 0.0f, 1.0f);
    gl.glVertex3f(0.4f, 0.0f, 1.0f);
    gl.glEnd();
}


    @Override
    public void dispose(GLAutoDrawable arg0) {
      //method body
    }  
    private GLU glu;

    @Override
    public void init(GLAutoDrawable arg0) {
      glu = new GLU();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
       final GL2 gl = drawable.getGL().getGL2();
       if (height <= 0) { 
          height = 1;
       }
       gl.glViewport(0, 0, width, height);
       gl.glMatrixMode(GL2.GL_PROJECTION);
       gl.glLoadIdentity();
    
       float aspectRatio = (float) width / (float) height;
       glu.gluPerspective(45.0f, aspectRatio, 1.0f, 100.0f);
       gl.glMatrixMode(GL2.GL_MODELVIEW);
       gl.glLoadIdentity();
    }

    public static void main(String[] args) {
     
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
     
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        Cube l = new Cube();
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(1000, 1000);
     
        final JFrame frame = new JFrame ("straight Line");
     
        frame.getContentPane().add(glcanvas);
                   
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        
     }
}
