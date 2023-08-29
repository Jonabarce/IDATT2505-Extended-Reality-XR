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

public class Figures implements GLEventListener {

    @Override
    public void display(GLAutoDrawable drawable) {

        List<float[]> points = new ArrayList<>();
        points.add(new float[]{0.0f, 2.0f, 0.0f});
        points.add(new float[]{1.5f, 1.5f, 0.0f});
        points.add(new float[]{2.0f, 0.0f, 0.0f});
        points.add(new float[]{1.5f, -1.5f, 0.0f});
        points.add(new float[]{0.0f, -2.0f, 0.0f});
        points.add(new float[]{-1.5f, -1.5f, 0.0f});
        points.add(new float[]{-2.0f, 0.0f, 0.0f});
        points.add(new float[]{-1.5f, 1.5f, 0.0f});
    
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    
        gl.glLoadIdentity();
        gl.glTranslatef(0f, 0.0f, -40.0f);
    
        float xShift = -15.0f; 
        float increment = 10.0f; 

        Draw drawFigure = new Draw();
    
        drawFigure.drawFigure(points, "GL_POINTS", gl, xShift);
        xShift += increment;
    
        drawFigure.drawFigure(points, "GL_LINE_STRIP", gl, xShift);
        xShift += increment;
    
        drawFigure.drawFigure(points, "GL_LINE_LOOP", gl, xShift);
        xShift += increment;
    
        drawFigure.drawFigure(points, "GL_LINES", gl, xShift);
        xShift += increment;
    
        drawFigure.drawFigure(points, "GL_TRIANGLES", gl, xShift);
        xShift += increment;
    
        drawFigure.drawFigure(points, "GL_QUADS", gl, xShift);
        xShift += increment;
    
        drawFigure.drawFigure(points, "GL_QUAD_STRIP", gl, xShift);
        xShift += increment;
    
        drawFigure.drawFigure(points, "GL_TRIANGLE_STRIP", gl, xShift);
        xShift += increment;
    
        drawFigure.drawFigure(points, "GL_TRIANGLE_FAN", gl, xShift);
        xShift += increment;
    
        drawFigure.drawFigure(points, "GL_POLYGON", gl, xShift);
        xShift += increment;
    
        gl.glFlush();

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
       Figures l = new Figures();
       glcanvas.addGLEventListener(l);
       glcanvas.setSize(1000, 1000);
    
       final JFrame frame = new JFrame ("straight Line");
    
       frame.getContentPane().add(glcanvas);
                  
       frame.setSize(frame.getContentPane().getPreferredSize());
       frame.setVisible(true);
       
    }
    
}
