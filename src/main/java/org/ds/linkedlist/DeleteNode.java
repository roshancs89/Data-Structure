package org.ds.linkedlist;

import org.ds.linkedlist.Node;



public class DeleteNode {

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    Node head;

    /**
     * This program inserts node at the beginning of list
     * @param new_data - new Node value
     */
    public void push(int new_data){
        Node newNode = new Node(new_data);

        newNode.next = this.head;

        this.head = newNode;
    }

    /**
     * Prints the elements of LinkedList
     */
    public void printList(){

        Node prevNode = this.head;

        while(prevNode != null){
            System.out.print(prevNode.data + " ");
            prevNode = prevNode.next;
        }

        System.out.println(" ");
    }

    public void deleteNode(int position){
        Node temp = this.head;

        if(position == 0){
            this.head = temp.next;
            return;
        }

        for(int i =0; temp != null && i < position-1; i++){
            temp = temp.next;
        }

        if(temp == null || temp.next == null)
            return;

        temp.next = temp.next.next;
    }

    public static void main(String args[]){
        System.out.println("Program to delete the node of linkedlist");
        DeleteNode linkedList = new DeleteNode();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.printList();
        linkedList.deleteNode(0);
        linkedList.printList();
        linkedList.push(3);
        linkedList.printList();
        linkedList.deleteNode(2);
        linkedList.printList();
        linkedList.push(2);
        linkedList.printList();
        linkedList.deleteNode(1);
        linkedList.printList();
    }
}
