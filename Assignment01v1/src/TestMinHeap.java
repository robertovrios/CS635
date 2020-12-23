
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestMinHeap {
	
	

	MinHeap testee = new MinHeap();
	
	MinHeap testee1 = new MinHeap();
	
	MinHeap testee2 = new MinHeap();

	
	@Before
    public void init()
    {
	
		testee.insertNode(45);
		testee.insertNode(65);
		testee.insertNode(72);
		testee.insertNode(90);
		testee.insertNode(81);
		testee.insertNode(82);
		testee.insertNode(96);
		testee.insertNode(99);
		testee.insertNode(95);
		testee.insertNode(50);

		

		List<Integer> values1 = Arrays.asList(45,65,72,90,81,82,96,99,95,50);
		testee1.insertCollection(values1);
		
		List<Integer> values2 = Arrays.asList(45,65,72,90,81,82,96,99,95,50,20,3,12,90);
		testee2.insertCollection(values2);
		
		
    }
   
	@Test
	public void testPostOrderMethod(){
		
		List<Integer> correctAnswer=Arrays.asList(99,95,90,81,65,82,72,96,50,45);
		assertEquals(correctAnswer,testee.postOrder());

	}
	

	
	@Test
	public void testPreOrderOddsMethod(){
		
		List<Integer> correctAnswer=Arrays.asList(45,65,99,95,81);
		assertEquals(correctAnswer,testee.preOrderOddNodes());

	}
	

	@Test
	public void testAddCollection(){
		
	
		List<Integer> correctAnswer=Arrays.asList(99,95,90,81,65,82,72,96,50,45);
		assertEquals(correctAnswer,testee1.postOrder());
		System.out.println("");
	}	
	
	
	@Test
	public void testAddElements(){
		
		List<Integer> correctAnswer=Arrays.asList(99,90,95,90,81,65,20,12,82,72,50,96,45,3);
		

		assertEquals(correctAnswer,testee2.postOrder());
		System.out.println("");
	}

	

	@Test
	public void TestInsertNode(){
		
		
		HeapNode<Integer> node= new HeapNode<Integer>(5);
		node.insert(4);
		node.insert(2);
		List<Integer> correctAnswer=Arrays.asList(5,4,2);
		List<Integer> results= new ArrayList<Integer>();
		
		//List<Integer> results= Arrays.asList(number); 
		assertEquals(correctAnswer,node.postOrderHelper(results));
		System.out.println("");
	}

	
	/*   
		@Test
		public void testEnterStringValues(){
			
			Heap<String> testee3 = new Heap<String>();
			testee2.insertNode("a");
			
			List<String> correctAnswer=Arrays.asList("c","b","a");
			assertEquals(correctAnswer,testee3.postOrder());

		}
		*/
	
	
	
}
