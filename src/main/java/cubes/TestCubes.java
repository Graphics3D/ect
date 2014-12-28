/*
 * 2013 Manuel Dahmen
 */
package cubes;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Se7en
 */
public class TestCubes extends TestObjet{

    @Override
    public void ginit() {
        super.ginit(); 
        
        scene().add(new Cube(100, 10, Color.GREEN));
        
        
    }
    private double z(double min, double max, int framemin, int nof)
    {
        return min+(max-min)*(1.0*(frame()-framemin)/nof);
    }
    @Override
    public void testScene() {
        scene().cameras().clear();
        
        scene().cameraActive(new Camera(
                new Point3D(0,0,z(-250, 250, 0, getMaxFrames())), 
                new Point3D(0,0,1000)
        ));
    }

    
    public static void main(String [] args)
    {
        TestCubes tc = new TestCubes();
        
        tc.loop(true);
        
        tc.setMaxFrames(1000);
        
        tc.setResx(1600);
        tc.setResy(900);
        
        tc.run();
    }
}
class Cube extends RepresentableConteneur
{
    private ArrayList<Representable> cube = new ArrayList<Representable>();

    public Cube(double dim, int pas, Color c) {
        if(dim<0)
            return;
        for(double i=-dim/2; i<dim/2+pas; i+=pas)
        for(double j=-dim/2; j<dim/2+pas; j+=pas)
        for(double k=-dim/2; k<dim/2+pas; k+=pas)
        {
            if(1.0*i+1.0*dim/pas<dim/2+pas)
            {
            cube.add(new SegmentDroite(
                    new Point3D(1.0*i, 1.0*j, 1.0*k),
                    new Point3D(1.0*i+1.0*dim/pas, 1.0*j, 1.0*k),
                    new ColorTexture(c)
                    )
                    );
            }
            if(1.0*j+1.0*dim/pas<dim/2+pas)
            cube.add(new SegmentDroite(
                    new Point3D(1.0*i, 1.0*j, 1.0*k),
                    new Point3D(1.0*i, 1.0*j+1.0*dim/pas, 1.0*k),
                    new ColorTexture(c)
                    )
                    );
            if(1.0*k+1.0*dim/pas<dim/2+pas)
            cube.add(new SegmentDroite(
                    new Point3D(1.0*i, 1.0*j, 1.0*k),
                    new Point3D(1.0*i, 1.0*j, 1.0*k+1.0*dim/pas),
                    new ColorTexture(c)
                    )
                    );
        }
    }
    
    public void deforme(Point3D p)
    {
        throw new UnsupportedOperationException("Pas encore implémenté");
    }
    @Override
    public List<Representable> getListRepresentable() {
        return cube;
    }
    
}