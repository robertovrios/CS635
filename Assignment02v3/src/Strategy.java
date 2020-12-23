
public interface Strategy<T> {

	boolean add(HeapNode<T> node, T insertValue);

	boolean firstToBeInserted(HeapNode<T> node, T value);

}
