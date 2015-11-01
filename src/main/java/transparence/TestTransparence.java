/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package transparence;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.Plan3D;
import java.awt.Color;
import javax.imageio.ImageIO;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestTransparence extends TestObjetSub
{

    @Override
    public void testScene() throws Exception {
        Plan3D plan3D = new Plan3D();
        plan3D.pointOrigine(new Point3D(-1,-1,0));
        plan3D.pointXExtremite(new Point3D(1,0,0));
        plan3D.pointYExtremite(new Point3D(0,1,0));
        TColor tColor = new TColor(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("cubes-transparence.png"))));
        tColor.setTransparent(Color.WHITE);
        plan3D.texture(tColor);
        
        scene().add(plan3D);
        scene().cameraActive(new Camera(Point3D.Z.mult(3), Point3D.O0));
       
    }
    
    
     public static void main(String [] ar)
    {
        TestTransparence tth = new TestTransparence();
        
        tth.loop(false);
        tth.setResx(2000);
        tth.setResy(1500);
        
        new Thread(tth).start();
    }
}
