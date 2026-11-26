package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyRenamePolicy implements FileRenamePolicy{
	
	@Override
	
	public File rename(File originFile) {
		
		String originName = originFile.getName();
		
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		int randomNo  = (int)(Math.random()* 900) + 100;
		
		String changeName = "KH_" + currentTime + randomNo + ext;
		
		return new File(originFile.getParent(), changeName);
	}
	
	
	
}
