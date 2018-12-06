package com.example.algorithm.binaryNode;

/**
 * Created by k on 2018/8/14.
 */
public class NodeBinaImpl implements NodeTree {


    @Override
    public boolean insert(NodeBina root, Object data) {
        NodeBina nodeBina = new NodeBina(data);
        if (root == null) {
            root = nodeBina;
            return true;
        } else {
            NodeBina current = root;
            NodeBina parentNode = null;
            while (current != null) {
                parentNode = current;
                if ((int) current.getData() > (int) data) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parentNode.setLeftChild(nodeBina);
                        return true;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parentNode.setRightChild(nodeBina);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void preOrder(NodeBina nodeBina) {
        if (nodeBina != null) {
            System.out.println(nodeBina.getData() + "---");
            preOrder(nodeBina.getLeftChild());
            preOrder(nodeBina.getRightChild());

        }
    }

    private void infixOrder(NodeBina root) {
        if (root != null) {
            infixOrder(root.getLeftChild());
            System.out.println(root.getData());
            infixOrder(root.getRightChild());
        }
    }

    public NodeBina findNode(NodeBina nodeBina, Object data) {
        while (nodeBina != null) {
            if ((int) data < (int) nodeBina.getData()) {
                nodeBina = nodeBina.getLeftChild();
            } else if ((int) data > (int) nodeBina.getData()) {
                nodeBina = nodeBina.getRightChild();
            } else {
                return nodeBina;
            }
        }
        return null;
    }
}
