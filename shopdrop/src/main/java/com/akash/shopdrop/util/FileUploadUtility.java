package com.akash.shopdrop.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH="C:\\Users\\I524851\\OneDrive - SAP SE\\Documents\\Projects\\Eclipse Projects\\Implementations\\shopdrop\\shopdrop\\shopdrop\\src\\main\\webapp\\assets\\images\\";
	
	private static String REAL_PATH="";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile (HttpServletRequest request, MultipartFile file, String code) {
		
		
		//get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		LOGGER.info(REAL_PATH);
		
		//to make sure all the directories exists
		if(!new File(ABS_PATH).exists()) {
			//Create directory
			new File(ABS_PATH).mkdirs();
		}
		
		try {
			//For server upload
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			
			//For project directory upload
			file.transferTo(new File(REAL_PATH+code+".jpg"));
		}
		catch(IOException ex) {
			LOGGER.error(ex.getMessage());
		}
	}

}
