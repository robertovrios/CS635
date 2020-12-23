
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

// heap class represents a data structure that contains nodes
public class Heap<T> extends AbstractCollection<T>{

	private HeapNode<T> root;
	Strategy<T> strategy;
	private int counter = 1;
	String HeapAllNodeValues = "";


	public Heap() {
		this.root = null;
		this.strategy = null;
	}


	public HeapNode<T> getRoot() {
		return root;
	}


	// use strategy as parameter to construct the heap
	public Heap(Strategy<T> strategy) {
		this.root = null;
		this.strategy = strategy;
	}

	// add a new node with customized strategy (min or max heap)
	public boolean add(T nodeValue) {
		if(root==null) {
			root = new HeapNode<T>(nodeValue);
			return true;
		}
		if(strategy!=null)
			return root.add(nodeValue, strategy);
		else
			return false;
	}

	// all a list collection of nodes values
	public boolean addAll(List<T> nodeValues) {

		// call external iterator to insert
		externalIterator(nodeValues);
		return true;
	}

	// add 
	public void externalIterator(List<T> nodeValues) {
		Iterator<T> iterator = nodeValues.iterator();
		root = new HeapNode<T>((T) iterator.next());

		// external iterator to insert all collection values
		while (iterator.hasNext()) {

			// call add method to insert each value
			root.add((T) iterator.next(), strategy);
			counter++;
		}
	}


	// list to store the nodes of the heap in post-order traversal
	List<T> postOrderList = new ArrayList<T>();
	
	// call the helper method to store heap values in pre-order traversal
	public List<T> postOrder() {

		postOrderHelper(root,postOrderList);
		return postOrderList;
	}


	// return the values in post-order traversal
	public void postOrderHelper(HeapNode<T> node, List<T> postOrderOut) {

		if (node.isNull()) 
			return;

			if (!node.leftNode.isNull())
				postOrderHelper((HeapNode<T>) node.leftNode,postOrderOut);
			if (!node.rightNode.isNull())
				postOrderHelper((HeapNode<T>) node.rightNode,postOrderOut);
			postOrderOut.add(node.nodeValue);

	}

	// list to store the nodes of the heap in pre-order traversal
	List<T> preOrderList = new ArrayList<T>();
	
	// call the helper method to store only odd values in pre-order traversal
	public List<T> preOrderOddNodes() {

		preOrderHelper(root,preOrderList);
		return preOrderList.stream().filter(value -> (int) value % 2 != 0).collect(Collectors.toList());
	}
	
	// return the values in pre-order traversal
	public void preOrderHelper(HeapNode<T> node, List<T> preOrderOut) {

		if (node.isNull()) 
			return;

			preOrderOut.add(node.nodeValue);
			if (!node.leftNode.isNull())
				preOrderHelper((HeapNode<T>) node.leftNode,preOrderOut);
			if (!node.rightNode.isNull())
				preOrderHelper((HeapNode<T>) node.rightNode,preOrderOut);

	}
	
	// returns in-order traversal when the method toString is called
	public String inOrderTraversal(HeapNode<T> node) {

		if (node.isNull())
			return null;
		if (!node.leftNode.isNull())
			inOrderTraversal((HeapNode<T>) node.leftNode);

		HeapAllNodeValues = HeapAllNodeValues + node.nodeValue + ",";

		if (!node.rightNode.isNull())
			inOrderTraversal((HeapNode<T>) node.rightNode);
		return HeapAllNodeValues;

	}

	// use the output of toString method to create an array object[]
	@Override
	public Object[] toArray() {

		String nodeValueStrings = root.toString();
		Object[] arrayOfNodeValues = nodeValueStrings.substring(1, nodeValueStrings.length() - 1).split(",");

		return arrayOfNodeValues;

	}

	// return a string of heap elements separated by commas and between brackets
	@Override
	public String toString() {

		//this.forEach(v->this.internalIterator());
		if (root.isNull())
			return "";
		String contents = inOrderTraversal(root);
		return ("[" + HeapAllNodeValues.substring(0, contents.length() - 1) + "]");


	}


	

	@Override
	public int size() {
		return counter;
	}

	// iterator use the postOrder method for iteration 
	@Override
	public Iterator<T> iterator() {

		return this.postOrder().iterator();
	}


	
}
