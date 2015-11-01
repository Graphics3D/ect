package starbuck.tests;
/*
import java.awt.Color;
import java.util.ArrayList;

import info.emptycanvas.library.BezierCubique;
import info.emptycanvas.library.Point3D;
import info.emptycanvas.library.base.ExtrusionGeneralisee.EG_Fonction_Courbe;
import info.emptycanvas.library.base.ExtrusionGeneralisee.EG_Fonction_Surface;
import info.emptycanvas.library.base.ExtrusionGeneralisee.Point;
import info.emptycanvas.library.base.TourDeRevolution;
import be.ibiiztera.md.pmatrix.test.pushmatrix.newtest.TestObjetSub;

public class GodAnal extends TestObjetSub {

	public GodAnal() {
	}

	@Override
	public void testScene() throws Exception {
		final ArrayList<BezierCubique> bcs = new ArrayList<BezierCubique>();

		BezierCubique bc;
		bc = new BezierCubique();

		bc.add(new Point3D(0, 0, 0));
		bc.add(new Point3D(2, 4, 0));
		bc.add(new Point3D(2, 6, 0));
		bc.add(new Point3D(0, 7, 0));
		bc.setColor(Color.RED);
		bcs.add(bc);

		bc = new BezierCubique();

		bc.add(new Point3D(0, 6, 0));
		bc.add(new Point3D(0, 7, 0));
		bc.add(new Point3D(4, 8, 0));
		bc.add(new Point3D(0, 9, 0));
		bc.setColor(Color.RED);
		
		bcs.add(bc);

		scene().clear();
		scene().add(bcs.get(0));
		scene().add(bcs.get(1));
		
		
		new TourDeRevolution(new EG_Fonction_Courbe() {
			
			@Override
			public Point3D fonction(double t) {
				return bcs.get(0).calculerPoint3D(t);
			}
		}, new EG_Fonction_Surface() {
			
			@Override
			public Point fonction(double t) {
				return this.new Point(Math.cos(2*Math.PI*t), Math.sin(2*Math.PI*t));
			}
		}, 10, 10);
		new TourDeRevolution(new EG_Fonction_Courbe() {
			
			@Override
			public Point3D fonction(double t) {
				return bcs.get(1).calculerPoint3D(t);
			}
		}, new EG_Fonction_Surface() {
			
			@Override
			public Point fonction(double t) {
				return new be.ibiizPoint(Math.cos(2*Math.PI*t), Math.sin(2*Math.PI*t));
			}
		}, 10, 10);
	}
	public static void main(String[] args) {
		GodAnal ga = new GodAnal();

		ga.loop(false);

		ga.run();
	}

}
*/