/**
 * 
 */
package starbuck.tests;

import info.emptycanvas.library.export.STLExport;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRICylindre;
import info.emptycanvas.library.tribase.TRIEllipsoide;

/**
 * @author Manuel DAHMEN
 * 
 */
public class TestPersoSTL {
	public static String path = "f:\\bin\\";
	public static Scene scene = new Scene();

	public static Scene scene() {
		return scene;
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		TRIEllipsoide ell = new TRIEllipsoide(new Point3D(0, 175, 0), 10, 30,
				10);
		ell.texture(new TColor(Color.PINK));
		ell.setMaxX(20);
		ell.setMaxY(20);
		scene().add(ell);

		TRICylindre cyl = new TRICylindre(Point3D.Y.mult(100), 15, 10);
		cyl.texture(new TColor(Color.PINK));
		cyl.setMaxX(20);
		cyl.setMaxY(20);
		scene().add(cyl);

		scene().cameraActive(new Camera(new Point3D(0, 170, -400), Point3D.O0));

		File f;
		try {
			f = File.createTempFile("TMP", "perso.STL", new File("c:\\objets\\stl\\"));
			STLExport.save(f, scene(), true);
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}

	}
}
