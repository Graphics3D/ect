package starbuck.tests;

import java.awt.Color;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.CheminDroite;
import info.emptycanvas.library.tribase.SurfaceCercle;
import info.emptycanvas.library.tribase.TRIExtrusionGeneralisee;

public class TestTRIExtrusionGeneralisee extends TestObjet{

	public void testScene(){
		TRIExtrusionGeneralisee te = new TRIExtrusionGeneralisee();
		te.chemin = new CheminDroite(new SegmentDroite(Point3D.Y.mult(-1),Point3D.Y.mult(1)));
		te.surface = new SurfaceCercle(1d);
		te.texture(new TColor(Color.red));
		te.setMaxX(20);
		te.setMaxY(20);
		scene().add(te);
		
		scene().cameraActive(new Camera(Point3D.Z.mult(4), Point3D.O0));
	}

	public static void main(String [ ] args){
		TestTRIExtrusionGeneralisee te = new  TestTRIExtrusionGeneralisee();
		
		te.publishResult(true);
		te.loop(false);
		
		te.run();
	}


		
	
	
}
