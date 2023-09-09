package com.criatosoft.user.app.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.criatosoft.user.app.entities.User;
import com.criatosoft.user.app.exceptions.ResourseNotFoundException;
import com.criatosoft.user.app.repositories.UserRepository;
import com.criatosoft.user.app.servicei.UserServicei;

@Service
public class UserServiceimpl implements UserServicei{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplet;
	
//	@Autowired
//	private Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceimpl.class);
	
	@Override
	public User createUser(User user) {
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public  User getUser(String userId) {
		User user =  userRepository.findById(userId)
				.orElseThrow(()-> new ResourseNotFoundException
						("UserId not found on server...!!"));
		// fetch rating data from rating service
		String url = "http://localhost:6063/ratings/users/d4b12486-8df7-4886-a003-62ea6d2246db";
//		ArrayList arrayobject =  restTemplet.getForObject(url, ArrayList.class);
//		logger.info("", arrayobject);
		return user;
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public User updateUser(String userId, User user) {
		return userRepository.save(user);
	}

}
