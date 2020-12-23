
public class MinHeapTest {

	public static void main(String[] args) {

		// create a test
		MinHeap minHeap = new MinHeap();
		int[] testValues = { 45, 65, 72, 90, 81, 82, 96, 99, 95, 50 };

		// insert all array values
		for (int i = 0; i < testValues.length; i++) {
			minHeap.insertNode(testValues[i]);
		}

		// printing in post-order
		System.out.println("Post Order:");
		minHeap.postOrder();
		System.out.println("");

		// printing odd numbers in pre-order
		System.out.println("Pre-Order:  Odd Numbers");
		minHeap.preOrder();

	}

}
