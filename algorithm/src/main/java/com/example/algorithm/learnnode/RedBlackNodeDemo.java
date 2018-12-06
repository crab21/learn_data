package com.example.algorithm.learnnode;

/**
 * 红黑树eg
 */
public class RedBlackNodeDemo {
    private static RedBlackNode NIL = new RedBlackNode(RedBlackNode.Color.Black);

    /*
     * 红黑树的根
     */
    private RedBlackNode root = NIL;

    public void insert(int value) {
        RedBlackNode node = new RedBlackNode(value, NIL, NIL, RedBlackNode.Color.Red);
        if (contains(node, root)) {
            return;
        }
        insert(node, root);
    }

    public void insert(RedBlackNode node, RedBlackNode root) {
        if (this.root == NIL) {
            this.root.color = RedBlackNode.Color.Black;
            this.root = node;
        }
        RedBlackNode parent = root;
        while (node.value != root.value) {

            //更新parent
            parent = root;

            /*插到右子树
             */
            if (node.value > root.value) {
                root = root.right;
                if (root == NIL) {
                    node.parent = parent;
                    parent.right = node;
                    break;
                }
            }
            root = root.left;
            if (root == NIL) {
                node.parent = parent;
                parent.left = node;
                break;
            }
        }
        /**
         * 执行修复操作
         */
        insertFixUp(node);
    }

    private void insertFixUp(RedBlackNode node) {
        /**
         * 判断父节点
         */
        if (node.parent == null) {
            node.color = RedBlackNode.Color.Black;
            this.root = node;
            return;
        }
        if (node.parent.color == RedBlackNode.Color.Black) {
            return;
        }

        RedBlackNode uncle = getUncle(node);
        RedBlackNode grandParent = getGrandParent(node);
        RedBlackNode parent = node.parent;
        if (uncle.color == RedBlackNode.Color.Red) {
            node.parent.color = RedBlackNode.Color.Black;
            uncle.color = RedBlackNode.Color.Black;
            grandParent.color = RedBlackNode.Color.Red;
            insertFixUp(grandParent);
        } else if (node == parent.left && parent == grandParent.left) {
            parent.color = RedBlackNode.Color.Black;
            grandParent.color = RedBlackNode.Color.Red;
            rolateWithLeftChild(grandParent);
        } else if (node == parent.left && parent == grandParent.right) {
            node.color = RedBlackNode.Color.Black;
            grandParent.color = RedBlackNode.Color.Red;
//            doubleWithRightLeft(grandParent);
        } else if (node == parent.right && parent == grandParent.right) {
            parent.color = RedBlackNode.Color.Black;
            grandParent.color = RedBlackNode.Color.Red;
//            rolateWithRightChild(grandParent);
        } else {
            node.color = RedBlackNode.Color.Black;
            grandParent.color = RedBlackNode.Color.Red;
//            doubleWithLeftChild(grandParent);
        }
    }

    /**
     * ---------->>>>>>>>>>>>>拿到子节点和父节点
     * ---------->>>>>>>>>>>>>>>关注节点
     * ---------->>>>>>>>>>>>>>>>>相应父节点的处理
     * <p>
     * LL型
     *
     * @param node
     * @return
     */
    private RedBlackNode rolateWithLeftChild(RedBlackNode node) {
        RedBlackNode parent = node.parent;
        RedBlackNode leftChild = node.left;
        node.left = leftChild.right;

        /**leftChild 右儿子非空
         */
        if (leftChild.right != NIL) {
            leftChild.right.parent = node;
        }
        // leftchid右子树确定
        leftChild.right = node;
        // node parent确定
        node.parent = leftChild;
        /**parent 处理
         */
        if (parent == null) {
            this.root = leftChild;
        } else if (node == parent.left) {
            // node是parent左子树   则leftChild取代其位置
            parent.left = leftChild;
        } else {
            parent.right = leftChild;
        }
        leftChild.parent = parent;
        return leftChild;
    }


    /**
     * RR型
     *
     * @param node
     * @return
     */
    private RedBlackNode rolateWithRightChild(RedBlackNode node) {
        RedBlackNode parent = node.parent;
        RedBlackNode rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != NIL) {
            rightChild.left.parent = node;
        }
        rightChild.left = node;

        node.parent = rightChild;

        if (parent == null) {
            this.root = rightChild;
        } else if (node == parent.right) {
            parent.right = rightChild;
        } else {
            parent.left = rightChild;
        }
        rightChild.parent = parent;
        return rightChild;


    }

    private RedBlackNode getUncle(RedBlackNode node) {
        RedBlackNode grandParent = getGrandParent(node);
        if (grandParent == null) {
            return null;
        }
        if (node.parent == grandParent.left) {
            return grandParent.right;
        }
        return grandParent.left;
    }

    private RedBlackNode getGrandParent(RedBlackNode node) {
        if (node.parent == null) {
            return null;
        }
        return node.parent.parent;
    }

    public boolean contains(RedBlackNode node, RedBlackNode root) {
        if (root == NIL) {
            return false;
        }
        while (node.value != root.value) {
            if (node.value > root.value) {
                root = root.right;
            }
            if (node.value < root.value) {
                root = root.left;
            }
            if (root == NIL) {
                return false;
            }
        }
        return true;
    }
}
