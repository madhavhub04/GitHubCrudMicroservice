package com.criatosoft.friends.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.criatosoft.friends.entities.Friends;
import com.criatosoft.friends.repositories.FriendsRepository;
import com.criatosoft.friends.servicei.FriendsServicei;

@Service
public class FriendsServiceimpl implements FriendsServicei{

	@Autowired
	private JavaMailSender sender;
	@Autowired
	private FriendsRepository friendsRepository;
	@Override
	public Friends addNewFriend(Friends friend) {
//		String randomId = UUID.randomUUID().toString();
//		friend.setId(randomId);
		Friends fsave = friendsRepository.save(friend);
		return fsave;
	}

	@Override
	public List<Friends> getAll() {
		List<Friends> fAll = friendsRepository.findAll();
		return fAll;
	}

	@Override
	public Friends getSingleF(String id) {
		Optional<Friends> findById = friendsRepository.findById(id);
		Friends fri = findById.get();
		
		return fri;
	}

	@Override
	public void deleteOne(String id) {
		friendsRepository.deleteById(id);	
	}

	@Override
	public void sendMailWithAttachment(MultipartFile photo, Friends f) {
		
		MimeMessage mm = sender.createMimeMessage();
		try {
		
			MimeMessageHelper mmh = new MimeMessageHelper(mm,true);
			
			mmh.setTo(f.getTo());
			mmh.setFrom(f.getFromm());
			mmh.setSubject(f.getSubject());
			mmh.setText(f.getMessage());
			mmh.addAttachment(photo.getOriginalFilename(), photo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sender.send(mm);
			
	}

	@Override
	public void saveMailDetails(Friends f) {
		
		friendsRepository.save(f);
	}
	

}
