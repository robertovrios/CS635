
// Class HeapNode that is formed for 2 children nodes left and right
public class HeapNode<T> implements Node<T> {

	// HeapNode class that holds pointers to the right and left nodes
	protected Node<T> leftNode, rightNode;
	protected T nodeValue;

	public HeapNode(T nodeValue) {

		this.nodeValue = nodeValue;
		this.leftNode = new NullNode<T>();
		this.rightNode = new NullNode<T>();
	}

	public HeapNode(T nodeValue, Node<T> leftNode, Node<T> rightNode) {

		this.nodeValue = nodeValue;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	// insert a new value using a determined strategy
	public boolean add(T insertValue, Strategy<T> strategy) {
		
			return strategy.add(this, insertValue);


	}

	// test is the heapnode is completed
	public boolean isCompletedNode() {

		return !(rightNode.isNull() || leftNode.isNull());
	}

	// insert the new value in the left or the right node
	public void completeNode(T insertValue) {

		if (leftNode.isNull())
			leftNode = new HeapNode<T>(insertValue);
		else
			rightNode = new HeapNode<T>(insertValue);
	}

	// method that finds the height of a node
	public int findHeight() {
		if (!isCompletedNode())
			return 0;
		else {
			int leftNodeHeight = leftNode.findHeight();
			int rightNodeHeight = leftNode.findHeight();

			return Math.max(leftNodeHeight, rightNodeHeight) + 1;
		}
	}

	// swap 2 objects
	T swapValues(T insertValue) {

		T temp = this.nodeValue;
		this.nodeValue = insertValue;
		return temp;

	}

	public boolean isNull() {
		return false;
	}

}
