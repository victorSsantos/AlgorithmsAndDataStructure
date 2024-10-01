package com.leetcode.datastructures;

public class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public void push(T data){
        Node<T> newNode = new Node<>(data); //cria novo node
        newNode.next = top; //add referencia no novo node para o antigo topo
        top = newNode; // atualiza o topo com o novo node
    }

    public T pop(T data){
        T poppedData = top.data; // valor removido é o topo da pilha
        top = top.next; // Topo agora é o proximo valor da pilha
        return poppedData;
    }

    private static class Node<T> {
        T data; //conteudo do node
        Node<T> next; // referencia para o proximo node

        public Node(T data) {
            this.data = data;
        }
    }
}

