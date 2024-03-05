package kr.or.ddit.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *	스트림(stream)
 *		: 연속성을 지닌 순차적인 일련의 데이터 집합이면서, 데이터 집합이 이동하는 단방향 통로.
 * 
 *	스트림의 분류
 *	1. 전송 데이터의 크기
 * 		1) 1 byte : byte stream , ~~~In[Out]putStream
 * 			FileInputStream/ FileOutputStream
 * 			ByteArrayInputStream/ ByteArrayOutputStream
 * 			SocketInputStream/ SocketOutputStream
 * 
 * 		2) 2 byte (1 char) : character stream, ~~~Reader[Writer]
 *			StringReader/ StringWriter 
 *
 *	2. 스트림 생성 방법과 필터링 여부에 따른 분류
 *		1) 1차 스트림 : 매체에 직접 연결
 *			ex) FileInputStream
 *		2) 2차 스트림(연결형 스트림) : 1차 스트림에 연결형으로 생성되는 스트림.
 *			ex) BufferedInputStream, BufferedWriter
 * 
 *	스트림 사용 단계
 *	1. media(매체)를 객체화
 *		ex) new File(), new byte[], Socket.open
 *	2. media 종류에 따른 입출력 스트림 개방
 *		ex) new FileInputStream(media)/FileReader(media)
 *	--(optional) 2차 스트림으로 전송 효율을 높일 수 있음.
 * 	3. 전송크기에 따라 전송데이터의 끝(EOF : -1, null)까지 반복적인 i(read..)/o(writer..) 작업 수행
 *	4. media release 단계 (close)
 */
public class StreamDesc {
	public static void main(String[] args) throws IOException {
//		readEngString_byteStream();
//		readEngString_charStream();
//		readKorString_charStream();
//		readKorString_tryWithResource();
//		readAndWriteKorString_tryWithResource();
		readAndWriteKorString_copy();
	}

	private static void readAndWriteKorString_copy() throws IOException {
		File readFile = new File("F:/00.medias/ETA_ANSI.txt");
		File writeFile = new File("F:/ETA_ANSI.txt");
		
		try(
			FileInputStream is = new FileInputStream(readFile);
			BufferedInputStream bis = new BufferedInputStream(is);
			
			FileOutputStream os = new FileOutputStream(writeFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);	
				
			) {
			int readByte = -1;
			while((readByte=bis.read())!=-1) { //EOF 문자 : -1, null
				bos.write(readByte);
			}
		}
		
	}

	private static void readAndWriteKorString_tryWithResource() throws IOException {
		File readFile = new File("F:/00.medias/ETA_ANSI.txt");
		File writeFile = new File("F:/ETA_ANSI.txt");
		
		try(
			FileInputStream fis = new FileInputStream(readFile);
			InputStreamReader isr = new InputStreamReader(fis, "ms949");
			BufferedReader reader = new BufferedReader(isr);
				
			FileWriter writer = new FileWriter(writeFile);
			BufferedWriter bw = new BufferedWriter(writer);
			){
			String readStr = null;
			while((readStr = reader.readLine())!=null) {
				System.out.println(readStr);
				bw.write(String.format("%s\n", readStr));
			}
		}
	}

	private static void readKorString_tryWithResource() throws IOException {
		File txtFile = new File("F:/00.medias/ETA_ANSI.txt");
//		try(Closable 객체 선언문 - finally 내부에서 close 되는 객체) {}
		try(
			FileInputStream fis = new FileInputStream(txtFile);
			InputStreamReader isr = new InputStreamReader(fis, "ms949");
			BufferedReader reader = new BufferedReader(isr);	
		) {
			String readStr = null;
			while((readStr = reader.readLine())!=null) {
				System.out.println(readStr);
			}
		}
		
	}

	private static void readKorString_charStream() throws IOException {
		File txtFile = new File("F:/00.medias/ETA_ANSI.txt");
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		
		try {
			fis = new FileInputStream(txtFile);
			isr = new InputStreamReader(fis, "ms949");
			reader = new BufferedReader(isr);
			String readStr = null;
			while((readStr = reader.readLine())!=null) {
				System.out.println(readStr);
			}
		}finally {
			if(fis!=null)
				fis.close();
			if(isr!=null)
				isr.close();
			if(reader!=null)
				reader.close();
		}
	}

	private static void readEngString_charStream() throws IOException {
		File txtFile = new File("F:/00.medias/another_day.txt");
		FileReader fr = new FileReader(txtFile);
		BufferedReader reader = new BufferedReader(fr);
		String readStr = null;
		while((readStr = reader.readLine())!=null) {
			System.out.println(readStr);
		}
		fr.close();
		reader.close();
	}

	private static void readEngString_byteStream() throws IOException {
		File txtFile = new File("F:/00.medias/another_day.txt");
		FileInputStream fis = new FileInputStream(txtFile);
		BufferedInputStream bis = new BufferedInputStream(fis);
		int readByte = -1;
		while((readByte = bis.read())!=-1) {
			System.out.print((char) readByte);
		}
		fis.close();
		bis.close();
	}
}
