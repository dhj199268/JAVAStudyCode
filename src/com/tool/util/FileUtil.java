package com.tool.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
    private FileUtil(){};
	/**
	 * 转换spring的MultipartFile 到file
	 * 
	 * @user coding云 2014年6月23日
	 */
	public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		// File tmpFile = new File(System.getProperty("java.io.tmpdir") +
		// System.getProperty("file.separator") +
		// multipart.getOriginalFilename());
		File tmpFile = File.createTempFile("tmpFile", null);
		multipart.transferTo(tmpFile);
		return tmpFile;
	}

}
