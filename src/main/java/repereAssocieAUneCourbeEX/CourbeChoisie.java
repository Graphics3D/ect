/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repereAssocieAUneCourbeEX;

import info.emptycanvas.library.nurbs.ParametrizedCurve;
import static info.emptycanvas.library.object.P.n;
import info.emptycanvas.library.object.Point3D;

/**
 *
 * @author Se7en
 */
public class CourbeChoisie extends ParametrizedCurve {
    private final double h;
    private final double L;
    private final double l;
    private final double n;
    /**
     * Dimension de la spire 
     * @param h
     * @param l
     * @param L 
     */
    public CourbeChoisie(double h, double l, double L, double n)
    {
        this.h = h;
        this.l = l;
        this.L = L;
        this.n = n;
    }

    
    
    @Override
    public Point3D calculerPoint3D(double t) {
        return new Point3D(L*Math.cos(2*Math.PI*n*t),l*Math.sin(2*Math.PI*n*t),h*n*t);
    }

    @Override
    public Point3D calculerVitesse3D(double t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
