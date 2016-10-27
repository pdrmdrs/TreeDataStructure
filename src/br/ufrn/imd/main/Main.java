package br.ufrn.imd.main;

import br.ufrn.imd.implementation.BinaryTree;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");

		Integer[] intArray = { 1, 5, 2, 7, 4 };

		BinaryTree<Integer> bt = new BinaryTree<Integer>();

		for (Integer n : intArray)
			bt.insert(n);

		System.out.println(bt.getRoot().getValue());// 1
		System.out.println(bt.getRoot().getRight().getValue());// 5
		System.out.println(bt.getRoot().getRight().getLeft().getValue());// 2
		System.out.println(bt.getRoot().getRight().getRight().getValue());// 7
		System.out.println(bt.getRoot().getRight().getLeft().getRight().getValue());// 4
		System.out.println("------");
		System.out.println(bt.search(4));//true
		System.out.println(bt.search(3));//false
		System.out.println("------");
		
	}

}
