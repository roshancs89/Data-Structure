package org.ds.tree;

/**
 * Builds a binary tree from Preorder and Inorder transversal data given for a tree.
 * 
 * Running Time : O(n ^ 2) as search is done using each iteration. Can be optimized using 
 * hash map.
 * @author Roshan
 * 
 * Assumption is that preorder and inorder details are correct.
 * If they are not correct, Algorithm will fail.
 * 
 * Simple Input:
 * Preorder: 1 2 4 5 3 6 7
 * Inorder: 4 2 5 1 6 3 7
 *
 */
public class BuildTree {
	
	// Tree representation.
	class Node{
		Node left, right;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	Node root;
	//Index for preorder
	int preIndex;
	
	public static void main(String args[]) {
		BuildTree tree = new BuildTree();
		int[] inorder = {4, 2, 5, 1, 6, 3, 7};
		int[] preorder = {1,2, 4, 5, 3, 6, 7};
		int len = inorder.length;
		Node root = tree.build(preorder, inorder, 0, len-1);
		System.out.println("Print inorder traversal of generated tree");
		tree.printInOrder(root);
		System.out.println();
		System.out.println("------------");
		System.out.println("Print preorder traversal of generated tree");
		tree.printPreOrder(root);
		System.out.println();
		System.out.println("------------");
		
	}
	
	Node build(int[] preorder, int[] inorder, int inOrderStart, int inOrderEnd) {
		
		if(inOrderStart > inOrderEnd)
			return null;
		
		//Get preorder data
		Node preNode = new Node(preorder[preIndex++]);
		
		//Search node in Inorder and get the index.
		int inIndex = search(inorder, preNode.data, inOrderStart, inOrderEnd);
		
		preNode.left = build(preorder, inorder, inOrderStart, inIndex-1);
		preNode.right = build(preorder, inorder, inIndex+1, inOrderEnd);
	
		return preNode;
	}
	
	private int search(int[] inorder, int preData, int start,int  end) {
		
		int i = 0;
		for(i = start; i <= end; i++) {
			if(inorder[i] == preData)
				return i;
		}
		//Should handle exception, But return irrelevan value now
		System.out.println("Could not find the element");
		return i;
		
		
	}
	
	void printInOrder(Node root) {
		
		if(root == null)
			return;
		
		printInOrder(root.left);
		
		System.out.print(root.data+" ");
		
		printInOrder(root.right);
		
	}
	
	void printPreOrder(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.data+ " ");
		
		printPreOrder(root.left);
		printPreOrder(root.right);
		
	}

}
