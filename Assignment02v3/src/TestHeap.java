
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

public class TestHeap {

	// create 2 objects for both strategies
	MinHeapStrategy<Integer> minHeapStrategy = new MinHeapStrategy<Integer>();
	MaxHeapStrategy<Integer> maxHeapStrategy = new MaxHeapStrategy<Integer>();

	// create 4 objects using the objects above
	Heap<Integer> testMinHeap = new Heap<Integer>(minHeapStrategy);;
	Heap<Integer> testMinHeapMoreElements = new Heap<Integer>(minHeapStrategy);;
	Heap<Integer> testMaxHeap = new Heap<Integer>(maxHeapStrategy);;
	Heap<Integer> testMaxHeapMoreElements = new Heap<Integer>(maxHeapStrategy);;


	@Before
	public void setup() {

		// testing the addAll method in the heap
		List<Integer> testValues = Arrays.asList(45, 65, 72, 90, 81, 82, 96, 99, 95, 50);
		testMinHeap.addAll(testValues);
		testMaxHeap.addAll(testValues);

		List<Integer> testValuesMoreElements = Arrays.asList(45, 65, 72, 90, 81, 82, 96, 99, 95, 50, 20, 3, 1, 90);
		testMinHeapMoreElements.addAll(testValuesMoreElements);
		testMaxHeapMoreElements.addAll(testValuesMoreElements);

	}
	
	@Test
	public void testAddMethod() {
		testMinHeap.add(5);
		String correctAnswer = "[99,90,95,65,81,5,82,50,72,45,96]";
		assertEquals(correctAnswer, testMinHeap.toString());

	}

	// testing the method toString in the heap class with strategy minheap
	@Test
	public void testMinHeapToStringMethod() {

		String correctAnswer = "[99,90,95,65,81,45,82,72,50,96]";
		assertEquals(correctAnswer, testMinHeap.toString());

	}

	// testing the method postOrder in the heap class with strategy minheap
	@Test
	public void testMinHeapPostOrderMethod() {

		List<Integer> correctAnswer = Arrays.asList(99, 95, 90, 81, 65, 82, 72, 96, 50, 45);
		assertEquals(correctAnswer, testMinHeap.postOrder());


	}

	// testing the method preOrderOdds in the heap class with strategy minheap
	@Test
	public void testMinHeapPreOrderOddsMethod() {

		List<Integer> correctAnswer = Arrays.asList(45, 65, 99, 95, 81);
		assertEquals(correctAnswer, testMinHeap.preOrderOddNodes());

	}

	// testing the method inOrder in the heap class with strategy minheap
	@Test
	public void testMinHeapInOrderTraversalMethod() {

		String correctAnswer = "[99,90,95,65,81,45,82,72,50,96]";
		assertEquals(correctAnswer, testMinHeap.toString());

	}

	// testing the correct creation with more elements of a heap with strategy minheap
	// and the output is in postOrder traversal
	@Test
	public void testMinHeapAddMoreElements() {

		List<Integer> correctAnswer = Arrays.asList(99, 90, 95, 90, 81, 65, 20, 3, 82, 72, 50, 96, 45, 1);
		assertEquals(correctAnswer, testMinHeapMoreElements.postOrder());

	}

	// testing the method toString in the heap class with strategy maxheap
	// the method toString calls the method inOrder traversal
	@Test
	public void testMaxHeapToStringMethod() {

		String correctAnswer = "[45,95,81,96,72,99,50,65,90,82]";
		assertEquals(correctAnswer, testMaxHeap.toString());

	}
	
	// testing the method postOrder in the heap class with strategy maxheap
	@Test
	public void testMaxHeapPostOrderMethod() {

		List<Integer> correctAnswer = Arrays.asList(45, 81, 95, 72, 96, 50, 65, 82, 90, 99);
		assertEquals(correctAnswer, testMaxHeap.postOrder());

	}
	
	// testing the method preOrderOdds in the heap class with strategy maxheap
	@Test
	public void testMaxHeapPreOrderOddsMethod() {

		List<Integer> correctAnswer = Arrays.asList(99, 95, 45, 81, 65);
		assertEquals(correctAnswer, testMaxHeap.preOrderOddNodes());

	}

	// testing the method inOrder traversal in the heap class with strategy maxheap
	@Test
	public void testMaxHeapInOrderTraversalMethod() {

		String correctAnswer = "[45,95,81,96,72,99,50,65,90,82]";
		assertEquals(correctAnswer, testMaxHeap.toString());

	}

	// testing the correct creation with more elements of a heap with strategy maxheap
	// and the output is in postOrder traversal
	@Test
	public void testMaxHeapAddMoreElements() {

		List<Integer> correctAnswer = Arrays.asList(45, 90, 81, 95, 3, 1, 72, 96, 50, 20, 65, 82, 90, 99);
		assertEquals(correctAnswer, testMaxHeapMoreElements.postOrder());

	}

	//testing the iterator class Oddfilter which uses as input the data of an instance 
	// of testMinHeap class in postOrder traversal
	@Test
	public void testOddFilterClass() {

		List<Integer> correctAnswer = Arrays.asList(99, 95, 81, 65, 45);
		List<Integer> testClassOddFilterResults = new ArrayList<Integer>();

		Iterator<Integer> itr = testMinHeap.postOrder().iterator();

		OddFilter<Integer> oddies = new OddFilter<Integer>(itr);
		while (itr.hasNext())
			testClassOddFilterResults.add(oddies.next());
		
		assertEquals(correctAnswer, testClassOddFilterResults);

	}

	// testing the method toString on the Decorator Class 
	@Test
	public void testToStringDecoratorClass() {
		
		//create a heap and add 3 elements
		Heap<Integer> testee =new Heap<Integer>(minHeapStrategy);
		testee.add(5);
		testee.add(4);
		testee.add(7);
		testee.add(9);
		testee.add(2);
		
		String correctAnswer = "[9,5,7]";
		
		// instance of the decorator class with input is the heap 
		Heap<Integer> oddDecorator = new OddHeapDecorator<Integer>(testee);
		
		assertEquals(correctAnswer, oddDecorator.toString());
		
	}

	@Test
	public void testToArrayDecoratorClass() {
		//create a heap and add 3 elements
		Heap<Integer> testee =new Heap<Integer>(minHeapStrategy);
		testee.add(5);
		testee.add(4);
		testee.add(7);
		testee.add(9);
		testee.add(2);
		
		Object[] correctAnswer = {"9","5","7"};
		
		// instance of the decorator class with input is the heap 
		Heap<Integer> oddDecorator = new OddHeapDecorator<Integer>(testee);
		
		assertArrayEquals(correctAnswer,oddDecorator.toArray());
		
		
	}
	
}
