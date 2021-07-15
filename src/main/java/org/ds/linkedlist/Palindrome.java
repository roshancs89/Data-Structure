package org.ds.linkedlist;

import java.util.Stack;

public class Palindrome {
    Node head;

    public static void main(String args[]){
        DeleteNode delNode = new DeleteNode();
        delNode.push(1);
        delNode.push(2);
        delNode.push(3);
        delNode.push(4);
        delNode.push(2);
        delNode.push(1);

        delNode.printList();
        Palindrome palindrome = new Palindrome();
        palindrome.head = delNode.getHead();
        System.out.println("Given Node is palindrome "+palindrome.isPalindrome(palindrome.head));
    }

    public boolean isPalindrome(Node head){
        Stack<Integer> numStack = new Stack<Integer>();

        Node temp = head;

        while(temp != null){
            numStack.push(temp.data);
            temp = temp.next;
        }

        while(head != null){
            int reverseElm = numStack.pop();
            if(head.data != reverseElm){
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
