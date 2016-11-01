package br.ufrn.imd.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufrn.imd.domain.Node;
import br.ufrn.imd.exceptions.CannotDeleteException;
import br.ufrn.imd.implementation.BinaryTree;

public class BinaryTreeTest {

	BinaryTree<Integer> bt1;
	BinaryTree<Integer> bt2;

	@Before
	public void setUp() throws Exception {
		this.bt1 = new BinaryTree<Integer>();
		this.bt2 = new BinaryTree<Integer>(50);
	}

	@Test
	public void testGetRoot() {
		assertNull(this.bt1.getRoot());
		assertNotNull(this.bt2.getRoot());
	}

	@Test
	public void testSetRoot() {
		this.bt1.setRoot(new Node<Integer>(30));
		this.bt2.setRoot(new Node<Integer>(40));

		assertEquals(this.bt1.getRoot().getValue(), 30);
		assertEquals(this.bt2.getRoot().getValue(), 40);
	}

	@Test
	public void testGetSize() {
		assertEquals(this.bt1.getSize(), 1);
		assertEquals(this.bt2.getSize(), 1);
	}

	@Test
	public void testSetSize() {
		this.bt1.setSize(2);
		this.bt2.setSize(3);

		assertEquals(this.bt1.getSize(), 2);
		assertEquals(this.bt2.getSize(), 3);
	}

	@Test
	public void testSearch() {
		assertFalse(this.bt1.search(10));
		assertTrue(this.bt2.search(50));
	}

	@Test
	public void testInsert() {
		this.bt1.insert(30);
		this.bt2.insert(30);

		assertTrue(this.bt1.search(30));
		assertTrue(this.bt2.search(30));
	}

	@Test
	public void testDelete() {
		this.bt1.insert(40);
		this.bt2.insert(40);

		assertTrue(this.bt1.search(40));
		assertTrue(this.bt2.search(40));

		try {
			this.bt1.delete(40);
			this.bt2.delete(40);
		} catch (CannotDeleteException e) {
			e.printStackTrace();
		}
		
		assertFalse(this.bt1.search(40));
		assertFalse(this.bt2.search(40));
	}

}
