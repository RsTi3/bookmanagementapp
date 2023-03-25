package org.alterra.data;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class Books {
    private static Books instance = new Books();
    private ArrayList<Book> books;

    private Books() {
        this.books = new ArrayList<>();
    }

    public static Books getInstance() {
        return instance;
    }

    public JSONObject setBook(String title, String author, String category) {
        JSONObject response = new JSONObject();
        Book book = new Book(title, author, category);
        books.add(book);
        response.put("id", book.getID());
        response.put("title", title);
        response.put("author", author);
        response.put("category", category);
        return response;
    }

    public List<JSONObject> getBooks() {
        List<JSONObject> responses = new ArrayList<>();
        for (Book book : books) {
            JSONObject response = new JSONObject();
            response.put("id", book.getID());
            response.put("title", book.getJudul());
            response.put("author", book.getPenulis());
            response.put("category", book.getKategori());
            responses.add(response);
        }
        return responses;
    }

    public JSONObject getBookById(String Id) {
        JSONObject response = new JSONObject();
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getID().equals(Id)) {
                response.put("id", book.getID());
                response.put("title", book.getJudul());
                response.put("author", book.getPenulis());
                response.put("category", book.getKategori());
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            response.put("message", "book not found!");
        }
        return response;
    }

    public JSONObject updateBook(String id, String title, String author, String category) {
        JSONObject response = new JSONObject();
        boolean bookFound = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID().equals(id)) {
                books.get(i).setJudul(title);
                books.get(i).setPenulis(author);
                books.get(i).setKategori(category);
                response.put("id", id);
                response.put("title", title);
                response.put("author", author);
                response.put("category", category);
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            response.put("message", "book not found!");
        }
        return response;
    }

    public JSONObject deleteBook(String Id) {
        JSONObject response = new JSONObject();
        Iterator<Book> iterator = books.iterator();
        boolean bookFound = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getID().equals(Id)) {
                iterator.remove();
                response.put("message", "book successfully deleted");
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            response.put("message", "book not found!");
        }
        return response;
    }

}
