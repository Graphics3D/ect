/*
 * 2013 Manuel Dahmen
 */
package triangles;

import java.awt.Color;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;

public class TestTriangles extends TestObjet{

	public TestTriangles() {
 	}
	
	
	@Override
	public void testScene() throws Exception {
            scene().clear();
            
            
		SiPiKi3D si = new SiPiKi3D();
		
		
		si.add(new TRI(Point3D.O0, Point3D.X, Point3D.Y, Color.BLUE), frame);
		
		scene().add(si);
		
		scene().cameraActive(new Camera(new Point3D(0.5, 0.5, -1.2), new Point3D(0.5,0.5,0)));
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestTriangles tt = new TestTriangles();
                tt.loop(true);
                tt.setMaxFrames(5);
		tt.setResx(1024);
		tt.setResy(768);
		tt.run();
	}

}
