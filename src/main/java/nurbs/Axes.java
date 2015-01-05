/***
Global license : 

    CC Attribution
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package nurbs;

import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.RepresentableConteneur;
import info.emptycanvas.library.object.SegmentDroite;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
class Axes extends RepresentableConteneur{
    public Axes(ColorTexture a1, ColorTexture a2, ColorTexture a3)
    {
        add(new SegmentDroite(Point3D.O0, Point3D.X, a1));
        add(new SegmentDroite(Point3D.O0, Point3D.Y, a2));
        add(new SegmentDroite(Point3D.O0, Point3D.Z, a3));
        
    }
    public Axes()
    {
        this(new ColorTexture(Color.RED), new ColorTexture(Color.GREEN), new ColorTexture(Color.BLUE));
    }
}
