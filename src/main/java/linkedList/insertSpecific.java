package linkedList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class insertSpecific {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException, IOException {
        while (node != null) {
            System.out.println(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        SinglyLinkedList input = new SinglyLinkedList();

        input.insertNode(11);
        input.insertNode(9);
        input.insertNode(19);
        input.insertNode(10);
        input.insertNode(4);

        int data = 20;
        int position = 2;
        
        SinglyLinkedListNode output = insertSpecificData(input.head,data,position);
        printSinglyLinkedList(output, " ");
    }

    private static SinglyLinkedListNode insertSpecificData(SinglyLinkedListNode input, int data, int position) {
        // Step 1: Iterate linked list until correct position is achieved
        int count = 0;
        SinglyLinkedListNode current = null;

        while(count != position && input.next != null) {
            current = input.next;
            count++;
        }

        // Step 2: Create temp node that list points to
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        // Step 3: point previous node to new node and have new node point to temp node
        SinglyLinkedListNode temp =  new SinglyLinkedListNode(current.next.data);
        temp.next = current.next.next;
        current.next = newNode;
        newNode.next = temp;

        return input;
    }
}
