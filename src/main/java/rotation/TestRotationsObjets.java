/***
 * Global license :
 * <p>
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 ***/


package rotation;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.testing.TestObjetSub;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * cette classe produit une image de sphère avec "Manuel Dahmen" écrit dessus. La sphère tourne
 * puis s'en va et revient à l'écran.
 *
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestRotationsObjets extends TestObjetSub {
    double distance = 100;
    double dim = 100;
    int maxx = 100;
    int maxy = 100;
    ImageTexture imageTexture;
    private double globalTimeMillis = 1000;
    private String label;

    public TestRotationsObjets(double globalTimeMillis) {
        this.globalTimeMillis = globalTimeMillis;

        try {
            imageTexture = new ImageTexture(new ECBufferedImage(ImageIO.read(this.getClass().getResourceAsStream("map2.png"))));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.print("Fichier non trouvé : texture. Choisir une autre texture ou retrouveer le fichier\nOu rrecompiler si fichier ressource");
            System.exit(-1);
        }
        imageTexture.setColorMask(ITexture.COLOR_MIROR_XY);

    }

    public static void main(String[] args) {

        int globalTS = 100000;
        TestRotationsObjets ts = new TestRotationsObjets(globalTS);


        // Seules images et films dans un premier temps
        ts.setGenerate(TestObjet.GENERATE_IMAGE | GENERATE_MOVIE);

        ts.loop(true);

        ts.setMaxFrames(globalTS * 250 / 100000);

        new Thread(ts).start();
    }

    /***
     * On laisse la caméra toujours à la même place dans ce test, et on fait tourner les objets
     */
    @Override
    public void ginit() {
        scene().cameraActive(new Camera(Point3D.Z.mult(-distance), Point3D.O0));


    }

    @Override
    public void testScene() throws Exception {
        scene().clear();

        int nObjets = 1;
        int nFramesParObjet = getMaxFrames() / nObjets;

        int objetCourant = frame() / nFramesParObjet / nObjets;

        int frameDansLaPartie = frame() / nObjets % nFramesParObjet;

        double pourcentage = frameDansLaPartie / (double) nFramesParObjet;

        Representable representable = new SegmentDroite(Point3D.Y.mult(-dim), Point3D.Y.mult(dim), new ColorTexture(Color.BLACK));

        scene().add(representable);


        double angle = 2 * Math.PI / 3600 * pourcentage;

        label = "Rotation autour de l'axe des X de " + angle + " radians";

        System.out.println(label);

        // Rotation autour de l'axe des X
        representable.setRotation(representable.new Rotation(Matrix33.rotationX(angle), Point3D.O0));
    }

    @Override
    public void finit() {
    }

    @Override
    public void afterRenderFrame() {
    }
}
