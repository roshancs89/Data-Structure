package org.ds.linkedlist;

/**
 * This class have functions to determine the
 * length of linked list
 */
public class LinkedListLength {
    Node head;


    /**
     * Iterative method to return the lenght of linked list
     * @return
     */
    public int length(){
        Node temp = this.head;
        int counter = 0;

        while(temp != null){
            counter++;
            temp = temp.next;
        }

        return counter;
    }

    private int getCount(Node head){
        if(head == null)
            return 0;

        return 1 + getCount(head.next);
    }

    public int getCount(){
        return getCount(this.head);
    }

    public static void main(String args[]){
        DeleteNode linkedList = new DeleteNode();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.printList();

        LinkedListLength Len = new LinkedListLength();
        Len.head = linkedList.getHead();
        System.out.println("Length of Linked List is "+Len.length());
        System.out.println("Lenght of Linked List recursive is "+Len.getCount());
    }


}
