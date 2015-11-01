/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.TRISphere;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Atelier
 */
public class TestAnimationSphereInterieurBezierS extends TestObjetSub{

	private BezierCubique newBezier(BezierCubique old)
	
	{
		Point3D [] xy = new Point3D[4];
		if(old!=null)
		{
			xy[0] = old.get(3);
		}
		else
		{
			xy[0] = new Point3D(Math.PI*(Math.random()-0.5), Math.PI*2*(Math.random()-0.5), 0);
		}
		for(int i=1; i<4; i++)
		{
			xy[i] = new Point3D(Math.PI*(Math.random()-0.5), Math.PI*2*(Math.random()-0.5), 0);
		}
		BezierCubique bc = new BezierCubique();
		for(int i=0; i<4; i++)
		{
			bc.add(xy[i]);
		}
		return bc;
	}

    private Point3D coordSphere(double a, double b, double radius) {
        return new Point3D(Math.cos(a) * Math.cos(b) * radius,
                0 + Math.cos(a) * Math.sin(b) * radius,
                0 + Math.sin(a) * radius);

    }
    private double a;
    private double b;
    private Point3D pos;

    @Override
    public void ginit() {
        try {
            super.ginit();

            TRISphere ts = new TRISphere(new Point3D(0, 0, 0), 100);

            ts.texture(
            		new TColor(
            				new ECBufferedImage(
            						ImageIO.read(
           getClass().getResource("cracked-earth-texture.jpg")
            						)
            					)
            				)
            		);
            
            ts.setMaxX(30);
            ts.setMaxY(30);
            
            scene().add(ts);
        } catch (IOException ex) {
            Logger.getLogger(TestAnimationSphereInterieurBezierS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
	{
		a = 0;
		b = 0;
	}
	private BezierCubique bc;
	private int n=300;
    @Override
    public void testScene() {
		if(frame%n==0 || bc==null)
		{
			bc = newBezier(bc);
        }
		a = bc.calculerPoint3D((1.0*((frame+n)%n))/n).getX();
        b = bc.calculerPoint3D((1.0*((frame+n)%n))/n).getY();
        if (a > Math.PI / 2) {
			a = Math.PI / 2;
        }
        if (a < -Math.PI / 2) {
            a = -Math.PI / 2;
        }
        if (b > Math.PI) {
            a = -Math.PI;
        }
        if (b < -Math.PI) {
            a = Math.PI;
        }
        pos = coordSphere(a, b, 10);
        scene().cameras().clear();
        scene().cameraActive(new Camera(pos, new Point3D(0, 0, 0)));
		camera(new Camera(pos, new Point3D(0, 0, 0)));
        description("Textured sphere seen from inside");

    }

    public static void main(String[] args) {
            TestAnimationSphereInterieurBezierS to = new TestAnimationSphereInterieurBezierS();
            to.setResx(640);
            to.setResy(480);
            to.loop(true);
            to.setMaxFrames(6000);
			Thread runnable = new Thread(to);
            runnable.start();


    }
}
