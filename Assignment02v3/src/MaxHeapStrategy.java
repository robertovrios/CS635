
// class that contains the algorithm to create a Max Heap
public class MaxHeapStrategy<T extends Comparable<T>> extends AddNodeStrategy<T> {

	// checks that the greatest value is in the top in the heap
	@Override
	public boolean firstToBeInserted(HeapNode<T> node, T value) {

		return node.nodeValue.compareTo(value) <= 0;
	}
}
