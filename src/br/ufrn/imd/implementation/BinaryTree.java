package br.ufrn.imd.implementation;

import br.ufrn.imd.domain.Node;
import br.ufrn.imd.exceptions.CannotDeleteException;

/**
 * Class that represents the Binary Search Tree
 * 
 * @author Pedro Paulo Paiva de Medeiros
 *
 * @param <T>
 *            the type of the itens that the tree will contain
 */
public class BinaryTree<T extends Comparable<T>> {

	/**
	 * The root node of the tree
	 */
	private Node<T> root;

	/**
	 * The number of the elements on the tree
	 */
	private int size = 1;

	/**
	 * Empty constructor
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * The constructor of the tree receiving the root value
	 * 
	 * @param rootValue
	 *            the value of the root
	 */
	public BinaryTree(T rootValue) {
		this.root = new Node<T>(rootValue);
	}

	/**
	 * Get the root node
	 * 
	 * @return the root node
	 */
	public Node<?> getRoot() {
		return root;
	}

	/**
	 * Set the node of the root
	 * 
	 * @param root
	 *            to the root of the tree
	 */
	public void setRoot(Node<T> root) {
		this.root = root;
	}

	/**
	 * Get the number of elements on the tree
	 * 
	 * @return the size of the tree
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Set the size of the tree (Only here to contemplate the "getters and
	 * setters for all atributes")
	 * 
	 * @param size
	 *            to the size of the tree
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Insert a value on the tree
	 * 
	 * @param value
	 *            to insert on the tree
	 */
	public void insert(T value) {
		this.root = insert(this.root, value);
		this.size += 1;
	}

	private Node<T> insert(Node<T> node, T value) {
		if (node == null) {
			return new Node<T>(value);
		}
		if (node.getValue().compareTo(value) == 0) {
			return node;
		}
		if (node.getValue().compareTo(value) > 0) {
			node.setLeft(insert(node.getLeft(), value));
		} else {
			node.setRight(insert(node.getRight(), value));
		}
		return node;
	}

	/**
	 * Delete a value on the tree
	 * 
	 * @param value
	 *            to delete on the tree
	 * @throws CannotDeleteException
	 *             exception for when the item cant be deleted
	 */
	public void delete(T value) throws CannotDeleteException {
		this.root = delete(this.root, value);
	}

	private Node<T> delete(Node<T> node, T value) throws CannotDeleteException {
		if (node == null) {
			throw new CannotDeleteException("Cannot delete this item");
		} else if (node.getValue().compareTo(value) > 0) {
			node.setLeft(delete(node.getLeft(), value));
		} else if (node.getValue().compareTo(value) < 0) {
			node.setRight(delete(node.getRight(), value));
		} else {
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else {
				this.size -= 1;
				node.setValue(getData(node.getLeft()));
				node.setLeft(delete(node.getLeft(), node.getValue()));
			}
		}

		return null;
	}

	private T getData(Node<T> node) {
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node.getValue();
	}

	/**
	 * Search if a value is present on the tree or not
	 * 
	 * @param value
	 *            the value to search
	 * @return if the value is present or not
	 */
	public boolean search(T value) {
		return search(this.root, value);
	}

	private boolean search(Node<T> node, T value) {
		if (node == null) {
			return false;
		} else if (node.getValue().compareTo(value) == 0) {
			return true;
		} else if (node.getValue().compareTo(value) > 0) {
			return search(node.getLeft(), value);
		} else {
			return search(node.getRight(), value);
		}
	}

}
