package com.criatosoft.email.servicei;

import org.springframework.web.multipart.MultipartFile;

public interface EmailServicei {

	String sendEmail(MultipartFile photo, MultipartFile pan, String data);


}
