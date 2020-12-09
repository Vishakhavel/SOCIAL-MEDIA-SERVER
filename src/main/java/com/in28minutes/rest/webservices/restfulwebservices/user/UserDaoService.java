	package com.in28minutes.rest.webservices.restfulwebservices.user;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User>  users = new ArrayList<>();
	private static int userscount=3;
	static
	{
		
		users.add(new User(1 , "Vichu" , new Date()));
		users.add(new User(2 , "mort" , new Date()));
		users.add(new User(3 , "slash" , new Date()));
	}
	
	public List<User> findall()
	{
		return users;
	}
	
	public User save(User user)
	{
		if(user.getId()==null)
		{
			user.setId(++userscount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id)
	{
		Iterator<User> iterator= users.iterator();
		
		while(iterator.hasNext())
		{
			User user = iterator.next();
			
			if(user.getId()==id)
			{
				iterator.remove();
				return user;
				//System.out.println("HAS BEEN DELETED");
			}
		}
		return null;
	}

}
