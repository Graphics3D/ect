
import SPhere.TestSphere.Trajectoires;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.Plan3D;
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
public class TestAxesAnim extends TestObjet {
    private Camera camera;

    @Override
    public void ginit() {
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
        camera = new Camera();
        scene().cameraActive(camera);
    }

    public void testScene()
    {
        double pc = 1.0*frame()/getMaxFrames();
        camera.setCamera(Trajectoires.sphere(
                pc, 
                Math.sqrt(getMaxFrames())*pc,
                1.0));
        camera.calculerMatrice();
    }
    
    
    public static void main(String [] args)
    {
        TestAxes testAxes = new TestAxes();
        testAxes.loop(true);
        testAxes.setMaxFrames(100);
        new Thread(testAxes).start();
        
    }
}
