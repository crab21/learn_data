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
        Nodes nodes7 = new Nodes(9);
        Nodes nodes8 = new Nodes(10);
        Nodes nodes9 = new Nodes(11);
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
        nodes9.setNext(nodes5);

        /* printList(head);*/
//        head = reverse(head);
        isLoop(head);
        findJoin(head);
        cirCount1();
        calcuateLength(head);
//        printList(head);
//        findJoin(head);
//        int nodesLength = getNodesLength(head);
//        System.out.println(nodesLength);
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

            System.out.println(slow.getData() + "...slow");
            System.out.println(fast.getData());
            if (slow == fast) {
                System.out.println("存在环情况...");
                System.out.println(fast.getData() + ".....相遇点位置");
                return;
            }
            slow = slow.getNext();

            fast = fast.getNext().getNext();
        }
        System.out.println("不存在环的情况....");
    }

    static Nodes pos;
    static Nodes join;


    /**
     * 寻找环的入口
     */
    public static Nodes findJoin(Nodes head) {
        Nodes fast = head, slow = head;
        while (slow != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (slow == fast) break;
        }
        if (slow == null || fast.getNext() == null) {
            System.out.println("没有环");
            return null;
        }
        pos = slow;
        Nodes node = slow;
        Nodes start = head;
        while (node != start) {
            System.out.println("相遇点值变化.." + node.getData());
            node = node.getNext();
            System.out.println("起始点点值变化.." + start.getData());
            start = start.getNext();
        }
        join = start;
        System.out.println("入口点" + join.getData());
        return start;
    }


    /**
     * 计算环上点的个数 方法1
     */
    public static int cirCount1() {
        int count = 1;
        Nodes nodes = join.getNext();
        while (nodes != join) {
            nodes = nodes.getNext();
            count++;
        }
        System.out.println("换上节点的个数：" + count);
        return count;
    }

    /**
     * 计算环上点的个数 方法2
     */
    public static int cirCount2() {
        int count = 1;
        Nodes fast = pos.getNext().getNext();
        Nodes slow = pos.getNext();
        while (fast != slow) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            count++;
        }
        return count;
    }

    /**
     * 计算头节点到环入口的长度、计算链表长度
     */
    public static void calcuateLength(Nodes head) {
        int count = 0;
        for (Nodes nodes = head; nodes != join; nodes = nodes.getNext(), ++count) ;
        System.out.println("节点到环入口长度：" + count);
        int listCount = count + cirCount1();
        System.out.println("链表长度：" + listCount);
    }
}
