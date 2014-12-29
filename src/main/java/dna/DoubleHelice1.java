/**
 * *
 * Global license : * Microsoft Public Licence
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 **
 */
package dna;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRIObjetGenerateurAbstract;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class DoubleHelice1 extends TRIObjetGenerateurAbstract {
    double h;
    private double [] p = new double[] { 4,4,4};
    //private int n = 2;
    private double [] r = new double [] {100,100,100};
    private double angle = 0;

    public DoubleHelice1(double [] r, double h, double [] p, double angle) {
        this.r = r;
        this.h = h;
        //this.n = r.length;
        this.p  = p;
        this.angle = angle;
    }

    private Matrix33 rotmat(double a) {
        return new Matrix33(
                new double[]{
            Math.cos(a+angle/360*2*Math.PI), 0, 0,
            0, Math.sin(a+angle/360*2*Math.PI), 0,
            0, 0, 1
        });
    }

    public Point3D p(int x, int y) {

        Point3D ret = Point3D.O0;
        
        double prog = 1.0 * (y*getMaxX()+x)/getMaxX()/getMaxY()*p[0]*p[1];
            
        return ret.plus(
                    rotmat(2 * Math.PI * prog)
                    .mult(new Point3D(r[0], r[0], h * prog)))
                 .plus(
                    rotmat(2 * Math.PI * prog)
                    .mult(new Point3D(r[1], r[1], h * prog)));
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {

        Point3D ppB = p(x, y);

        return ppB;
    }
}
