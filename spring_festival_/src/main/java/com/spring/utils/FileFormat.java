package com.spring.utils;

public class FileFormat {
	
	public static String generate(String fileFormat) {
		String icon = "file";
		
		switch(fileFormat) {	
			case "doc":case "docx": icon="doc"; break;
			case "ppt":case "pptx": icon="ppt"; break;
			case "xlsx": case "xls": case "csv": icon="xls"; break;
			case "hwp": icon="hwp"; break;
			case "zip": icon="zip"; break;
			case "pdf": icon="pdf"; break;			
		}
		return icon;
	}

}
