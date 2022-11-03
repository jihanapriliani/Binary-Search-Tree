package com.company;

// class binary search tree berisi operasi-operasi/method search tree
public class BinarySearchTree {
    private Node root;

//  root getter
    public Node getRoot() {
        return root;
    }

//    root setter
    public void setRoot(Node root) {
        this.root = root;
    }

    //    constructor
    BinarySearchTree() {
        this.root = null;
    }

//    method yang digunakan untuk memasukkan node baru ke dalam tree
    void insert(int key, String value) {
        Node node = this.root;
        if (node == null) {
            this.root = new Node(key, value);
            return;
        } else {
            searchTree(node, key, value);
        }
    }

//    method rekursif yang digunakan untuk mencari posisi node yang nanti akan dimasukkan sekaligus menyisipkan node baru
    void searchTree(Node node, int key, String value) {
        if(key < node.getKey()) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(key, value));
                return;
            } else if (node.getLeft() != null) {
                searchTree(node.getLeft(), key, value);
                return;
            }
        } else if (key > node.getKey()) {
            if (node.getRight() == null) {
                node.setRight(new Node(key, value));
                return;
            } else if (node.getRight() != null) {
                searchTree(node.getRight(), key, value);
                return;
            }
        } else {
           return;
        }
    }

//    method untuk mencari  node terkecil (paling kiri)
    Node findMinNode() {
        Node pointer = this.root;
        while (pointer.getLeft() != null) {
            pointer = pointer.getLeft();
        }
        return pointer;
    }

//   method untuk mencari node terbesar (paling kanan)
    Node findMaxNode() {
        Node pointer = this.root;
        while (pointer.getRight() != null) {
            pointer = pointer.getRight();
        }
        return pointer;
    }

//    method untuk mengecek apakah node dengan key yang dicari ada di dalam tree
    boolean isPresent(int key) {
        Node pointer = this.root;
        while (pointer != null) {
            if (key == pointer.getKey()) {
                return true;
            }

            if (key < pointer.getKey()) {
                pointer = pointer.getLeft();
            } else {
                pointer = pointer.getRight();
            }
        }

        return false;
    }

//    method untuk menghapus node
    void remove(int key) {
        this.root = removeNode(this.root, key);
    }

//    method rekursif untuk mencari posisi node yang dihapus sekaligus menghapusnya
    Node removeNode(Node node, int key) {
        if (node == null) return null;

        if (key == node.getKey()) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }

            if (node.getLeft() == null) {
                return node.getRight();
            }

            if (node.getRight() == null) {
                return node.getLeft();
            }

            Node temp = node.getRight();
            while (temp.getLeft() != null) {
                temp = temp.getLeft();
            }

            node.setKey(temp.getKey());
            node.setValue(temp.getValue());
            node.setRight(removeNode(node.getRight(), temp.getKey()));
            return node;
        } else if (key < node.getKey()) {
            node.setLeft(removeNode(node.getLeft(), key));
            return node;
        } else {
            node.setRight(removeNode(node.getRight(), key));
            return node;
        }
    }

//    method untuk mengupdate value dari node berdasarkan key yang dicari
    void update(int key, String value) {
       this.root = updateNodeValue(this.root, key, value);
    }

//method rekursif untuk mencari node sekaligus mengupdate valuenya
    Node updateNodeValue(Node node, int key, String value) {
        if (key == node.getKey()) {
            node.setValue(value);
            return node;
        } else if (key < node.getKey()) {
            node.setLeft(updateNodeValue(node.getLeft(), key, value));
            return node;
        } else {
            node.setRight(updateNodeValue(node.getRight(), key, value));
            return node;
        }
    }


//    method yang digunakan untuk mengecek apakah tree seimbang atau tidak (ruas kanan dan kiri)
    boolean isTreeBalaced() {
        return (this.findMinHeight(this.root) >= this.findMaxHeight(this.root) - 1);
    }

//    method yang digunakan untuk menghitung panjang cabang terpendek dari tree
    int findMinHeight(Node node) {
        if (node == null) return -1;

        int left = this.findMinHeight(node.getLeft());
        int right = this.findMinHeight(node.getRight());
        if (left < right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

//    method untuk menghitung panjang cabang terpanjang dari tree
    int findMaxHeight(Node node) {
        if (node == null) return -1;

        int left = this.findMaxHeight(node.getLeft());
        int right = this.findMaxHeight(node.getRight());
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }


}
