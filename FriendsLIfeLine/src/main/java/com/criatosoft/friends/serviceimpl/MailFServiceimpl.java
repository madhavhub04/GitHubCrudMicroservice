package com.criatosoft.friends.serviceimpl;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.criatosoft.friends.entities.MailFriends;
import com.criatosoft.friends.repositoreis.MailFRepository;
import com.criatosoft.friends.servicei.MailServicei;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MailFServiceimpl implements MailServicei{

	
	@Autowired
	private MailFRepository mailReposiotry;
	
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public String sendMail(MultipartFile photo, String data) {
		
		MimeMessage mm = sender.createMimeMessage();
		try {
			   
			ObjectMapper om = new ObjectMapper();
			MailFriends send = om.readValues(photo, MailFriends.class);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
	}

}
