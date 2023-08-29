import java.util.List;

import com.jogamp.opengl.GL2;

public class Draw{
    
    public void drawFigure(List<float[]> points, String whatToDraw, GL2 gl, float xShift){
        gl.glPushMatrix();
        gl.glTranslatef(xShift, 0.0f, 0.0f);
    
        if(whatToDraw.equalsIgnoreCase("GL_POINTS")||whatToDraw.equals("GL_LINE_STRIP")||whatToDraw.equals("GL_LINE_LOOP")||whatToDraw.equals("GL_TRIANGLE_STRIP")||whatToDraw.equals("GL_TRIANGLE_FAN")||whatToDraw.equals("GL_POLYGON")){
            System.out.println(whatToDraw);
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glTranslatef(-30.0f, 7.0f, -50.0f);
            int beingDrawed = getGL2Constant(whatToDraw);
            System.out.println(beingDrawed);
            gl.glBegin(beingDrawed);
            for (float[] point : points) {
                gl.glVertex3f(point[0], point[1], point[2]);
            }
            gl.glEnd();
        }else if(whatToDraw.equalsIgnoreCase("GL_LINES")){
            System.out.println(whatToDraw);
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glTranslatef(-30.0f, 7.0f, -25.0f);
            gl.glBegin(GL2.GL_LINES);
            for (int i = 0; i < points.size() - 1; i += 2) {
                gl.glVertex3f(points.get(i)[0], points.get(i)[1], points.get(i)[2]);
                gl.glVertex3f(points.get(i + 1)[0], points.get(i + 1)[1], points.get(i + 1)[2]);
            }
            gl.glEnd();
        }else if(whatToDraw.equalsIgnoreCase("GL_TRIANGLES")){
            System.out.println(whatToDraw);
            gl.glTranslatef(-30.0f, -7.0f, 0.0f);
            gl.glColor3f(1.0f, 2.0f, 15.0f);
            gl.glBegin(GL2.GL_TRIANGLES);
            for (int i = 0; i < 6; i += 3) {
                gl.glVertex3f(points.get(i)[0], points.get(i)[1], points.get(i)[2]);
                gl.glVertex3f(points.get(i + 1)[0], points.get(i + 1)[1], points.get(i + 1)[2]);
                gl.glVertex3f(points.get(i + 2)[0], points.get(i + 2)[1], points.get(i + 2)[2]);
            }
            gl.glEnd();
        }else if(whatToDraw.equalsIgnoreCase("GL_QUADS")){
            System.out.println(whatToDraw);
            gl.glTranslatef(-30.0f, 10.0f, -25.0f);
            gl.glColor3f(1.0f, 1.0f, 1.0f);
            gl.glBegin(GL2.GL_QUADS);
            gl.glVertex3f(points.get(0)[0], points.get(0)[1], points.get(0)[2]);
            gl.glVertex3f(points.get(1)[0], points.get(1)[1], points.get(1)[2]);
            gl.glVertex3f(points.get(5)[0], points.get(5)[1], points.get(5)[2]);
            gl.glVertex3f(points.get(6)[0], points.get(6)[1], points.get(6)[2]);
            gl.glEnd();
        }else if(whatToDraw.equalsIgnoreCase("GL_QUAD_STRIP")){
            System.out.println(whatToDraw);
            gl.glTranslatef(-30.0f, 10.0f, 0.0f);
            gl.glColor3f(1.0f, 1.0f, 1.0f);
            gl.glBegin(GL2.GL_QUAD_STRIP);
            for (int i = 0; i < points.size() - 1; i += 2) {
                gl.glVertex3f(points.get(i)[0], points.get(i)[1], points.get(i)[2]);
                gl.glVertex3f(points.get(i + 1)[0], points.get(i + 1)[1], points.get(i + 1)[2]);
            }
            gl.glEnd();
        }
        gl.glPopMatrix();
    }
    
    public int getGL2Constant(String whatToDraw){
        switch (whatToDraw.toUpperCase()) {
            case "GL_POINTS":
                return GL2.GL_POINTS;
            case "GL_LINE_STRIP":
                return GL2.GL_LINE_STRIP;
            case "GL_LINE_LOOP":
                return GL2.GL_LINE_LOOP;
            case "GL_TRIANGLE_STRIP":
                return GL2.GL_TRIANGLE_STRIP;
            case "GL_TRIANGLE_FAN":
                return GL2.GL_TRIANGLE_FAN;
            case "GL_POLYGON":
                return GL2.GL_POLYGON;
            default:
                return -1;
        }
    }
}