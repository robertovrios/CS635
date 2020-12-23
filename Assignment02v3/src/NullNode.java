
// null class to control null objects
public class NullNode<T> implements Node<T> {

	
	public boolean add(HeapNode<T> root, T insertValue) {
		return root.add(insertValue, null);
		}
	
	@Override
	public int findHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCompletedNode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void completeNode(T insertValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return true;
	}

}
