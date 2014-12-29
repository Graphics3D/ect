/*

 Copyright (C) 2010-2013  DAHMEN, Manuel, Daniel

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 2.1 of the License, or (at your option) any later version.

 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA

 */
package starbuck.tests;
import info.emptycanvas.library.extra.CollineModele1;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;

/**
 *
 * @author Atelier
 */
public class TestColline extends TestObjet {
    
    public static void main(String[] args) {
        TestColline to = new TestColline();
        to.setResx(640);
        to.setResy(480);
        to.publishResult(false);
        to.saveBMood(true);
        to.camera(new Camera(new Point3D(0, 0, -50), new Point3D(0, 0, 0)));
        to.setMaxFrames(2000);
        to.loop(true);
        
        
        to.run();
    }
    
    @Override
    public void testScene() {
        scene().clear();
        scene().add(new CollineModele1(40));
        scene().add(new CollineModele1(40));
        scene().add(new CollineModele1(40));
        scene().add(new CollineModele1(40));
        description("Rorschah-like object");
    }
}
