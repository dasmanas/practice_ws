package com.practice.tree.avltree;

public class AvlTree {

    /**
     *          y                                     x
     *         / \                                   / \
     *        x  T3       Right Rotate (y)          T1  y
     *       / \          - - - - - - - - ->           / \
     *     T1  T2                                     T2  T3
     */
    public AvlTreeNode rotateRight(AvlTreeNode y){
        AvlTreeNode x = y.left;
        AvlTreeNode T2 = x.right;
        x.right = y;
        y.left = T2;
        return x;
    }

    /**
     *          y                                     x
     *         / \                                   / \
     *        x  T3        Left Rotate (x)         T1  y
     *       / \          <- - - - - - - -            / \
     *     T1  T2                                   T2  T3
     */
    public AvlTreeNode rotateLeft(AvlTreeNode x){
        AvlTreeNode y = x.right;
        AvlTreeNode T2 = y.left;
        y.left = x;
        x.right = T2;
        return y;
    }



    public AvlTreeNode insert(AvlTreeNode avlTreeNode, int data){
        if (avlTreeNode==null){
            avlTreeNode = new AvlTreeNode(data);
        } else {

            if(data < avlTreeNode.data ){
                avlTreeNode.left = insert(avlTreeNode.left, data);
            } else if(data > avlTreeNode.data){
                avlTreeNode.right = insert(avlTreeNode.right, data);
            } else {

            }

            avlTreeNode.height = Math.max(getHeight(avlTreeNode.left), getHeight(avlTreeNode.right)) + 1;

            int balanceDifference = calculateBalance(avlTreeNode);

            if (balanceDifference > 1 && data < avlTreeNode.left.data){
                // left left case
                // right rotation required
                /**
                 *        z                                      y
                 *       / \                                   /   \
                 *      y   T4      Right Rotate (z)          x      z
                 *     / \          - - - - - - - - ->      /  \    /  \
                 *    x   T3                               T1  T2  T3  T4
                 *   / \
                 * T1   T2
                 */
                avlTreeNode = rotateRight(avlTreeNode);


            } else if (balanceDifference > 1 && data > avlTreeNode.left.data){
                // left right case
                // left rotation then right rotation
                /**
                 *     z                                 z                             T3
                 *    / \                               / \                           /   \
                 *   y   T4      Left Rotate (y)      T3  T4  Right Rotate (T3)      y     z
                 *  / \        <- - - - - - - -      / \      - - - - - - - - - >   / \    / \
                 * x   T3                           y  T2                          x  T1  T2  T4
                 *     / \                         / \
                 *   T1   T2                      x  T1
                 */
                avlTreeNode.left = rotateLeft(avlTreeNode.left);
                avlTreeNode = rotateRight(avlTreeNode);

            } else if (balanceDifference < -1 && data < avlTreeNode.right.data){
                // right left case
                // right rotation then left rotation
                /**
                 *    z                            z                            x
                 *   / \                          / \                          /  \
                 * T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
                 *     / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
                 *    x   T4                      T2   y                  T1  T2  T3  T4
                 *   / \                              /  \
                 * T2   T3                           T3   T4
                 */

                avlTreeNode.right = rotateRight(avlTreeNode.right);
                avlTreeNode = rotateLeft(avlTreeNode);

            } else if (balanceDifference < -1 && data > avlTreeNode.right.data){
                // right right case
                // left rotation required
                /**
                 *      y			                      z
                 *    /   \ 		                	 /  \
                 *   z      x		 Left Rotate(z) 	T1   y
                 *  / \    / \		 <- - - - - - - 	    /  \
                 * T1  T2 T3  T4	                	   T2   x
                 * 										       / \
                 * 										     T3  T4
                 */
                avlTreeNode = rotateLeft(avlTreeNode);

            }
        }
        return avlTreeNode;
    }

    public int getHeight(AvlTreeNode avlTreeNode){
        int height = 0;
        if(avlTreeNode==null){
            height = 0;
        } else {
            height = avlTreeNode.height;
        }
        return height;
    }

    public int calculateBalance(AvlTreeNode avlTreeNode){
        int balance = 0;
        if(avlTreeNode!=null){
            balance = getHeight(avlTreeNode.left) - getHeight(avlTreeNode.right);
        } else {
            balance = 0;
        }
        return balance;
    }
}
