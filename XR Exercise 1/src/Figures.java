
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.jogamp.opengl.GL;
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
  
      final GL2 gl = drawable.getGL().getGL2();
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
   
 
      // GL_POINTS
      gl.glColor3f(1.0f, 0.0f, 0.0f);
      gl.glTranslatef(-5.0f, 7.0f, -25.0f);
      gl.glBegin(GL2.GL_POINTS);
      for (float[] point : points) {
          gl.glVertex3f(point[0], point[1], point[2]);
      }
      gl.glEnd();
  

      // GL_LINES
      gl.glTranslatef(-5.0f, 0.0f, -25.0f);
      gl.glColor3f(1.0f, 0.0f, 1.0f);
      gl.glBegin(GL2.GL_LINES);
      for (int i = 0; i < points.size() - 1; i += 2) {
          gl.glVertex3f(points.get(i)[0], points.get(i)[1], points.get(i)[2]);
          gl.glVertex3f(points.get(i + 1)[0], points.get(i + 1)[1], points.get(i + 1)[2]);
      }
      gl.glEnd();
  

      // GL_LINE_STRIP
      gl.glTranslatef(-5.0f, -7.0f, -25.0f);
      gl.glColor3f(1.0f, 2.0f, 15.0f);
      gl.glBegin(GL2.GL_LINE_STRIP);
      for (float[] point : points) {
          gl.glVertex3f(point[0], point[1], point[2]);
      }
      gl.glEnd();
  

      // GL_LINE_LOOP
      gl.glTranslatef(-5.0f, -7.0f, -25.0f);
      gl.glColor3f(1.0f, 2.0f, 15.0f);
      gl.glBegin(GL2.GL_LINE_LOOP);
      for (float[] point : points) {
          gl.glVertex3f(point[0], point[1], point[2]);
      }
      gl.glEnd();
  

      // GL_TRIANGLES
      gl.glTranslatef(-5.0f, -7.0f, 0.0f);
      gl.glColor3f(1.0f, 2.0f, 15.0f);
      gl.glBegin(GL2.GL_TRIANGLES);
      for (int i = 0; i < 6; i += 3) {
          gl.glVertex3f(points.get(i)[0], points.get(i)[1], points.get(i)[2]);
          gl.glVertex3f(points.get(i + 1)[0], points.get(i + 1)[1], points.get(i + 1)[2]);
          gl.glVertex3f(points.get(i + 2)[0], points.get(i + 2)[1], points.get(i + 2)[2]);
      }
      gl.glEnd();
  

      //GL_TRIANGLE_STRIP
      gl.glTranslatef(10.0f, -7.0f, 0.0f);
      gl.glColor3f(1.0f, 2.0f, 15.0f);
      gl.glBegin(GL2.GL_TRIANGLE_STRIP);
      for (float[] point : points) {
         gl.glVertex3f(point[0], point[1], point[2]);
      }
      gl.glEnd();

      
      //GL_TRIANGLE_FAN
      gl.glTranslatef(10.0f, -7.0f, 0.0f);
      gl.glColor3f(1.0f, 2.0f, 15.0f);
      gl.glBegin(GL2.GL_TRIANGLE_FAN);
      for (float[] point : points) {
          gl.glVertex3f(point[0], point[1], point[2]);
      }
      gl.glEnd();


      //GL_QUADS
      gl.glTranslatef(10.0f, 10.0f, 0.0f);
      gl.glColor3f(1.0f, 2.0f, 15.0f);
      gl.glBegin(GL2.GL_QUADS);
      gl.glVertex3f(points.get(0)[0], points.get(0)[1], points.get(0)[2]);
      gl.glVertex3f(points.get(1)[0], points.get(1)[1], points.get(1)[2]);
      gl.glVertex3f(points.get(5)[0], points.get(5)[1], points.get(5)[2]);
      gl.glVertex3f(points.get(6)[0], points.get(6)[1], points.get(6)[2]);
      gl.glEnd();


      //GL_QUAD_STRIP
      gl.glTranslatef(10.0f, 10.0f, 0.0f);
      gl.glColor3f(1.0f, 2.0f, 15.0f);
      gl.glBegin(GL2.GL_QUAD_STRIP);
      for (int i = 0; i < points.size() - 1; i += 2) {
         gl.glVertex3f(points.get(i)[0], points.get(i)[1], points.get(i)[2]);
         gl.glVertex3f(points.get(i + 1)[0], points.get(i + 1)[1], points.get(i + 1)[2]);
      }
      gl.glEnd();


      //GL_POLYGON
      gl.glTranslatef(10.0f, 10.0f, 0.0f);
      gl.glColor3f(1.0f, 2.0f, 15.0f);
      gl.glBegin(GL2.GL_POLYGON);
      for (float[] point : points) {
         gl.glVertex3f(point[0], point[1], point[2]);
      }
      gl.glEnd();

  }
             
    @Override
    public void dispose(GLAutoDrawable arg0) {

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
