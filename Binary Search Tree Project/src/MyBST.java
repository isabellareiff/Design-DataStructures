// Implements a BST with TreeNode nodes

import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings({ "unchecked", "unused" })
// Normally, TreeNode and MyTreeSet would be "generic" (type-specific)
// classes and hold Comparable objects, but this is beyond the scope of
// the Java Methods book. Without @SuppressWarnings, this class would give
// three "Unchecked cast" warnings.

public class MyBST
{
	private TreeNode root;  // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(Object value) {
		return contains(root, value);
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(Object value) {
		if (contains(value))
			return false;
		root = add(root, value);
		return true;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(Object value) {
		if (!contains(value))
			return false;
		root = remove(root, value);
		return true;
	}

	// Returns a string representation of this BST.
	public String toString() {
		String str = toString(root);
		if (str.endsWith(", "))
			str = str.substring(0, str.length() - 2);
		return "[" + str + "]";
	}

	//*************** Private helper methods: *********************

	// Returns true if the BST rooted at node contains value;
	// otherwise returns false (recursive version).

	private boolean contains(TreeNode node, Object value) {
		if (node == null)
			return false;
		else
		{
			int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
			if (diff == 0)
				return true;
			else if (diff < 0)
				return contains(node.getLeft(), value);
			else // if (diff > 0)
				return contains(node.getRight(), value);
		}
	}

	// Adds value to the BST rooted at node. Returns the
	// root of the new tree.
	// Precondition: the tree rooted at node does not contain value.
	private TreeNode add(TreeNode node, Object value) {
		if (node == null){
			return new TreeNode (value);
		}
		else if (((Comparable<Object>)value).compareTo(node.getValue()) < 0) { // new is smaller
			node.setLeft(add (node.getLeft(), value));
		}
		else { //if(((Comparable<Object>)value).compareTo(node.getValue()) > 0) { // new is bigger
			node.setRight(add (node.getRight(), value));
		}
		return node;
	}

	// Removes value from the BST rooted at node.
	// Returns the root of the new tree.
	// Precondition: the tree rooted at node contains value.
	private TreeNode remove(TreeNode node, Object value) {
		int difference = ((Comparable<Object>) value).compareTo(node.getValue());
		if (difference == 0){
			return removeRoot(node);
		}
		else if(difference < 1){
			node.setLeft(remove(node.getLeft(), value));
		}
		else{
			node.setRight(remove(node.getRight(), value));
		}
		return node;
	}

	// Removes the root of the BST rooted at root
	// replacing it with the smallest node from the right subtree.
	// Returns the root of the new tree.
	private TreeNode removeRoot(TreeNode root) {
	TreeNode right = root.getRight();
		if (right==null)
			return removeRoot(root.getLeft());
		else {
			TreeNode node = right;
			TreeNode prev = root;
			while (node.getLeft()!=null){
				prev = node;
				node = node.getLeft();
			}
			root.setValue (node.getValue());
			if (node.getRight()==null && prev.getRight().equals(node))
				prev.setLeft(null);
			else if (node.getRight()==null && prev.getLeft().equals(node)) //done
				prev.setRight(null);
			else if (prev.getLeft().equals(node))
				prev.setLeft(node.getRight());
			else if (prev.getRight().equals(node))
				prev.setRight(node.getRight());
		}
		return root;
	}
	
	private boolean isLeaf(TreeNode node) {
		return (node.getLeft()==null && node.getRight()==null);
	}
	
	private String listLeafs () {
		return listLeafs(root);
	}
	
	private String listLeafs (TreeNode node) {
		return (isLeaf(node))?node.getValue() + ",":listLeafs(node.getLeft()) + listLeafs(node.getRight());
	}

	// Returns the sum of all the Integer values stored in the tree.
	// Precondition: all the nodes only store Integers.
	public int sumTree() {
		return sumTree(root);
	}

	public int sumTree (TreeNode node) {
		return (node==null)?0:sumTree(node.getLeft()) + sumTree(node.getRight()) + (Integer) node.getValue();
	}
	
	// Returns the length of the longest path in the tree.
	public int depth() {
		return depth(root);
	}
	
	public int depth (TreeNode node) {
		int dep = 0;
		if (node==null){
			return 0;
		}
		else{
			int left = depth(node.getLeft());
			int right = depth(node.getRight());
				return (left > right)?left + 1:right + 1;
		}
	}

	//Returns an int representing the total number of nodes in the tree.
	public int countNodes() {
		return countNodes(root);
	}
	
	public int countNodes (TreeNode node) {
		int counter = 0;
		if (node == null)
			return 0;
		else{
			return countNodes(node.getLeft()) + countNodes(node.getRight()) + 1;
		}
	}

	// Returns the ratio of the number of nodes in the tree to the maximum
	// possible number of nodes in a binary tree with the same number of levels.
	// Hint: ^^
	public double bushRatio() {
		int possible = depth()*2;
		return (countNodes())/possible;
	}

	// Returns true if and only if the subtrees rooted at root1 and root2
	// are not leaves and they have the same shape.
	public boolean sameShape(TreeNode root1, TreeNode root2) {
		return false;
	}

	// Returns a String listing all pairs of nodes whose subtrees are the same shape.
	// For example: "the 2-node and the 4-node, the 7-node and the 3-nodes, ..."
	public String findSameShapeNodes() {
		return null;
	}
	
	// Returns a string representation of the tree rooted at node.
	private String toString(TreeNode node) {
		return(node == null)?"":toString(node.getLeft()) + node.getValue() + ", " +
			toString(node.getRight());
	}
}
