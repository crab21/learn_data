package com.example.algorithm.LinkedList;

public class NodeDemo {
    public static void main(String[] args) {
        Nodes head = new Nodes(1);
        Nodes nodes = new Nodes(2);
        Nodes nodes1 = new Nodes(3);
        Nodes nodes2 = new Nodes(4);
        Nodes nodes3 = new Nodes(5);
        Nodes nodes4 = new Nodes(6);
        Nodes nodes5 = new Nodes(7);
        Nodes nodes6 = new Nodes(8);
        Nodes nodes7 = new Nodes(5);
        Nodes nodes8 = new Nodes(6);
        Nodes nodes9 = new Nodes(7);
        Nodes nodes10 = new Nodes(8);
        head.setNext(nodes);
        nodes.setNext(nodes1);
        nodes1.setNext(nodes2);
        nodes2.setNext(nodes3);
        nodes3.setNext(nodes4);
        nodes4.setNext(nodes5);
        nodes5.setNext(nodes6);
        nodes6.setNext(nodes7);
        nodes7.setNext(nodes8);
        nodes8.setNext(nodes9);

        /* printList(head);*/
//        head = reverse(head);
        isLoop(head);
        printList(head);
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
     *
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

    /**
     * 判断是否有环
     */
    public static void isLoop(Nodes head) {
        Nodes slow = head, fast = head;
        if (slow == null) return;
        if (fast.getNext() == null) return;
        slow = slow.getNext();
        fast = fast.getNext().getNext();
        while (fast != null) {

            System.out.println(slow.getData()+"...slow");
            System.out.println(fast.getData());
            if (slow == fast) {
                System.out.println("存在环情况...");
                return;
            }
            slow = slow.getNext();

            fast = fast.getNext().getNext();
        }
        System.out.println("不存在环的情况....");
    }
}
