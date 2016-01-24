package ver;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.TubulaireN;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Se7en
 */
public class Serpentins2 extends TestObjetSub {

    public int MAXFRAMES = 2000;
    public int Ns = 4;
    public int N = 7;
    public int Ncolors = 6;
    private Point3D[][] s = new Point3D[Ns][N];
    private Point3D[][] v = new Point3D[Ns][N];
    private double V = 0.08;
    private double D = 1.0;
    private double TUBE_RAYON = 0.1;
    private HashMap<Point2D, Color> map = new HashMap<Point2D, Color>();
    private TubulaireN[] tubulaireN = new TubulaireN[Ns];
    private ITexture itext[] = new ITexture[Ns];

    public static void main(String[] args) {
        Serpentins2 th = new Serpentins2();

        th.loop(true);

        th.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        th.run();
    }

    @Override
    public void ginit() {
        for (int i = 0; i < Ns; i++) {
            try {
                itext[i] = new ImageTexture(ECBufferedImage.getFromFile(new File("c:\\Emptycanvas\\textures\\photo" + (i + 1) + ".jpg")));
            } catch (IOException ex) {
                itext[i] = new ColorTexture(Color.BLUE);
            }
        }
        LumierePonctuelle lumierePonctuelle = new LumierePonctuelle(Point3D.X, Color.RED);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);

        lumierePonctuelle = new LumierePonctuelle(Point3D.Y, Color.GREEN);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);

        s = new Point3D[Ns][N];
        v = new Point3D[Ns][N];
        for (int j = 0; j < Ns; j++) {
            for (int i = 0; i < N; i++) {

                s[j][i] = rand(-D, D);

                v[j][i] = rand(-V, V);

            }
        }
        scene().lumieres().add(new LumierePonctuelle(Point3D.O0, Color.WHITE));

        Camera camera;
        camera = new Camera(new Point3D(0d, 0d, -3d),
                new Point3D(0d, 0d, 0d));

        scene().cameraActive(camera);

    }

    public Point3D rand(double limitMinus, double limitPlus) {
        double[] d = new double[3];
        for (int i = 0; i < 3; i++) {
            d[i] = (limitPlus - limitMinus) * Math.random() + limitMinus;
        }
        return new Point3D(d, null);
    }

    public void bounce(int i, int j) {
        s[i][j] = s[i][j].plus(v[i][j]);

        if (s[i][j].getX() > D && v[i][j].getX() > 0) {
            v[i][j].setX(-v[i][j].getX());
        }
        if (s[i][j].getX() < -D && v[i][j].getX() < 0) {
            v[i][j].setX(-v[i][j].getX());
        }
        if (s[i][j].getY() > D && v[i][j].getY() > 0) {
            v[i][j].setY(-v[i][j].getY());
        }
        if (s[i][j].getY() < -D && v[i][j].getY() < 0) {
            v[i][j].setY(-v[i][j].getY());
        }
        if (s[i][j].getZ() > D && v[i][j].getZ() > 0) {
            v[i][j].setZ(-v[i][j].getZ());
        }
        if (s[i][j].getZ() < -D && v[i][j].getZ() < 0) {
            v[i][j].setZ(-v[i][j].getZ());
        }
    }

    @Override
    public void testScene() throws Exception {
        for (TubulaireN ti : tubulaireN)
            scene().remove(ti);

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                bounce(i, j);
            }
        }
        for (int i = 0; i < Ns; i++) {
            tubulaireN[i] = new TubulaireN();
            tubulaireN[i].diam((float) TUBE_RAYON);
            tubulaireN[i].texture(itext[i]);
            tubulaireN[i].nbrAnneaux(40);
            tubulaireN[i].nbrRotations(30);
            scene().add(tubulaireN[i]);
        }

        int i = 0;
        for (Point3D[] pp : s) {
            for (Point3D p : pp) {
                tubulaireN[i].addPoint(p);
            }
            i++;
        }

    }

    private Matrix33 matrix1(double a, double b) {
        return Matrix33.rot(a, b);
    }

    @Override
    public void finit() {

    }
}
