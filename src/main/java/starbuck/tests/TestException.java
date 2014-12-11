package starbuck.tests;

import info.emptycanvas.library.testing.TestObjet;

public class TestException extends TestObjet {
	public void testScene() throws Exception
	{
			throw new Exception("Erreur : message :; test");
	}
	
	public static void main(String [] args)
	{
		TestException te = new TestException();
		
		te.loop(false);
		
		te.publishResult(true);
		
		te.run();
		
		
	}
}
