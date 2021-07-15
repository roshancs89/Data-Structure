package org.ds.linkedlist;

public class NthElementFromEndOfList {
    Node head;

    public static void main(String args[]){
        System.out.println("Getting the N element from end of Linked List");
        DeleteNode linkedList = new DeleteNode();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.printList();


        NthElementFromEndOfList nthElem = new NthElementFromEndOfList();
        nthElem.head = linkedList.getHead();


        nthElem.printNthElemFromLast(3);
    }

    /**
     *
     */
    public void printNthElemFromLast(int n){
        LinkedListLength Len = new LinkedListLength();
        Len.head = this.head;
        Node temp = this.head;
        int length = Len.length();

        if(n > length-1){
            System.out.println("Nth element is greater than Lenght of List");
            return ;

        }

        for(int i = 0; i < length-n-1; i++){
            temp = temp.next;
        }

        System.out.println(temp.data);
    }
}
