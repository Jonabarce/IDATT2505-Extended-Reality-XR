

import javax.swing.*;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;

import com.jogamp.opengl.awt.GLCanvas;

public class Triangle implements GLEventListener {



@Override
   public void display(GLAutoDrawable drawable) {
    final GL2 gl = drawable.getGL().getGL2();


    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity();

    gl.glColor3f(1.0f, 0.0f, 0.0f);

    gl.glBegin(GL.GL_TRIANGLES);
    gl.glVertex3f(0.0f, 1.0f, 0.0f);
    gl.glVertex3f(-1.0f, -1.0f, 0.0f);
    gl.glVertex3f(1.0f, -1.0f, 0.0f);
    gl.glEnd();

   }
            
   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }
            
   @Override
   public void init(GLAutoDrawable arg0) {
      // method body
   }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
       // method body
    }
	
   public static void main(String[] args) {

      //getting the capabilities object of GL2 profile        
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Triangle l = new Triangle();
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(1000, 1000);
   
      //creating frame
      final JFrame frame = new JFrame ("straight Line");
   
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
                 
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
      
   }
	
}