package daily2021.january;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two binary trees original and cloned and given a reference to a node
 * target in the original tree.
 * 
 * The cloned tree is a copy of the original tree.
 * 
 * Return a reference to the same node in the cloned tree.
 * 
 * Note that you are not allowed to change any of the two trees or the target
 * node and the answer must be a reference to a node in the cloned tree.
 * 
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 * 
 */
public class GetTargetFromBinaryTree_DFS {

// {Given}	 Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		TreeNode copy = null;
		Set<TreeNode> nodeSet = new HashSet();
		nodeSet.add(cloned);

		while (copy == null) {
			for (TreeNode node : nodeSet) {
				if (node.val == target.val) {
					copy = node;
					break;
				}
			}
			if (copy == null) {
				Set<TreeNode> nextSet = new HashSet();
				for (TreeNode node : nodeSet) {
					if (node.left != null)
						nextSet.add(node.left);
					if (node.right != null)
						nextSet.add(node.right);
				}
				nodeSet = nextSet;
			}
		}

		return copy;
	}
}
