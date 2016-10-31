package br.ufrn.imd.implementation;

import br.ufrn.imd.domain.Node;
import br.ufrn.imd.exceptions.CannotDeleteException;

public class BinaryTree<T extends Comparable<T>> {

	private Node<T> root;
	private int size;

	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(T rootValue) {
		this.root = new Node<T>(rootValue);
	}

	public Node<?> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void insert(T value) {
		this.root = insert(this.root, value);
		this.size+= 1;
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

	public void delete(T value) throws CannotDeleteException {
		this.root = delete(this.root, value);
	}
	
	private Node<T> delete(Node<T> node, T value) throws CannotDeleteException {
		if (node == null) {
			throw new CannotDeleteException("Cannot delete this item");
		} else if(node.getValue().compareTo(value) > 0) {
			node.setLeft(delete(node.getLeft(), value));
		} else if(node.getValue().compareTo(value) < 0) {
			node.setRight(delete(node.getRight(), value));
		} else {
			if(node.getLeft() == null) {
				return node.getRight();
			} else if(node.getRight() == null){
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
