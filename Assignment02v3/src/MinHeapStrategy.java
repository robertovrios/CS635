
// class that contains the algorithm to create a Min Heap
public class MinHeapStrategy<T extends Comparable<T>> extends AddNodeStrategy<T> {

	// checks that the smallest value is in the top in the heap
	@Override
	public boolean firstToBeInserted(HeapNode<T> node, T value) {

		return node.nodeValue.compareTo(value) >= 0;
	}

}
