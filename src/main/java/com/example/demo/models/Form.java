package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Document(collection = "forms")
public class Form {

    @Id
    private String id;
    private String title;
    private String description;
    private List<Field> fields;
    private boolean published;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        if (fields != null) {
            Set<String> fieldNames = new HashSet<>();
            for (Field field : fields) {
                if (field.getId() == null || field.getId().isEmpty()) {
                    field.setId(UUID.randomUUID().toString());
                }
                if (!fieldNames.add(field.getName())) {
                    throw new IllegalArgumentException("Field names must be unique within a form.");
                }
            }
        }
        this.fields = fields;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
    }