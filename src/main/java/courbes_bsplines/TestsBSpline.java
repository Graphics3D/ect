/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courbes_bsplines;

import java.awt.Color;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;

/**
 * Test BAD UGLY COMME TA MERE
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestsBSpline {
    public static double [] u (int N)
    {
        double []u = new double[5*N+2];
        int cpt = 0;
        int cpt0 = cpt;
        for(int i=cpt0; i<2*N+1+cpt0; i++)
            
        {
            u[i] = 0;
         
            cpt++;
        }
        cpt0 = cpt;
        for(int i=cpt0; i<N+cpt0; i++)
        {
            u[i] = 1.0 * i / N;
         
            cpt++;
        }
        cpt0 = cpt;
        for(int i=cpt0; i<2*N+1+cpt0; i++)
        {
            u[i] = 1.0 * i / N;
         
            cpt++;
        }
        return u;
    }
    public static Point3D [] p (int N)
    {
        Point3D [] p = new Point3D[N];
        for(int i=0; i<N; i++)
        {
           p[i] = new Point3D (1.0*i*Math.cos((i/6)*(Math.PI*2.0)*((double)i)/N),
           1.0*i*Math.sin((i/6)*(Math.PI*2.0)*((double)i)/N), 0);
           p[i].texture(new ColorTexture(Color.WHITE));
        }
        return p;
    }
}

