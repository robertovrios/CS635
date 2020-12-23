
public class MinHeap {
	private Node root;

	// MinHeap class constructor
	public MinHeap() {
		root = null;
	}

	// method that insert a new value into the heap
	public void insertNode(int insertValue) {

		// if the heap is empty the new value is inserted on the root
		if (root == null)
			root = new Node(insertValue);
		else {
			// call the class method to insert a new value
			root.insert(insertValue);

		}
	}

	// method that call the post order helper method
	public void postOrder() {
		postOrderHelper(root);
	}

	// helper to print the heap in post-order (left node, right node, root)
	public void postOrderHelper(Node node) {
		// finish if the node is null
		if (node == null)
			return;

		// call recursively the helper for the left, right, and root
		postOrderHelper(node.leftNode);
		postOrderHelper(node.rightNode);
		System.out.printf("%s ", node.nodeValue);

	}

	// method that call the pre-order helper method
	public void preOrder() {
		preOrderHelper(root);
	}

	// helper to print the heap in pre-order (root, left node, right node)
	public void preOrderHelper(Node node) {
		if (node == null)
			return;

		// test if the node value is odd
		if (node.isOdd())

			// call recursively the helper for the left, right, and root
			System.out.printf("%s ", node.nodeValue);

		preOrderHelper(node.leftNode);
		preOrderHelper(node.rightNode);

	}

}
