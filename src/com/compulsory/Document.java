package com.compulsory;

import java.io.Serializable;
import java.net.URL;
import java.util.Map;

public class Document implements Serializable {
    private URL url;
    private String path;
    private String type;
    private Integer id;
    private static Integer idCurrent = 0;
    private String name;
    private Map<String, String> tags;

    public String getAdres() {
        return this.type.equals("URL") ? this.url.toString() : this.path;
    }

    public Integer getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void addTag(String key, String value) {
        this.tags.put(key, value);
    }

    public Document(URL url, String name, Map<String, String> tags) {
        this.url = url;
        this.id = idCurrent = idCurrent + 1;
        this.name = name;
        this.tags = tags;
        this.path = null;
        this.type = "URL";
    }

    public Document(String path, String name, Map<String, String> tags) {
        this.path = path;
        this.id = idCurrent = idCurrent + 1;
        this.name = name;
        this.tags = tags;
        this.url = null;
        this.type = "path";
    }
}
