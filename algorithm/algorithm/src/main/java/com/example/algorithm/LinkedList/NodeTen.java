package com.example.algorithm.LinkedList;

/**
 * Created by k on 2018/10/5.
 */
public class NodeTen {
    MyNode head = null;

    /**
     * 具体的节点信息
     */
    class MyNode {
        MyNode next = null;
        int data;

        public MyNode(int data) {
            this.data = data;
        }
    }

    /**
     * 具体的实现部分
     */

    public void addNode(int d) {
        MyNode myNode = new MyNode(d);
        if (head == null) {
            head = myNode;
            return;
        }
        MyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = myNode;
    }


    /**
     * 删除第几个节点：
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }

        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        MyNode preNode = head;
        MyNode curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            ++i;
        }
        return false;
    }

    /**
     * 计算链表长度
     *
     * @return
     */
    public int length() {
        int length = 0;
        MyNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 在不知道头指针情况下删除指定节点
     */
    public boolean delNode(MyNode node) {
        if (node == null || node.next == null)
            return false;
        int temp = node.data;
        node.data = node.next.data;
        node.next.data = temp;
        node.next = node.next.next;
        System.out.println("删除成功");
        return true;
    }

    /**
     * 打印链表
     */

    public void printNode() {
        MyNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * 链表反转
     */

    public MyNode resverMyNode(MyNode node) {
        MyNode preRever = head;
        MyNode pNode = head;
        MyNode prev = null;
        while (pNode != null) {
            MyNode nodeNext = pNode.next;
            if (nodeNext == null) {
                preRever = pNode;
            }
            pNode.next = prev;
            prev = pNode;
            pNode = nodeNext;
        }
        this.head = prev;
        return this.head;
    }


    public void deleteDuplecate(MyNode node) {
        MyNode p = node;
        while (p != null) {
            MyNode q = p;
            while (q.next != null) {
                if (p.data == q.next.data) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    /**
     * 采用递归输出链表
     *
     * @param args
     */
    public void printRecursive(MyNode node) {
        if (node != null) {
            System.out.println(node.data);
            printRecursive(node.next);
        }
    }

    public static void main(String[] args) {
        NodeTen nodeTen = new NodeTen();
        nodeTen.addNode(1);
        nodeTen.addNode(12);
        nodeTen.addNode(1223);
        nodeTen.addNode(12224);
        nodeTen.addNode(12224);
        nodeTen.addNode(122225);
        nodeTen.addNode(1222226);
        /*System.out.println("链表长度：" + nodeTen.length());
        System.out.println("head.data:" + nodeTen.head.data);
        nodeTen.printNode();
        nodeTen.deleteNode(3);
        System.out.println("After del 4 node:");
        nodeTen.printNode();
        nodeTen.resverMyNode(nodeTen.head);
        nodeTen.deleteDuplecate(nodeTen.head);
        nodeTen.printNode();*/
        nodeTen.printRecursive(nodeTen.head);
    }
}
