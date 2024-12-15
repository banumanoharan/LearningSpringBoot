package com.example.ContentApplication.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.ContentApplication.model.Content;
import com.example.ContentApplication.model.Status;
import com.example.ContentApplication.model.Type;

@Repository
public class ContentCollectionRepository {
	private final static List<Content> contentsList = new ArrayList<>();
	static {
		Content c1 = new Content(1,"My First Title","Its Description", Status.INITIATED, Type.ARTICLE, LocalDateTime.now(),null,"");
		Content c2 = new Content(2,"My Second Title","Its Description", Status.INITIATED, Type.VIDEO, LocalDateTime.now(),null,"");
		Content c3 = new Content(3,"My Third Title","Its Description", Status.INITIATED, Type.COURSE, LocalDateTime.now(),null,"");
		contentsList.add(c1);	
		contentsList.add(c2);	
		contentsList.add(c3);	
	}
	
	public ContentCollectionRepository() { }
	
	public List<Content> findAll(){
		return contentsList;
	}
	
   public Optional<Content> findById(Integer id)
   {
	   return contentsList.stream().filter(c -> c.id().equals(id)).findFirst();
   }
   
   public void save(Content content)
    {
	   contentsList.removeIf(c->c.id().equals(content.id()));
	   contentsList.add(content);
   }

  public boolean existsById(Integer id) {
	
	return contentsList.stream().filter(c->c.id().equals(id)).count()==1;
}

public void delete(Integer id) {
	contentsList.removeIf(c->c.id().equals(id));// TODO Auto-generated method stub
	
}
}
