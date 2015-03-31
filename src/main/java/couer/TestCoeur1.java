/**
 * *
 * Global license : * Microsoft Public Licence
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 * Creation time 25-oct.-2014 SURFACE D'ÉLASTICITÉ DE FRESNEL Fresnel's
 * elasticity surface, Fresnelsche Elastizitätfläche
 * http://www.mathcurve.com/surfaces/elasticite/elasticite.shtml *
 */
package couer;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestCoeur1 extends TestObjet {

    private Coeur1 coeur;

    @Override
    public void ginit() {
        coeur = new Coeur1(5, 3, 1);
        try {
            coeur.texture(new ImageTexture(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("moi1.jpg")))));
        } catch (IOException ex) {
            coeur.texture(new ColorTexture(Color.PINK));
            Logger.getLogger(TestCoeur1.class.getName()).log(Level.SEVERE, null, ex);
        }

        coeur.setMaxX(100);
        coeur.setMaxY(100);

        scene().add(coeur);

        scene().cameraActive(new Camera(Point3D.Z.mult(-10), Point3D.O0));

    }

    @Override
    public void testScene() throws Exception {

    }

    public static void main(String[] args) {
        TestCoeur1 tc = new TestCoeur1();

        tc.loop(false);
        tc.setMaxFrames(400);
        tc.setGenerate(GENERATE_MODEL|GENERATE_IMAGE);
        new Thread(tc).start();
    }

    @Override
    public void finit() {

    }

    @Override
    public void afterRenderFrame() {

        coeur.drawStructureDrawFast(getZ());

    }

    public void afterRender() {

    }

}
