package linkedList;

import java.io.IOException;

public class insertSpecificDoubly {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.println(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        // Step 1: Find position we want to add next to
        DoublyLinkedListNode current = llist;

        while(current.data < data && current.next != null) {
            // keep moving unless the next value is greater than
            if(current.next.data < data) {
                current = current.next;
            } else {
                break;
            }
        }


        // Step 2: Set temp and insert value
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        // If data is less than current data it is the new head.
        if(current.data > data) {
            current.prev = newNode;
            newNode.next = current;
            llist = newNode;
        } else {
            DoublyLinkedListNode temp = current.next;
            current.next = newNode;
            newNode.next = temp;

        }

        // Step 3: Return list
        return llist;
    }

    public static void main(String args[]) throws IOException {
        DoublyLinkedList input = new DoublyLinkedList();

        input.insertNode(2);
        input.insertNode(3);
        input.insertNode(4);
      //input.insertNode(10);

        int data = 1;

        DoublyLinkedListNode output = sortedInsert(input.head,data);
        printDoublyLinkedList(output, " ");
    }


}
