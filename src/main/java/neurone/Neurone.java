package neurone;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;

/**
 *
 * @author Se7en
 */
public abstract class Neurone {
    public double poids = 1;
    public Object objet;
    public abstract double fonction(Neurone source);
    public static double moyenne;
    public static double sortie(Neurone [] neurones)
    {
        int n = 0;
        double total = 0;
        for(int i=0; i<neurones.length; i++)
            for(int j=0; j<i ; j++)
            {
                if(i!=j)
                    total += neurones[i].fonction(neurones[j]);
                
                n++;
                
            }
        
        moyenne = total / n;
        return moyenne;
    }
}
