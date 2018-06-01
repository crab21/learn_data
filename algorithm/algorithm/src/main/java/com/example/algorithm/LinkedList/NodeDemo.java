package com.example.algorithm.LinkedList;

public class NodeDemo {
    public static void main(String[] args) {
        Nodes head = new Nodes(1);
        Nodes nodes = new Nodes(2);
        Nodes nodes1 = new Nodes(3);
        Nodes nodes2 = new Nodes(4);
        Nodes nodes3 = new Nodes(5);
        Nodes nodes4 = new Nodes(6);
        head.setNext(nodes);
        nodes.setNext(nodes1);
        nodes1.setNext(nodes2);
        nodes2.setNext(nodes3);
        nodes3.setNext(nodes4);
       /* printList(head);
        head = reverse(head);
        printList(head);*/
        int nodesLength = getNodesLength(head);
        System.out.println(nodesLength);
    }

    private static void printList(Nodes head) {
        while (head != null) {
            System.out.println(head.getData() + "---");
            head = head.getNext();
        }
        System.out.println("遍历完成");
    }

    private static Nodes reverse(Nodes head) {
        if (head == null || head.getNext() == null)
            return head;
        Nodes pre = reverse(head.getNext());
        System.out.println(head.getData() + ">>>>>>>>>>>>>");
        head.getNext().setNext(head);
        head.setNext(null);
        return pre;
    }

    /**
     * 获取链表长度
     * @param head
     * @return
     */
    public static int getNodesLength(Nodes head) {
        int size = 0;
        while (head.getNext() != null) {
            size += 1;
            head = head.getNext();
        }
        return size;
    }
}
