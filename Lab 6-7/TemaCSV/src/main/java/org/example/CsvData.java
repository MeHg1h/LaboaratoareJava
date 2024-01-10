package org.example;

import java.util.List;

public class CsvData implements Comparable<CsvData> {
    private int id;
    private String question;
    private String articleIds; // Assuming article_ids contains a list of integers
    private String category;
    private String subcategory;
    private String extraDescription;

    // Constructor
    public CsvData(int id, String question, String articleIds, String category, String subcategory, String extraDescription) {
        this.id = id;
        this.question = question;
        this.articleIds = articleIds;
        this.category = category;
        this.subcategory = subcategory;
        this.extraDescription = extraDescription;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getArticleIds() {
        return articleIds;
    }

    public void setArticleIds(String articleIds) {
        this.articleIds = articleIds;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "CsvData{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", articleIds=" + articleIds +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", extraDescription='" + extraDescription + '\'' +
                '}';
    }

    @Override
    public int compareTo(CsvData other) {
        return Integer.compare(this.id, other.id);
    }
}