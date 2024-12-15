package com.example.ContentApplication.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.ContentApplication.exception.ResourceNotFoundException;
import com.example.ContentApplication.model.Content;

import com.example.ContentApplication.repository.ContentCollectionRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ContentController {
	/*private ContentCollectionRepository repository;
	
	public ContentController()
	{
	 repository = new ContentCollectionRepository();
	}

	public ContentController(ContentCollectionRepository repository)
	{
	 this.repository = repository;
	}*/
	
	/*private final ContentCollectionRepository repository;
	
	public ContentController(ContentCollectionRepository repository)
	{
	 this.repository = repository;
	}*/
	
	
	@Autowired
	private ContentCollectionRepository repository;
	
	@GetMapping("/")
	public String getMessage()
	{
		return "Content Application!!";
	}
	
	@GetMapping("/api/content")
	public List<Content> findAll()
	{
		return repository.findAll();
	}
	
	@GetMapping("/api/content/{id}")
	public Content findById(@PathVariable Integer id)
	{
		return repository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Requested Id is not found!"));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/content")
	public void createElement(@Valid @RequestBody Content content) {
		 repository.save(content);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/api/content/{id}")
	public void updateElement(@RequestBody Content content, @PathVariable Integer id)
	{
		if(!repository.existsById(id))
			throw new ResourceNotFoundException("Requested Id is not found!");
		repository.save(content);
	}
	
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	@DeleteMapping("/api/content/{id}")
	public void deleteElement(@PathVariable Integer id)
	{
		repository.delete(id);
	}
}
