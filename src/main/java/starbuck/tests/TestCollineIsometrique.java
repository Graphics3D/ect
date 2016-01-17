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
import info.emptycanvas.library.testing.TestObjetSub;

/**
 *
 * @author Atelier
 */
public class TestCollineIsometrique extends TestObjetSub {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            TestCollineIsometrique to = new TestCollineIsometrique();
            to.isometrique(true);
            to.publishResult(true);
            to.setFilename("image_" + i);
            to.run();
            
            to = null;
            System.gc();
        }
    }

    @Override
    public void testScene() {
        scene().add(new CollineModele1(40));
    }
}
