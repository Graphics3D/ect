/**
 * *
 * Global license : * CC Attribution
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 **
 */
package feudartifice;

import SPhere.TestSphere.Trajectoires;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.ITexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.Representable;
import info.emptycanvas.library.object.RepresentableConteneur;
import info.emptycanvas.library.object.SegmentDroite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class FeuArbre {

    Noeud racine;
    public int NUM = 10;
    public int PROF = 5;

    public FeuArbre() {
        racine = new Noeud();
        racine.setLocation(Point3D.O0);

    }

    public class Noeud extends ArrayList<Noeud> {

        private Point3D loc;

        public void setLocation(Point3D p) {
            loc = p;
        }

        public Point3D getLocation() {
            return loc;
        }

        public void addBranches(int n) {
            for (int i = 0; i < n; i++) {
                Point3D sphere = Trajectoires.sphere(Math.random(), Math.random(), 4);
                Noeud noeud = new Noeud();
                noeud.setLocation(getLocation().plus(sphere));
                add(noeud);

            }
        }
    }
    private int prof = 0;

    public RepresentableConteneur generate() {
        RepresentableConteneur rc = new RepresentableConteneur();

        generate(racine, rc);

        return rc;
    }

    public void generate(final Noeud n, final RepresentableConteneur rc) {
        ITexture color;
        color = new ColorTexture(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));
        n.addBranches((int) (Math.random() * NUM));
        Iterator<Noeud> iterator = n.iterator();
        while (iterator.hasNext()) {
            Noeud no = iterator.next();
            prof++;
            if (prof < PROF) {
                rc.add(new SegmentDroite(n.getLocation(), no.getLocation(), color));
                generate(no, rc);
            }
            prof--;
        }

    }

}
