package br.com.marques.languageapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "majorlanguages")
public class Language {

    @Id
    private String id;
    private String title;
    private String image;
    private Integer ranking;

    public void setTitle(String title) {
        this.title = title;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    public Language(String title, String image, Integer ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public Integer getRanking() {
        return ranking;
    }

    public String getId() {
        return id;
    }
    
}
