package neurone;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;

/**
 *
 * @author Se7en
 */
public class NeuronePoint extends Neurone{
    public static double dmax = -1.0;
    
    @Override
    public double fonction(Neurone source) {
        if(this.objet instanceof Point3D &&
                source.objet instanceof Point3D)
        {
            double dist = Point3D.distance(((Point3D)(source.objet)),
                            ((Point3D)(this.objet)));
                    if(dist>dmax)
                        dmax = dist;
                    
               
            objet = ((Point3D)(this.objet))
                    .prodVect(((Point3D)(source.objet))).mult(poids);
            
            poids = 1.0/(dist+1);
        
                
        }
        
        
        return 0;
    }
    
}
