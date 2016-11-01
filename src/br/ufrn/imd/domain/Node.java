package br.ufrn.imd.domain;

/**
 * Class that represents the node of the tree
 * 
 * @author pdr_m
 *
 * @param <T>
 *            The type of the generic node
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
	/**
	 * value of this node
	 */
	private T value;

	/**
	 * the left node
	 */
	private Node<T> left;

	/**
	 * the right node
	 */
	private Node<T> right;

	/**
	 * Constructor of the node
	 * 
	 * @param value
	 *            The value of the node
	 */
	public Node(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	/**
	 * Constructor of the node receiving the left and right nodes
	 * 
	 * @param value
	 *            The value of the node
	 * @param left
	 *            The left node of this node
	 * @param right
	 *            The right node of this node
	 */
	public Node(T value, Node<T> left, Node<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	/**
	 * Get the value of this node
	 * 
	 * @return the value of this node
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Set the value of this node
	 * 
	 * @param value
	 *            to the value of the node
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Get the left node of this node
	 * 
	 * @return the left node of this node
	 */
	public Node<T> getLeft() {
		return left;
	}

	/**
	 * Set the left node of this node
	 * 
	 * @param left
	 *            node of this node
	 */
	public void setLeft(Node<T> left) {
		this.left = left;
	}

	/**
	 * Get the right node of this node
	 * 
	 * @return the right node of this node
	 */
	public Node<T> getRight() {
		return right;
	}

	/**
	 * Set the rigth node of this node
	 * 
	 * @param right
	 *            node of this node
	 */
	public void setRight(Node<T> right) {
		this.right = right;
	}

	@Override
	public int compareTo(Node<T> node) {
		return value.compareTo(node.getValue());
	}
}
