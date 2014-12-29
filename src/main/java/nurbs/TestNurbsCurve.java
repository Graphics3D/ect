/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package nurbs;

import info.emptycanvas.library.nurbs.NurbsCurve;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.SegmentDroite;
import info.emptycanvas.library.testing.TestObjet;
import java.awt.Color;
import java.util.AbstractMap;
import java.util.Arrays;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
class TestNurbsCurve extends TestObjet
{
  @Override
  public void testScene() throws Exception {
      loop(false);
      
      NurbsCurve c = new NurbsCurve();
      c.getKnots().addAll(
              Arrays.asList(
              new Double[] 
                  {
                  0.0,0.0,0.0,Math.PI/2, Math.PI/2, Math.PI, Math.PI,  3*Math.PI/2, 3*Math.PI/2, 2*Math.PI, 2*Math.PI, 2*Math.PI
                  }
              )
         );
      c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(1,0,0), 1.0));
      c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(1,1,0), Math.sqrt(2)/2));
      c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(0,1,0), 1.0));
      c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(-1,1,0), Math.sqrt(2)/2));
      c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(-1,0,0), 1.0));
      c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(-1,-1,0), Math.sqrt(2)/2));
      c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(0,-1,0), 1.0));
      c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(1,-1,0), Math.sqrt(2)/2));
      c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(1,0,0), 1.0));
      
      
      scene().add(c);
      
      System.out.print(c);
      
      scene().cameraActive().setCamera(Point3D.Z.mult(-5));
      
      
      scene().add(new SegmentDroite(Point3D.O0, Point3D.X, new ColorTexture(Color.RED)));
      scene().add(new SegmentDroite(Point3D.O0, Point3D.Y, new ColorTexture(Color.GREEN)));
      scene().add(new SegmentDroite(Point3D.O0, Point3D.Z, new ColorTexture(Color.BLUE)));
  }
  
    public static void main(String [] args)
    {
        System.err.println("Circle");
        TestObjet t;

        t = new TestNurbsCurve();
        t.setResx(320);
        t.setResy(240);
        t.loop(false);
        new Thread(t).start();
 
    }
}

