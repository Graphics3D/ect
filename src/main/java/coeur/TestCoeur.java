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
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestCoeur extends TestObjetSub
{
private Coeur coeur;
    @Override
    public void ginit() {
        coeur = new Coeur();
    try {
        coeur.texture(new TColor(new ECBufferedImage( ImageIO.read(getClass().getResourceAsStream("moi1.jpg")))));
    } catch (IOException ex) {
        coeur.texture(new TColor(Color.PINK));
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

    public static void main(String [] args)
    {
        TestCoeur tc = new TestCoeur();
        tc.setGenerate(GENERATE_IMAGE|GENERATE_MOVIE|GENERATE_MODEL);
        tc.loop(true);
        tc.setMaxFrames(400);
        
        new Thread(tc).start();
    }

    @Override
    public void finit() {
    }
    
}
