package com.compulsory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ExternalCatalog externalCatalog = new ExternalCatalog();
        externalCatalog.view(new Document("G:\\Faculta\\A2S2\\PA\\Lab5\\input\\test.txt", "This", new HashMap()));
        externalCatalog.load("G:\\Faculta\\A2S2\\PA\\Lab5\\input\\test.txt");
        externalCatalog.load("G:\\Faculta\\A2S2\\PA\\lab_05.pdf");

        try {
            externalCatalog.load(new URL("https://profs.info.uaic.ro/~acf/java/labs/lab_05.html"));
        } catch (MalformedURLException malURL) {
            malURL.printStackTrace();
        }

        externalCatalog.getCatalog().getDocument(0).addTag("TagKey", "TagVal");
        externalCatalog.view(externalCatalog.getCatalog().getDocument(2));
        externalCatalog.save("G:\\Faculta\\A2S2\\PA\\Lab5\\output");
    }
}
