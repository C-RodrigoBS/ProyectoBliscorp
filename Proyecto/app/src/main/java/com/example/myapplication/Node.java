/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myapplication;

class Node<T, U> {
    Node<T, U> previous;
    Node<T, U> next;
    T key;
    U value;

    public Node(Node<T, U> previous, Node<T, U> next, T key, U value){
        this.previous = previous;
        this.next = next;
        this.key = key;
        this.value = value;
    }
}
