package linkedList;

import java.util.Stack;

public class reverseDoubly {
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

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.println(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        // Step 1: We want to add in stack
        Stack<Integer> temp = new Stack<>();
        DoublyLinkedList newList = new DoublyLinkedList();
        DoublyLinkedListNode current = llist;
        temp.add(current.data);
        while(current.next != null) {
            current = current.next;
            temp.push(current.data);
        }

        // Step 2: Iterate stack and add again to linked list
        while (!temp.empty()){
            int value = temp.pop();
            newList.insertNode(value);
        }

        return newList.head;
    }


    public static void main(String args[]) {
        DoublyLinkedList input = new DoublyLinkedList();

        input.insertNode(17);
        input.insertNode(20);
        input.insertNode(23);
        input.insertNode(35);
        input.insertNode(47);

        DoublyLinkedListNode llist = reverse(input.head);
        printDoublyLinkedList(llist, " ");
    }


}
