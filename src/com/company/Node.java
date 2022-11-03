package com.company;


public class Node {
    private int key;
    private String value;
    private Node left, right;

    Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
