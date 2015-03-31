/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

    Creation time 25-oct.-2014

***/


package couer;
import info.emptycanvas.library.nurbs.ParametrizedSurface;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.tribase.TRIObjetGenerateurAbstract;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class Coeur1 extends ParametrizedSurface{
    private double a;
    private double b;
    private double c;

    public Coeur1(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public Point3D calculerPoint3D(double u, double v) {
        double denom = (Math.pow(Math.sin(2*Math.PI*v), 2)+c*c*Math.pow(Math.cos(2*Math.PI*v), 2)*(Math.pow(Math.cos(2*Math.PI*u), 2) / a/a + Math.pow(Math.sin(2*Math.PI*u), 2)/b/b));
        double x,y,z;
        x = c*c/a*Math.cos(2*Math.PI*u)*Math.cos(2*Math.PI*v)/denom;
        y= c*c/b*Math.sin(2*Math.PI*u)*Math.cos(2*Math.PI*v)/denom;
        z = c*c/a*Math.sin(2*Math.PI*v)/denom;
        return new Point3D(x,y,z);
    }

    @Override
    public Point3D calculerVitesse3D(double u, double v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
