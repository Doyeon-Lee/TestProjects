package TestPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\dyl12\\Desktop\\자바 자료구조.docx");
		String formatted = "";
		BasicFileAttributes attrs = null;
		
		String str = file.getAbsolutePath();
		
		System.out.println("절대 경로: "+str) re;

		try {
			attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
			FileTime time = attrs.creationTime();
			
			String pattern = "yyyy_MM_dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			formatted = simpleDateFormat.format(new Date(time.toMillis()));
			
			System.out.println("생성날짜: " + new Date(time.toMillis()));
			System.out.println("형식지정 표현 생성날짜: " + formatted);

		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
