package demo.jmockit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mockit.Mocked;

public class TestSubClass {

	
	private SubClass subClass;
	
	@Test
	public void testMockedAnnotation(@Mocked SuperClass superClass) {
		subClass = new SubClass("Sample data");
		assertEquals("Sample data", subClass.getInput());
	}
}
