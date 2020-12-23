
// abstract parent class strategy where is defined the common tasks
abstract class AddNodeStrategy<T> implements Strategy<T> {

	// insert the new value into the heapnode
	@Override
	public boolean add(HeapNode<T> node, T insertValue) {

		// if the node is null create null objects
		if (node.isNull())
			node = new HeapNode<T>(insertValue, new NullNode<T>(), new NullNode<T>());
		else {

			// call the strategy to be used min or max
			if (firstToBeInserted(node, insertValue))
				insertValue = node.swapValues(insertValue);

			// check if the heapnode is complete. It's not, complete the heapnode.
			if (node.isCompletedNode()) {

				// insert into the smallest height of the right or left subheaps. In case of
				// equals heights use the left subheap
				if (node.leftNode.findHeight() <= node.rightNode.findHeight())
					return add((HeapNode<T>) node.leftNode, insertValue);
				else
					return add((HeapNode<T>) node.rightNode, insertValue);

			} else {
				node.completeNode(insertValue);
				return true;
			}
		}
		return false;
	}

	public abstract boolean firstToBeInserted(HeapNode<T> node, T value);

}
