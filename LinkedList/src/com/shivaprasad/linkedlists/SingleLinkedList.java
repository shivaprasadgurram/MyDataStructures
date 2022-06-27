package com.shivaprasad.linkedlists;



public class SingleLinkedList {

    Node head;
    static int size = 0;
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val  = val;
        }
    }
    public static void main(String[] args) {

        SingleLinkedList obj = new SingleLinkedList();
        obj.head = new Node(1);
        size++;
        Node second = new Node(2);
        size++;
        Node third = new Node(3);
        size++;
        Node four = new Node(4);
        size++;

        obj.head.next = second;
        second.next = third;
        third.next = four;

        System.out.println("===================================");
        System.out.println("Initial Data: ");
        obj.printList();
        System.out.println("===================================");

        System.out.println("InsertAtBeginning: ");
        obj.insertAtBeginning(7);
        obj.printList();
        System.out.println("===================================");

        System.out.println("InsertAtEnd: ");
        obj.insertAtEnd(12);
        obj.printList();
        System.out.println("===================================");

        System.out.println("InsertAtGivenPosition: ");
        obj.insertAtGivenPosition(56,4);
        obj.printList();
        System.out.println("===================================");
    }

    //Print the Linked List
     void printList() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.val+ " ");
            currNode = currNode.next;
        }
        System.out.println("\nCurrent size: " + size);
        System.out.println("Current head: " + head.val);
    }

    //Insert a node at beginning
    void insertAtBeginning(int val) {
        Node new_node = new Node(val);
        if(head == null) {
            head = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;
        size++;
    }

    //Insert a node at end
    void insertAtEnd(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
        } else {
            Node currNode = head;
            while (currNode.next!=null) {
                currNode = currNode.next;
            }
            currNode.next = node;
        }
        size++;
    }

    //Insert a node at given position
    void insertAtGivenPosition(int val, int position) {
        if(position < 0 || position > size) return;
        Node node = new Node(val);
        Node currNode = head;
        for(int i=0;i<position-1;i++) {
            currNode = currNode.next;
        }
        Node temp = currNode.next;
        currNode.next = node;
        node.next = temp;
        size++;
    }
}
