package com.company;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Menambahkan 9 ke dalam tree");
        bst.insert(9, "sembilan");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nMenambahkan 4 ke dalam tree");
        bst.insert(4, "empat");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nMenambahkan 17 ke dalam tree");
        bst.insert(17, "tujuh belas");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nMenambahkan 3 ke dalam tree");
        bst.insert(3, "tiga");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nMenambahkan 6 ke dalam tree");
        bst.insert(6, "enam");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nMenambahkan 22 ke dalam tree");
        bst.insert(22, "dua puluh dua");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nMenambahkan 100 ke dalam tree");
        bst.insert(100, "seratus");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nMenambahkan 7 ke dalam tree");
        bst.insert(7, "tujuh");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nMenambahkan 20 ke dalam tree");
        bst.insert(20, "dua puluh");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nMenghapus 4 dari dalam tree");
        bst.remove(4);
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("Mengupdate value dari 20 dari 'dua puluh' menjadi 'dua nol'");
        bst.update(20, "dua nol");
        new BinaryTreePrinter(bst.getRoot()).print(System.out);
        System.out.println();

        System.out.println("\nNilai terendah di dalam tree: " + bst.findMinNode().getKey());
        System.out.println("Nilai tertinggi di dalam tree: " + bst.findMaxNode().getKey());
        System.out.println();

        System.out.println("Apakah 4 ada di dalam tree? " + bst.isPresent(4));
        System.out.println("Apakah 3 ada di dalam tree? " + bst.isPresent(3));
        System.out.println();



        System.out.println("tinggi cabang minimum: " + bst.findMinHeight(bst.getRoot()));
        System.out.println("tinggi cabang maksimum: " + bst.findMaxHeight(bst.getRoot()));
        System.out.println("Apakah tree seimbang (selisih tinggi cabang minimum dengan maksimum <= 1): " + bst.isTreeBalaced());

    }
}
