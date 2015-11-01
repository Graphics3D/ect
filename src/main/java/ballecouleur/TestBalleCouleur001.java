package ballecouleur;

import balleclou.*;
import info.emptycanvas.library.gdximports.gdx_BSplineCurve;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.TubulaireN;
import info.emptycanvas.library.tribase.TubulaireN2;
import java.awt.Color;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author Se7en
 */
public class TestBalleCouleur001 extends TestObjetSub {

    public int MAXFRAMES = 2000;
    private BalleClous2 ballec;
    private Point3D[] s;
    public int N = 7;
    public int Ncolors = 6;
    private Point3D[] v;
    private double V = 0.08;
    private double D = 1.0;
    private double ballecparam = 0.02;
    private double TUBE_RAYON = 0.02;
    private HashMap<Point2D, Color> map = new HashMap<Point2D, Color>();

    @Override
    public void ginit() {
        LumierePonctuelle lumierePonctuelle = new LumierePonctuelle(Point3D.X, Color.RED);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);

        lumierePonctuelle = new LumierePonctuelle(Point3D.Y, Color.BLUE);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);
        for (int c = 0; c < Ncolors; c++) {
            map.put(new Point2D(Math.random() * 100, Math.random() * 100), new Color((float) Math.random(), (float) Math.random(), (float) Math.random(), (float) Math.random()));
        }

        s = new Point3D[N];
        v = new Point3D[N];
        for (int i = 0; i < N; i++) {

            s[i] = new Point3D(Point3D.O0);

            v[i] = new Point3D(Math.random() * (V / 2 - V), Math.random() * (V / 2 - V), Math.random() * (V / 2 - V));

        }
        

        ballec = new BalleClous2(Point3D.O0, 1);

        ballec.setMaxX(100);
        ballec.setMaxY(100);
        
        ballec.param(ballecparam);
        
        
        ballec.texture(new ColorTexture(Color.GRAY));

        scene().add(ballec);

        scene().lumieres().add(new LumierePonctuelle(Point3D.O0, Color.WHITE));

        Camera camera;
        camera = new Camera(new Point3D(0d, 0d, -2d),
                new Point3D(0d, 0d, 0d));

        scene().cameraActive(camera);

    }

    public void bounce(int i) {
        s[i] = s[i].plus(v[i]);

        if (s[i].getX() > D && v[i].getX() > 0) {
            v[i].setX(-v[i].getX());
        }
        if (s[i].getX() < -D && v[i].getX() < 0) {
            v[i].setX(-v[i].getX());
        }
        if (s[i].getY() > D && v[i].getY() > 0) {
            v[i].setY(-v[i].getY());
        }
        if (s[i].getY() < -D && v[i].getY() < 0) {
            v[i].setY(-v[i].getY());
        }
        if (s[i].getZ() > D && v[i].getZ() > 0) {
            v[i].setZ(-v[i].getZ());
        }
        if (s[i].getZ() < -D && v[i].getZ() < 0) {
            v[i].setZ(-v[i].getZ());
        }
    }

    @Override
    public void testScene() throws Exception {
  
        scene().clear();
        
        for (int i = 0; i < s.length; i++) {
            bounce(i);
        }

        ballec.points().clear();
        double totalA = 0;
        double totalB = 0;

        for (int j = 0; j < s.length; j++) {
            if (s[j].getX() < 0) {
                s[j].setX(s[j].getX() + D);
            }
            if (s[j].getY() < 0) {
                s[j].setY(s[j].getY() + D);
            }
            if (s[j].getX() > D) {
                s[j].setX(s[j].getX() - D);
            }
            if (s[j].getY() > D) {
                s[j].setY(s[j].getY() - D);
            }

            totalA += s[j].getX();
            totalB += s[j].getY();

            scene().add(s[j]);//?
            
            ballec.addPoint(new Point2D(s[j].getX(), s[j].getY()));

            TubulaireN2<gdx_BSplineCurve> tubulaireN2 = new TubulaireN2<gdx_BSplineCurve>();
            tubulaireN2.diam((float)TUBE_RAYON);
            tubulaireN2.texture(new ImageTexture(new ECBufferedImage(ImageIO.read(new File("C:\\Users\\Se7en\\Pictures\\manu2.jpg")))));
            
            gdx_BSplineCurve gdx_BSplineCurve = new gdx_BSplineCurve();
            
            gdx_BSplineCurve.instantiate(s, 5);
            
            
            tubulaireN2.curve(gdx_BSplineCurve);
            
            scene().add(tubulaireN2);
            
//ballec.position().rotation = ballec.position().rotation.mult(matrix1(totalA, totalB));

        }

    }

    public static void main(String[] args) {
        TestBalleCouleur001 th = new TestBalleCouleur001();

        th.loop(true);

        
        th.setGenerate(GENERATE_IMAGE|GENERATE_MOVIE);

        th.run();
    }

    private Matrix33 matrix1(double a, double b) {
        return Matrix33.rot(a, b);
    }

    @Override
    public void finit() {

    }
}
