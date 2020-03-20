package com.compulsory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Document> library = new ArrayList();

    public List<Document> getLibrary() {
        return this.library;
    }

    public void addNewDocument(Document document) {
        this.library.add(document);
    }

    public Document getDocument(int index) {
        return (Document)this.library.get(index);
    }

    public Catalog() {
    }
}