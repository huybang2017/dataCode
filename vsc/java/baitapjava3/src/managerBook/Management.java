package managerBook;

import book.Book;

public class Management {
    Book [] books = new Book[100];

    public Management(Book[] books) {
        this.books = books;
    }

    public Management() {
    }

    public Book findQtyMinInBook(){
        Book bookMin = null;
        int flagQty = 0;
        for(Book book: books){
            if(book.getQty() >= flagQty){
                flagQty = book.getQty();
                bookMin = book;
            }
        }
        return bookMin;
    }
}
