package com.criatosoft.email.serviceimpl;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.criatosoft.email.entities.EmailSender;
import com.criatosoft.email.repository.EmailReposiotry;
import com.criatosoft.email.servicei.EmailServicei;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailServiceImpl implements EmailServicei{

	@Autowired
	private EmailReposiotry emailReposiotry;
	@Autowired
	private JavaMailSender mailsender;
	
	@Value("${spring.mail.username}")
	String username;
		
	@Override
	public String sendEmail(MultipartFile photo, MultipartFile pan, String data) {
		
		MimeMessage mm = mailsender.createMimeMessage();
		
		try {
			ObjectMapper om = new ObjectMapper();
			EmailSender readV = om.readValue(data, EmailSender.class);
			
			readV.setSender(username);
			
			readV.setPhoto(photo.getBytes());
			readV.setPan(pan.getBytes());
			
			emailReposiotry.save(readV);
			
			MimeMessageHelper mmh = new MimeMessageHelper(mm,true);
			
			mmh.setTo(readV.getReceiver());
			mmh.setFrom(readV.getReceiver());
			mmh.setSubject(readV.getSubject());
			mmh.setText(readV.getMessage());
			mmh.addAttachment(photo.getOriginalFilename(), photo);
			mmh.addAttachment(pan.getOriginalFilename(),pan);
			mailsender.send(mm);
			
			return "Mail send SuccessFully....";
			
		} catch (Exception e) {
				e.printStackTrace();
				return "Email sending fail";
		}	
	}

}
