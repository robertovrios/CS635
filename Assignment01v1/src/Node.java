public class Node {
	protected Node leftNode, rightNode;
	protected int nodeValue;

	// Node class constructor
	public Node(int nodeValue) {

		this.nodeValue = nodeValue;
		leftNode = null;
		rightNode = null;
	}

	// method that finds the height of a node
	public int findHeight(Node node) {

		if (node.leftNode == null || node.rightNode == null)
			return 0;
		return findHeight(node.leftNode) + 1;

	}

	// method that test if the node has a left child and right child and insert to
	// create a complete heat (root, left,right)
	public boolean completeNode(Node node, int insertValue) {

		boolean isCompleted = false;

		// test if the left child node is null and insert the new node in the left child
		// position
		if (node.leftNode == null) {
			node.leftNode = new Node(insertValue);

			// test if the right child node is null and insert the new node in the right
			// child position
		} else if (node.rightNode == null) {
			node.rightNode = new Node(insertValue);

			// return that the node is complete
		} else {
			isCompleted = true;
		}

		return isCompleted;
	}

	// method that test if the node values is odd
	public boolean isOdd() {
		if (this.nodeValue % 2 == 0)
			return false;
		else
			return true;
	}

	// method that insert the new node
	public void insert(int insertValue) {

		// test if the parent node is greater that the new node value
		if (nodeValue > insertValue) {
			insertValue = swapValues(nodeValue, insertValue);
		}

		// test if the current node is completed. If it has left and right children
		if (completeNode(this, insertValue)) {

			// test if the left child node height is greater that the right one
			if (findHeight(leftNode) <= findHeight(rightNode)) {

				// call recursively the method insert for the left child node
				leftNode.insert(insertValue);

			} else if (findHeight(leftNode) > findHeight(rightNode)) {

				// call recursively the method insert for the right child node
				rightNode.insert(insertValue);

			}

		}

	}

	// method that swaps 2 values and insert directly the new value to the node
	private int swapValues(int value, int insertValue) {

		int temp = value;
		this.nodeValue = insertValue;
		return temp;

	}
}
