package com.compulsory;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

public class ExternalCatalog {
    private Catalog catalog = new Catalog();

    public ExternalCatalog() {
    }

    public Catalog getCatalog() {
        return this.catalog;
    }

    public void save(String path) {
        Iterator docIterator = this.catalog.getLibrary().iterator();

        while(docIterator.hasNext()) {
            Document document = (Document)docIterator.next();

            try {
                FileOutputStream fos = new FileOutputStream(document.getName() + document.getId() + ".ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(document);
                oos.close();
                fos.close();
            } catch (IOException excIO) {
                excIO.printStackTrace();
            }
        }

    }

    public void load(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            String[] split = path.split("\\\\");
            Document document = new Document(path, split[split.length - 1], new HashMap());
            this.catalog.addNewDocument(document);
            fileReader.close();
        } catch (FileNotFoundException excFNF) {
            System.err.print("Invalid path! ");
            excFNF.printStackTrace();
        } catch (IOException excIO) {
            excIO.printStackTrace();
        }

    }

    public void load(URL url) {
        Document document = new Document(url, url.toString().split("\\\\\\\\")[url.toString().split("\\\\\\\\").length - 1], new HashMap());
        this.catalog.addNewDocument(document);
    }

    public void view(Document document) {
        Desktop desktop = Desktop.getDesktop();
        if (document.getType().equals("path")) {
            File file = new File(document.getAdres());

            try {
                desktop.open(file);
            } catch (IOException excIO) {
                excIO.printStackTrace();
            }
        } else {
            try {
                desktop.browse((new URL(document.getAdres())).toURI());
            } catch (URISyntaxException | IOException exc) {
                exc.printStackTrace();
            }
        }

    }
}

