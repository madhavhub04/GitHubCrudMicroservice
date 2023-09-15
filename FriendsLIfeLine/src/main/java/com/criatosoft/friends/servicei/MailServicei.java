package com.criatosoft.friends.servicei;

import org.springframework.web.multipart.MultipartFile;

public interface MailServicei {

	String sendMail(MultipartFile photo, String data);

}
