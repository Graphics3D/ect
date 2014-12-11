/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 **
 */
package dna;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class DoubleHelice extends TestObjet {

    double r1;
    double r2;
    double r3;
    double h;
    double p;
    int max;
    private RepresentableConteneur ps;
    private double p1;
    private double p2;
    private double p3;
    private int n;
    private int nf;

    private DoubleHelice(double r1, int max) {
        this.r1 = r1;
        this.max = max;
        this.p1 = 1;
        
    }
    public DoubleHelice(double r1, double r2, double r3, double h, double p, int max) {
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.h = h;
        this.p1 = p;
        this.p2 = p1*4;
        this.p3 = p2*4;
        this.max = max;
    }

    private Matrix33 rotmat(double a) {
        return new Matrix33(
                new double[]{
            Math.cos(a), 0, 0,
            0, Math.sin(a), 0,
            0, 0, 1
        });
    }


    public Point3D p(int i, int max) {

        double prog = 1.0 * i / max + 1.0 * frame() / getMaxFrames();
/*
        Point3D ret =  new Point3D(0, 0, prog * h).plus(
                rotmat(2 * Math.PI * prog * p1)
                .mult(new Point3D(r1, r1, h * prog))
                .plus(
                rotmat(2 * Math.PI * prog * p2)
                .mult(new Point3D(r2, r2, h * prog))).plus(
                rotmat(2 * Math.PI * prog * p3)
                .mult(new Point3D(r3, r3, h * prog))));
*/
        Point3D ret =  new Point3D(0, 0, prog * h);
        int nPlus = 1;
        for(int j = 0; j<n ;  j++)
        {
        ret =  ret.plus(
                rotmat(2 * Math.PI * prog * nPlus)
                .mult(new Point3D(r1, r1, h * prog)));
        nPlus = nPlus*nf;
}
        ret.setZ(0);

        return ret;
    }

    @Override
    public void finit() {
        n = frame();

        scene().clear();
        ps = new RepresentableConteneur();
        scene().add(ps);

        camera(new Camera(Point3D.X.mult(r1*n), Point3D.O0));
    }

    @Override
    public void testScene() throws Exception {

        
        Point3D ppA = p(0, max);
        for (int i = 1; i < max; i++) {
            Color c = new Color((float)(1.0*i/max),(float)(1.0*i/max),(float)(1.0*i/max));
            
            Point3D ppB = p(i, max);
            ps.add(new SegmentDroite(ppA, ppB, c));
            
            ppA = ppB;
        }


    }

    
    
    public static void main(String[] args) {

        DoubleHelice dh = new DoubleHelice(30, 10000);

        dh.nf = 6;
        
        dh.setMaxFrames(10);
        
        dh.loop(true);

        dh.setResx(2000);
        dh.setResy(2000);
        
        new Thread(dh).start();

    }
}
