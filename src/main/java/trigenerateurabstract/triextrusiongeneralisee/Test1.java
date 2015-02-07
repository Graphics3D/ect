/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <manuel.dahmen@gmail.com>

***/


package trigenerateurabstract.triextrusiongeneralisee;

import info.emptycanvas.library.object.BezierCubique;
import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.CheminBezier;
import info.emptycanvas.library.tribase.SurfaceCercle;
import info.emptycanvas.library.tribase.TRIExtrusionGeneralisee;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class Test1 extends TestObjet
{
    private TRIExtrusionGeneralisee eg; 
    @Override
    public void ginit() {
        eg = new TRIExtrusionGeneralisee();
        BezierCubique bezierCubique = new BezierCubique();
        bezierCubique.add(Point3D.O0);
        bezierCubique.add(Point3D.X);
        bezierCubique.add(Point3D.X.plus(Point3D.Y));
        bezierCubique.add(Point3D.Y);
        
        CheminBezier cheminBezier = new CheminBezier(bezierCubique);
        eg.setChemin(cheminBezier);
        
        eg.setSurface(new SurfaceCercle(0.4));
        
        eg.texture(new ColorTexture(Color.WHITE));
        
        this.description = "Tore 1 0.4";
    }

    @Override
    public void testScene() throws Exception {
        scene().add(eg);
        
        scene().cameraActive(new Camera(Point3D.Z, Point3D.O0));
    }
    public static void main(String[] args) {
        Test1 tp = new Test1();
        tp.setGenerate(GENERATE_IMAGE|GENERATE_MODEL);
        tp.loop(false);
        new Thread(tp).start();
    }
}
