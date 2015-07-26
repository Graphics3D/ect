/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repereAssocieAUneCourbeEX;

import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.tribase.TRIObjetGenerateurAbstract;

/**
 *
 * @author manue_001
 */
public class TRITRINuage extends TRIObjetGenerateurAbstract {
    private final double dx;
    private final double dz;
    private final double densite;
    private final double dy;
    private final double taille;
    private Point3D[] p;
    
    public TRITRINuage(double dx, double dy, double dz, double densite, double taille) {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
        this.densite = densite;
        this.taille = taille;
        
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        double cx = 1.0*x/getMaxX();
        double cy = 1.0*y/getMaxY();
        
        if(p==null)
            p = new Point3D[getMaxX()*getMaxY()];
        
        if(p[y*getMaxX()+x]==null)
            p[y*getMaxX()+x] = new Point3D (Math.random()*dx,Math.random()*dy,Math.random()*dz);
        return p[y*getMaxX()+x];
    }
    
    
    
    
    public static void main(String[] args) {
        
    }
    
    
}
