package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 464);
        Book effectiveJava = new Book("Effective Java", 416);
        Book grokkingAlgorithms = new Book("Grokking Algorithms", 320);
        Book designPatterns = new Book("Design Patterns", 669);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = effectiveJava;
        books[2] = grokkingAlgorithms;
        books[3] = designPatterns;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " " + book.getPages());
        }
        System.out.println("Replace Clean Code to Design Patterns");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " " + book.getPages());
        }
        System.out.println("Shown only books with name Clean Code");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean Code".equals(book.getName())) {
                System.out.println(book.getName() + " " + book.getPages());
            }
        }
    }

}
