package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

class Node {
	char data;
	
	Node left;
	Node right;
	
	public Node ( char data ) {
		this.data = data;
	}
}
class Tree {
	Node root;
	
	public void add ( char data, char leftData, char rightData ) {
		if ( root == null ) {
			if ( data != '.' ) root = new Node(data);
			if ( leftData != '.' ) root.left = new Node(leftData);
			if ( rightData != '.' ) root.right = new Node(rightData);
		}
		else {
			search(root, data, leftData, rightData);
		}
	}
	
	public void search ( Node root, char data, char leftData, char rightData ) {
		if ( root == null ) return;
		else if ( root.data == data ) {
			if ( leftData != '.') root.left = new Node(leftData);
			if ( rightData != '.') root.right = new Node(rightData);
		}
		else {
			search(root.left, data, leftData, rightData); //왼쪽 재귀탐색 
			search(root.right, data, leftData, rightData); //오른쪽 재귀탐색 
		}
		
		
	}
	
	public void preOrder( Node root ) {
		System.out.print(root.data);
		if ( root.left != null ) preOrder(root.left);
		if ( root.right != null ) preOrder(root.right);
	}
	
	public void inOrder ( Node root ) {
		if ( root.left != null ) inOrder(root.left);
		System.out.print(root.data);
		if ( root.right != null ) inOrder(root.right);
	}
	
	public void postOrder ( Node root ) {
		if ( root.left != null ) postOrder(root.left);
		if ( root.right != null ) postOrder(root.right);
		System.out.print(root.data);
	}
	
	
}
public class EginTree {
	//백준 1991 트리 순회 
	//이진트리를 입력받아 전위 순회 (루트, 왼쪽자식, 오른쪽자식 순) ABDCEFG
	//중위순회 (왼쪽 자식, 루트, 오른쪽자식 순) DBAECFG
	//후위순회 (왼쪽 자식, 오른쪽자식, 루트 순) DBEGFCA 
	//로 출력 
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("Tree.txt"));
		
		int n = sc.nextInt();
		Tree tree = new Tree();
		for ( int i = 0; i < n; i ++ ) {
			String top = sc.next();
			String leftChild = sc.next();
			String rightChild = sc.next();
			tree.add(top.charAt(0), leftChild.charAt(0), rightChild.charAt(0));
		}
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		
	}

}
