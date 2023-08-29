import javax.swing.*;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;


public class GlutCubeWithGluLookAt implements GLEventListener {

    private GLU glu;
    private GLUT glut;
    
    @Override
    public void display(GLAutoDrawable drawable) {
      GL2 gl = drawable.getGL().getGL2();
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
      gl.glMatrixMode(GL2.GL_MODELVIEW);
      gl.glLoadIdentity();
      gl.glTranslatef(0f, 0.5f, -7f);
    glu.gluLookAt(0.0f, 2.0f, 0.0f, 
                    0.0f, 0.0f, -1.0f, 
                    0.0f, 1.0f, 0.0f);
   
      // First cube: 
      // Rotation, Translation and Scaling
      gl.glPushMatrix();
      gl.glRotatef(45.0f, 0.1f, 1.0f, 0.0f);  
      gl.glTranslatef(-2.0f, 0.0f, 0.0f);     
      gl.glScalef(0.5f, 1.5f, 0.5f);          
      glut.glutWireCube(1.0f);
      gl.glPopMatrix();
   

      // Second cube: 
      // Translation, Scaling, Rotation     
      gl.glPushMatrix();
      gl.glTranslatef(2.0f, 0.0f, 0.0f);      
      gl.glScalef(0.5f, 1.5f, 0.5f);          
      gl.glRotatef(45.0f, 0.1f, 1.0f, 0.0f); 
      glut.glutWireCube(1.0f);
      gl.glPopMatrix();
    }
    
    

    @Override
    public void dispose(GLAutoDrawable arg0) {
      //method body
    }  



    @Override
    public void init(GLAutoDrawable arg0) {
      glu = new GLU();
      glut = new GLUT();
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
         GlutCubeWithGluLookAt l = new GlutCubeWithGluLookAt();
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(1000, 1000);
     
        final JFrame frame = new JFrame ("straight Line");
     
        frame.getContentPane().add(glcanvas);
                   
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        
     }
}
