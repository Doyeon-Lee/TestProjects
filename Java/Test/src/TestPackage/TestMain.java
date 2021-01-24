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
		File file = new File("C:\\Users\\dyl12\\Desktop\\�ڹ� �ڷᱸ��.docx");
		String formatted = "";
		BasicFileAttributes attrs = null;
		
		String str = file.getAbsolutePath();
		
		System.out.println("���� ���: "+str) re;

		try {
			attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
			FileTime time = attrs.creationTime();
			
			String pattern = "yyyy_MM_dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			formatted = simpleDateFormat.format(new Date(time.toMillis()));
			
			System.out.println("������¥: " + new Date(time.toMillis()));
			System.out.println("�������� ǥ�� ������¥: " + formatted);

		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
