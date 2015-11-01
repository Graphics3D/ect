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
import info.emptycanvas.library.testing.TestObjetSub;

/**
 *
 * @author Atelier
 */
public class TestCollineIsometriqueStructure extends TestObjetSub {

    public static void main(String[] args) {
            TestCollineIsometriqueStructure to = new TestCollineIsometriqueStructure();
            to.setResx(640);
            to.setResy(480);
            to.isometrique(true);
            to.publishResult(false);
            to.setStructure(true);
            to.loop(true);
            to.setMaxFrames(100);

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
