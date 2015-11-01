package starbuck.tests;

import info.emptycanvas.library.testing.TestObjetSub;

public class TestException extends TestObjetSub {
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
