package br.ufrn.imd.implementation;

import br.ufrn.imd.domain.Node;

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

	public void delete(Node<T> node) {

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
