package com.company;

import java.io.PrintStream;

// class khusus yang dibuat untuk mencetak bst ke dalam konsol dengan metode penelusuran preOrder
public class BinaryTreePrinter {

    private Node tree;

    BinaryTreePrinter(Node tree) {
        this.tree = tree;
    }

//    method yang digunakan untuk menelusuri setiap node, dimulai dari root
    String traversePreOrder(Node root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(root.getKey() + ",v: " + root.getValue());

        String pointerRight = "└── r ── ";
        String pointerLeft = (root.getRight() != null) ? "├── l ── " : "└── l ── ";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

//    method rekursif yang digunakan untuk menelusuri setiap node, setelah root
    void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getKey() + ",v: " + node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└── r ── ";
            String pointerLeft = (node.getRight() != null) ? "├── l ── " : "└── l ── ";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }


    void print(PrintStream os) {
        os.print(traversePreOrder(this.tree));
    }

}
