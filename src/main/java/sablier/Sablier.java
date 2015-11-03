package sablier;

import info.emptycanvas.library.nurbs.ParametrizedSurface;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;

import java.awt.*;

/**
 * Created by manue on 01-11-15.
 */

public class Sablier extends ParametrizedSurface{

    protected double NFAST = 100;
    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D p = new Point3D(Math.cos(Math.PI*2*u)*Math.sin(Math.PI/2+Math.PI*u), v, Math.sin(Math.PI*2*u)*Math.cos(Math.PI*2*u)*Math.sin(Math.PI/2+Math.PI*u));
        p.texture(this.texture());
        return p;
    }

    @Override
    public Point3D calculerVitesse3D(double v, double v1) {
        return null;
    }

}
