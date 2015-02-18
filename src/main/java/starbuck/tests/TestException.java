package starbuck.tests;

import info.emptycanvas.library.testing.TestObjetStub;

public class TestException extends TestObjetStub {
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
