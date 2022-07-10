package com.shivaprasad.linkedlists;

public class DoubleLinkedList {

    static DLLNode head;
    static int size = 0;
    public static class DLLNode {
        private int data;
        private DLLNode prevNode;
        private DLLNode nextNode;

        public DLLNode(int data) {
            this.data = data;
        }

        public DLLNode(int data, DLLNode prevNode, DLLNode nextNode) {
            this.data = data;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public DLLNode getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(DLLNode prevNode) {
            this.prevNode = prevNode;
        }

        public DLLNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(DLLNode nextNode) {
            this.nextNode = nextNode;
        }
    }
    public static void main(String[] args) {

        DLLNode first = new DLLNode(5);
        size++;
        head = first;
        DLLNode second = new DLLNode(8);
        size++;
        DLLNode third = new DLLNode(6);
        size++;
        DLLNode fourth = new DLLNode(1);
        size++;

        head.nextNode = second;
        second.prevNode = head;
        second.nextNode = third;
        third.prevNode = second;
        third.nextNode = fourth;
        fourth.prevNode = third;


        printList();
        insertAtBeginning(9);
        printList();
        insertAfterGivenNode(third, 89);
        printList();
        insertAtEnd(63);
        printList();
        deleteTheFirstNode();
        printList();
        deleteTheLastNode();
        printList();
        deleteTheGivenNode(third);
        printList();

    }

   static  void printList() {
        DLLNode curr = head;
        System.out.print("\n");
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.nextNode;
        }

       System.out.print("\nCurrent Head: " + head.data);
       System.out.print("\nCurrent Size: " + size);
       System.out.print("\n===============================");
    }

    static void insertAtBeginning(int data) {
        DLLNode node = new DLLNode(data);
        node.nextNode = head;
        if(head != null)
            head.prevNode = node;
        head = node;
        size++;
    }

    static void insertAfterGivenNode(DLLNode prev, int data) {
        DLLNode node = new DLLNode(data);

        if(prev == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        node.nextNode = prev.nextNode;
        prev.nextNode = node;
        node.prevNode = prev;

        if(node.nextNode != null)
            node.nextNode.prevNode = node;

        size++;
    }

    static void insertAtEnd(int data) {
        DLLNode node = new DLLNode(data);
        DLLNode curr = head;
        if(curr == null) {
            head = node;
        } else {
            while(curr.nextNode != null) {
                curr = curr.nextNode;
            }
            curr.nextNode = node;
            node.prevNode = curr;
        }
        size++;
    }

    static void deleteTheFirstNode() {
        if(head == null)
            return;
        DLLNode temp = head.nextNode;
        head.prevNode = null;
        head.nextNode = null;
        head = temp;
        size--;
    }

    static void deleteTheLastNode() {
        if(head == null)
            return;
        DLLNode curr = head;
        while(curr.nextNode != null) {
            curr = curr.nextNode;
        }

        curr.prevNode.nextNode = null;
        size--;
    }

    static void deleteTheGivenNode(DLLNode node) {
        if(node == null)
            return;

        node.prevNode.nextNode = node.nextNode;
        node.nextNode = null;
        size--;
    }
}
