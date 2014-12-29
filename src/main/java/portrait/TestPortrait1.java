/**
 * *
 * Global license : * Microsoft Public Licence
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 **
 */
package portrait;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRISphere;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestPortrait1 extends TestObjet {

    @Override
    public void testScene() throws Exception {

        for(int i=-2; i<=2; i++)
        for(int j=-2; j<=2; j++)
        {
            Cube c1 = new Cube(1.0, new Point3D(i*2, 0.5, j*2), new ColorTexture(Color.white));
            scene().add(c1);
        }
        
        TRISphere ts = new TRISphere(new Point3D(0,1.5,0), 2);
        
        ts.texture(new TColor(Color.WHITE));
        
        scene().add(ts);

        Camera c = new Camera(new Point3D(0, 3, -20), Point3D.O0);


        scene().cameraActive(c);
        scene().lumieres()
                .add(
                    new LumierePonctuelle(new Point3D(0,20,20), Color.orange));
        scene().lumieres()
                .add(
                    new LumierePonctuelle(new Point3D(20,20,20), Color.magenta));
    }

    public static void main(String[] args) {
        TestPortrait1 tp = new TestPortrait1();
        tp.loop(false);
        tp.setResx(1600);
        tp.setResy(1200);
        tp.run();
    }
}
