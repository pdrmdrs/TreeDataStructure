package br.ufrn.imd.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufrn.imd.domain.Node;

public class NodeTest {

	Node<Integer> n1, n2, n3, n4, n5, n6, n7;
	
	@Before
	public void setUp() throws Exception {
		n1 = new Node<Integer>(1);
		n2 = new Node<Integer>(2);
		n3 = new Node<Integer>(3);
		n4 = new Node<Integer>(4);
		n5 = new Node<Integer>(1);
		
		n6 = new Node<Integer>(5, n1, n2);
		n7 = new Node<Integer>(7, n6, n5);
	}

	@Test
	public void testNodeT() {
		assertEquals(n1.getValue(), 1, 0);
		assertEquals(n2.getValue(), 2, 0);
		assertEquals(n3.getValue(), 3, 0);
		assertEquals(n4.getValue(), 4, 0);
		assertEquals(n5.getValue(), 1, 0);
	}

	@Test
	public void testGetValue() {
		assertEquals(n1.getValue(), 1, 0);
		assertEquals(n2.getValue(), 2, 0);
		assertEquals(n3.getValue(), 3, 0);
		assertEquals(n4.getValue(), 4, 0);
		assertEquals(n5.getValue(), 1, 0);
	}

	@Test
	public void testSetValue() {
		n1.setValue(5);
		n2.setValue(6);
		n3.setValue(7);
		n4.setValue(8);
		n5.setValue(5);
		
		assertEquals(n1.getValue(), 5, 0);
		assertEquals(n2.getValue(), 6, 0);
		assertEquals(n3.getValue(), 7, 0);
		assertEquals(n4.getValue(), 8, 0);
		assertEquals(n5.getValue(), 5, 0);
	}

	@Test
	public void testGetLeft() {
		assertEquals(n6.getLeft(), n1);
		assertEquals(n7.getLeft(), n6);
		assertEquals(n1.getLeft(), null);
	}

	@Test
	public void testSetLeft() {
		n1.setLeft(n2);
		n2.setLeft(n3);
		n3.setLeft(n4);
		
		assertEquals(n1.getLeft(), n2);
		assertEquals(n2.getLeft(), n3);
		assertEquals(n3.getLeft(), n4);
	}

	@Test
	public void testGetRight() {
		assertEquals(n6.getRight(), n2);
		assertEquals(n7.getRight(), n5);
		assertEquals(n1.getRight(), null);
	}

	@Test
	public void testSetRight() {
		n1.setRight(n2);
		n2.setRight(n3);
		n3.setRight(n4);
		
		assertEquals(n1.getRight(), n2);
		assertEquals(n2.getRight(), n3);
		assertEquals(n3.getRight(), n4);
	}

	@Test
	public void testCompareTo() {
		assertEquals(n1.compareTo(n5), 0);
		assertEquals(n1.compareTo(n2), -1);
		assertEquals(n2.compareTo(n1), 1);
	}

}
