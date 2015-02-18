package starbuck.tests;

import java.awt.Color;
import java.util.Arrays;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRISphere;

public class TestSpheres2 extends TestObjetStub {
	private TRISphere[] spheres;
	private int N = 3;
	
	
	private Mouvement mvt = new Mouvement() {
		private int dim = N*N*N;
		private double latitude []; 
		private double longitude[]; 
		@Override
		public double latitude(int frame, int n) {
			latitude[n]+=(1.0*frame/200);
			return latitude[n];
		}

		@Override
		public double longitude(int frame, int n) {
			longitude[n]+=(1.0*frame/200);
			return longitude[n];
		}

		@Override
		public void dim(int dim) {
			this.dim = dim;
			latitude  = new double[dim]; 
			longitude = new double[dim]; 
			Arrays.fill(latitude, 0);
			Arrays.fill(longitude, 0);
		}

	};
	public interface Mouvement
	{
		public void dim(int dim);
		public double latitude(int frame, int N);
		public double longitude(int frame, int N);
	}
	
	public TestSpheres2() {
		spheres = new TRISphere[N * N * N];
		for (int i = 0; i < N * N * N; i++) {
			spheres[i] = new TRISphere(Point3D.O0, 1.0);
			spheres[i].texture(new TColor(new Color(
					(float) (1.0f * i / (N * N * N)),
					(float) (1.0f * i % 3 / (N)),
					(float) ((1.0f * i / N % 3) / N))));

		}

	}

	
	public void mvt(Mouvement mvt)
	{
		this.mvt  = mvt;
	}
	
	private Point3D coordPoint(int i) {

		double r = i;

		float PI = (float) Math.PI;

		return new Point3D(
				Math.cos(2 * PI * mvt.latitude(frame,i)) * Math.cos(PI * mvt.longitude(frame, i)),
				Math.cos(2 * PI * mvt.latitude(frame,i)) * Math.sin(PI * mvt.longitude(frame, i)), 
				Math.sin(2 * PI * mvt.latitude(frame,i))).mult(r);

	}

	@Override
	public void ginit() {
		for (int i = 0; i < spheres.length; i++)
			scene().add(spheres[i]);

		scene().cameraActive(
				new Camera(new Point3D(0, 0, -N * N * N), new Point3D(0, 0, 0)

				));
		mvt.dim(N*N*N);
	}

	@Override
	public void testScene() throws Exception {
		for (int i = 0; i < N * N * N; i++) {
			spheres[i].setCentre(coordPoint(i));
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TestSpheres2 tt = new TestSpheres2();
		tt.setResx(320);
		tt.setResy(240);
		tt.loop(true);
		tt.setMaxFrames(3000);

		tt.run();

	}

}
