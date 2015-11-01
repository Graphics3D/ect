package sablier;

import info.emptycanvas.library.nurbs.ParametrizedSurface;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.TRIObjetGenerateurAbstract;
import info.emptycanvas.library.tribase.TRISphere;

/**
 * Created by manue on 01-11-15.
 */

public class Sablier extends ParametrizedSurface{

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        return new Point3D(Math.cos(Math.PI*2*(u-0.5)/2), Math.sin(Math.PI*2*(v-0.5)/2), Math.sin(Math.PI*2*(u-0.5)/2) );
    }

    @Override
    public Point3D calculerVitesse3D(double v, double v1) {
        return null;
    }

}
