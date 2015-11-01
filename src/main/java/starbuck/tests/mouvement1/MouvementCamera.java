package starbuck.tests.mouvement1;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;

public class MouvementCamera {
	public abstract class BCAdder
	{
		public abstract Point3D getP3();
		public abstract Point3D getP4();
	}
	public class CameraBezier {
		public double TAN_INCR = 0.001;
		private double fct = 0.0;
		private BezierCubique bc;
		private Camera camera;
		private int fps = 25;
		private double ups = 1.0;
		private double [] cube = new double [6];
		private BCAdder bcadder = null;
		
		public CameraBezier(double [] coordsEnglobe)
		{
			for(int i=0; i<6; i++)
			{
				cube[i] = coordsEnglobe[i];
			}
			
			bc = new BezierCubique();
		}
		
		public void initTime(int fps, double ups)
		{
			this.ups = ups;
			this.fps = fps;
		}
		
		public void computeUPS()
		{
			ups = Math.pow((cube[1]-cube[0])*(cube[3]-cube[2])*(cube[5]-cube[4]), 1/3.0);
		}
		protected void setBCAdder(BCAdder bcadder)
		{
			this.bcadder = bcadder;
		}
		public void nextPoint()
		{
			Point3D visee = null;
			Point3D point = null;
			
			double timeInc = 1.0/fps;
			
			if(fct+TAN_INCR>1.0)
			{
				bc.add(bcadder.getP3());
				bc.add(bcadder.getP4());
				fct = 0.0;
			}
			
			camera = new Camera(
					bc.calculerPoint3D(fct),
					bc.calculerPoint3D(fct+TAN_INCR)
			);
			
			fct += ups/fps;
		}
		public Camera camera()
		{
			return camera;
		}
	}
	
	
}
