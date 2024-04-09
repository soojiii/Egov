package kr.or.ddit.resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;

import org.apache.commons.io.IOUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;

import lombok.extern.slf4j.Slf4j;

/**
 * Resource : 스프링에서 자원을 표현하는 추상 타입.
 * 	- 자원의 위치와 자원에 대한 접근방법에 따른 구현체 지원
 *  1. FileSystemResource : 물리 경로
 *  2. ClassPathResurce : 클래스패스 이후의 qualified name(논리경로)을 통해 접근
 *  3. UrlResource : 웹상에 존재하는 url(논리경로)로 접근하는 자원
 *  
 *  ResourceLoader : 자원에 분류와 관계없이 일관된 방법으로 Resource 를 로딩해주는 객체.
 *  
 */
@Slf4j
public class ResourceLoaderDesc {
	public static void main(String[] args) {
		ResourceLoader loader = new ClassPathXmlApplicationContext();
		
		Resource fsRes = loader.getResource("file:F:/00.medias/another_day.txt");
		log.info("file system resource : {}", fsRes);
		Resource cpRes = loader.getResource("classpath:kr/or/ddit/MemberData.properties");
		log.info("classpath resource : {}", cpRes);
		Resource urlRes = loader.getResource("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
		log.info("url resource : {}", urlRes);
		
		File destFolder = new File("F:/00.medias");
		copeyResource(cpRes, destFolder);
		copeyResource(urlRes, destFolder);
		
	}
	private static void copeyResource(Resource src, File dsetFolder) {
		String filename = src.getFilename();
		log.info("filename : {}", filename);
		File destFile = new File(dsetFolder, filename);
		WritableResource destRes = new FileSystemResource(destFile);
		try(
			InputStream is = src.getInputStream();
			OutputStream os = destRes.getOutputStream();
		){
			IOUtils.copy(is, os);
		}catch(IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}


