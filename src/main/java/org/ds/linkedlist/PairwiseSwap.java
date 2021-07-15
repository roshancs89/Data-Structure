package org.ds.linkedlist;

public class PairwiseSwap {

    Node head;

    public static void main(String args[]){
        DeleteNode llist = new DeleteNode();
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        llist.printList();
        PairwiseSwap swap = new PairwiseSwap();
        swap.head = llist.getHead();
        swap.pairSwapRecursive(swap.head);
        swap.printList(swap.head);
    }

    /**
     * Iterative approach
     * @param head
     */
    public void pairSwap(Node head){
        while(head != null && head.next != null){
            swap(head);
            head = head.next.next;
        }
    }

    private void swap(Node head) {
        int temp = head.next.data;
        head.next.data = head.data;
        head.data = temp;
    }

    public void printList(Node head){
        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println();
    }

    public void pairSwapRecursive(Node head){
        if(head != null && head.next != null){
            swap(head);
            pairSwapRecursive(head.next.next);
        }
    }
}
