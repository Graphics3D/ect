/**
 * *
 * Global license :  *
 * CC Attribution
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 **
 */
package ballecouleur;

import info.emptycanvas.library.object.Point2D;
import info.emptycanvas.library.object.TColor;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import org.monte.media.color.Colors;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TextureTache extends TColor {

    private final HashMap<Point2D, Color> map;

    public TextureTache(HashMap<Point2D, Color> colors) {
        super(Color.WHITE);
        //this.map = new HashMap<Color, Point2D>();

        map = colors;
    }

    double dist = 0.0;
    Color actu = null;
                float actuA;
                float actuR;
                float actuG;
                float actuB;

    @Override
    public Color getMaillageTRIColor(int numQuadX, int numQuadY, double x, double y, double r11, double r12, int numTRI) {
        final Point2D pData = new Point2D(x, y);
        actu = new Color(0f, 0f, 0f);
        
        final HashMap<Point2D, Double> pond; 
        pond = new HashMap<Point2D, Double>();
        
        map.forEach(new BiConsumer<Point2D, Color>() {

            public void accept(Point2D u, Color t) {
                double dist2 = u.distance(pData);
                
                pond.put(u, dist2);
                
                dist += dist2;
            }
        }
        );
        
        pond.forEach(new BiConsumer<Point2D, Double>(){

            public void accept(Point2D t, Double u) {
                actuA += map.get(t).getAlpha()/256f*u;
                actuR += map.get(t).getRed()/256f*u;
                actuG += map.get(t).getGreen()/256f*u;
                actuB += map.get(t).getBlue()/256f*u;
                
                actu = new Color((float)(actuR/dist), (float)(actuG/dist), (float)(actuB/dist), (float)(actuA/dist));
            }
            
        });
        
        
        return actu;
    }

}
