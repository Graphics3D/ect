package balleclou;

import info.emptycanvas.library.extra.BalleClous;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import java.awt.Color;

/**
 *
 * @author Se7en
 */
public class TestBalleClous11 extends TestObjetSub {

    public int MAXFRAMES = 2000;
    private ColorTexture tc = new ColorTexture(Color.red);
    private BalleClous ballec;
    private Point3D[] s;
    public int N = 2;
    private Point3D[] v;
    private double V = 0.03;
    private double D = 1;

    @Override
    public void ginit() {
        LumierePonctuelle lumierePonctuelle = new LumierePonctuelle(Point3D.X, Color.RED);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);

        lumierePonctuelle = new LumierePonctuelle(Point3D.Y, Color.BLUE);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);

        s = new Point3D[N];
        v = new Point3D[N];
        for (int i = 0; i < N; i++) {
            s[i] = new Point3D(Point3D.O0);

            s[i].texture(new TColor(Color.GREEN));

            v[i] = new Point3D(Math.random() * (V / 2 - V), Math.random() * (V / 2 - V), Math.random() * (V / 2 - V));

        }
        tc
                = new ColorTexture(
                        Color.YELLOW);

        ballec = new BalleClous(Point3D.O0, 50);

        ballec.param(0.03);

        tc
                = new ColorTexture(
                        Color.PINK);

        ballec.texture(tc);

        scene().add(ballec);

        Camera camera;
        camera = new Camera(new Point3D(0d, 0d, -1700d),
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
        for (int i = 0; i < s.length; i++) {
            bounce(i);
        }

        ballec.points().clear();
        double totalA = 0;
        double totalB = 0;

        for (Point3D item : s) {
            if (item.getX() < 0) {
                item.setX(item.getX() + D);
            }
            if (item.getY() < 0) {
                item.setY(item.getY() + D);
            }
            if (item.getX() > D) {
                item.setX(item.getX() - D);
            }
            if (item.getY() > D) {
                item.setY(item.getY() - D);
            }
            totalA += item.getX();
            totalB += item.getY();
            ballec.addPoint(new Point2D(item.getX(), item.getY()));
            ballec.position().rotation = ballec.position().rotation.mult(matrix1(totalA, totalB));
        }

    }

    public static void main(String[] args) {
        TestBalleClous11 th = new TestBalleClous11();

        th.loop(true);
        th.MAXFRAMES = 4000;

        th.setGenerate(TestBalleClous11.GENERATE_IMAGE);

        th.run();
    }

    private Matrix33 matrix1(double a, double b) {
        return Matrix33.rot(a, b);
    }
}
