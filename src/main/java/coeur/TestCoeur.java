/**
 * *
 * Global license : * GNU GPL v3
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 * Creation time 25-oct.-2014 SURFACE D'ÉLASTICITÉ DE FRESNEL Fresnel's
 * elasticity surface, Fresnelsche Elastizitätfläche
 * http://www.mathcurve.com/surfaces/elasticite/elasticite.shtml *
 */

package coeur;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestCoeur extends TestObjetSub
{
private Coeur coeur;

    public static void main(String[] args) {
        TestCoeur tc = new TestCoeur();
        tc.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE | GENERATE_MODEL);
        tc.loop(true);
        tc.setMaxFrames(400);

        new Thread(tc).start();
    }

    @Override
    public void ginit() {
        coeur = new Coeur();
    try {
        coeur.texture(new ImageTexture(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("coeur.jpg")))));
    } catch (IOException ex) {
        coeur.texture(new ColorTexture(Color.PINK));
        Logger.getLogger(TestCoeur.class.getName()).log(Level.SEVERE, null, ex);
    }

        coeur.setMaxX(200);
        coeur.setMaxY(200);


        scene().cameraActive(new Camera(Point3D.Z.mult(-5), Point3D.O0));

        scene().add(coeur);

    }

    @Override
    public void testScene() throws Exception {
        coeur.param01(1.0*frame/getMaxFrames());


    }

    @Override
    public void finit() {
    }
    
}
