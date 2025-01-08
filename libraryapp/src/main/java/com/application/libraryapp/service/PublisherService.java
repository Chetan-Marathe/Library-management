package com.application.libraryapp.service;

import com.application.libraryapp.entity.Publisher;
import com.application.libraryapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> FindallPublisher(){
        return publisherRepository.findAll();
    }

    public Publisher FindaPublisher(Long id){
        Publisher publisher;
        return publisher= publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void CreatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void DeletePublisher(Long id){
        Publisher publisher;
        publisher= publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        publisherRepository.deleteById(publisher.getId());
    }

    public void UpdatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }


}
