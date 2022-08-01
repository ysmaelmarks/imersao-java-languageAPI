package br.com.marques.languageapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    
    @Autowired
    private Repository repository;

    @GetMapping("/world")
    public String returnWorld() {
        return "Hello World";
    }
    //retorna as linguagens por ordem de ranking
    @GetMapping("/ranking")
    public List<Language> getLanguages() {
        return repository.findAllByOrderByRankingAsc();
    }


    @GetMapping("/languages")
    public List<Language> returnLanguages() {
        List<Language> languages = repository.findAll();
        return languages;
    }

    @PostMapping("/languages")
    public Language createLanguage(@RequestBody Language language) {
        repository.save(language);
        return language;
    }

    @PutMapping("/languages/{id}")
    public Language updateLanguage(@RequestBody Language language, @RequestParam String id) {
        Language languageToUpdate = repository.findById(id).get();
        languageToUpdate.setTitle(language.getTitle());
        languageToUpdate.setImage(language.getImage());
        languageToUpdate.setRanking(language.getRanking());
        repository.save(languageToUpdate);
        return languageToUpdate;
    }

    @DeleteMapping("/languages/{id}")
    public void deleteLanguage(@RequestParam String id) {
        repository.deleteById(id);
    }



}
