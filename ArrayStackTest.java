package inlämningsuppgift4;

import static org.junit.Assert.*;

import org.junit.Test;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ArrayStackTest {
	ArrayStack<Integer> test = new ArrayStack<Integer>();
	
	@Before
	public void setup() {
		ArrayStack<Integer> test = new ArrayStack<Integer>();
		
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		test.push(6);
		test.push(1);
		test.pop();
	}

	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		ArrayStack<Integer> bam = test.copy();
		
		while ( !test.isEmpty() && !bam.isEmpty() )
		{
			assertTrue("The copy is  the same as the original.",bam.pop() == test.pop());
				
			
		
			
		}
		
	}

}
