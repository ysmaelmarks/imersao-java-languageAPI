package br.com.marques.languageapi;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Language, String> {

    List<Language> findAllByOrderByRankingAsc();

}
    
