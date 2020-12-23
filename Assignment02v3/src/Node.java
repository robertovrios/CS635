

interface Node<T> {

	abstract int findHeight();

	abstract boolean isCompletedNode();

	abstract void completeNode(T insertValue);

	abstract boolean isNull();

}
