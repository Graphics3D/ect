
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.*;
import java.awt.Color;

/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
    Creation time 02-nov.-2014
 *
 **
 */
/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestAxes extends TestObjetStub {

    @Override
    public void testScene() {
        Plan3D planX = new Plan3D();
        Plan3D planY = new Plan3D();
        Plan3D planZ = new Plan3D();
        planX.pointOrigine(Point3D.O0);
        planX.pointXExtremite(Point3D.X);
        planX.pointYExtremite(Point3D.Y.mult(0.3));
        planX.texture(new TColor(Color.RED));
        planY.pointOrigine(Point3D.O0);
        planY.pointXExtremite(Point3D.Y);
        planY.pointYExtremite(Point3D.Z.mult(0.3));
        planY.texture(new TColor(Color.GREEN));
        planZ.pointOrigine(Point3D.O0);
        planZ.pointXExtremite(Point3D.Z);
        planZ.pointYExtremite(Point3D.X.mult(0.3));
        planZ.texture(new TColor(Color.BLUE));
        scene().add(planX);
        scene().add(planY);
        scene().add(planZ);
        Camera camera = new Camera();
        camera.setCamera(Point3D.Z.mult(-1));
        if(frame()%2==0)
        {
        camera.imposerMatrice(new Matrix33(
                new double[]
                {
                    1,0,0,
                    0,1,0,
                    0,0,1
                }
                ));
        }
        camera.calculerMatrice();
        scene().cameraActive(camera);
    }
    
    public static void main(String [] args)
    {
        TestAxes testAxes = new TestAxes();
        testAxes.loop(true);
        testAxes.setMaxFrames(2);
        new Thread(testAxes).start();
        
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ginit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
