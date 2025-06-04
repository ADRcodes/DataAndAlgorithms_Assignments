package com.example.assignment3;

public class Main {
    public static void main(String[] args) {
        SingleLinkedListTest sll = new SingleLinkedListTest();
        sll.insertLinkedList(100,0);
        sll.insertLinkedList(200,1);
        sll.insertLinkedList(300,2);
        sll.insertLinkedList(400,3);
        sll.insertLinkedList(500,4);
        sll.insertLinkedList(600,5);
        sll.traverseLinkedList();
        sll.searchNode(300);
        sll.deleteNode(3);
        sll.traverseLinkedList();

    }
}