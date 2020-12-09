package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//hateoas imports that make the methodOn work!!!
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//import com.sun.org.apache.xml.internal.serializer.ToUnknownStream;

@RestController
public class UserJPAResource {
	
	
	
	@Autowired
	public UserDaoService service ;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public PostRepository postrepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers()
	{
		return userRepository.findAll();
	}
	
	
	
	/* HATEOAS ENABLED IN THIS URI*/
	@GetMapping("/jpa/users/{id}")
	public EntityModel<Optional<User>> retrieveUser(@PathVariable int id)
	{
		Optional<User> user= userRepository.findById(id);

		if(!user.isPresent())
		{
			throw new UserNotFoundException("id="+id);
		}
		
		
		//return user;
		
		//HATEOAS
		//trying to get rid of the methOn error by creating a UserJPAResource object
		
		//remove this stuff if error
		
		EntityModel<Optional<User>> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOASOVER
		
		return resource;
		
		
	}
	
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Validated @RequestBody User user)
	{
		
		User savedUser = userRepository.save(user);
		
		URI location= ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	 @DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		 userRepository.deleteById(id);
		
		
		

	}
	 
	 @GetMapping("/jpa/users/{id}/posts")
		public List<Post> retrieveAllUsers(@PathVariable int id)
		{
		    Optional<User> userOptional= userRepository.findById(id);
		    
		
	    

			if(!userOptional.isPresent())
			{
				throw new UserNotFoundException("id="+id);
			}
			
			
			return userOptional.get().getPost();
			
	 	
	 	
		}
	 
	 @PostMapping("/jpa/users/{id}/posts")
		public ResponseEntity<Object> createPost(@PathVariable int id , @RequestBody Post post)
		{
		    Optional<User> userOptional= userRepository.findById(id);
		    
		
	    

			if(!userOptional.isPresent())
			{
				throw new UserNotFoundException("id="+id);
			}
			
			User user= userOptional.get();
			
			post.setUser(user);
			postrepository.save(post);
			
			URI location= ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(post.getId())
					.toUri();
			
			return ResponseEntity.created(location).build(); 
					
			
			
			
			
		}


}
