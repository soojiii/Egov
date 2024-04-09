package kr.or.ddit.case5.person.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PersonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@RequiredArgsConstructor
public class PersonDAOImpl implements PersonDAO {
//	private final Resource cpRes;
	@javax.annotation.Resource(name = "props")
	private final Properties props;
	
	@Value("file:F:/00.medias/another_day.txt")
	private Resource fsRes;
	public void setFsRes(Resource fsRes) {
		this.fsRes = fsRes;
	}
	
	@PostConstruct
	public void init() {
//		try(
//			InputStream is = cpRes.getInputStream();
//		){
//			props.load(is);
//			log.info("주입된 리소스 : {}", cpRes);
			log.info("주입된 리소스 : {}", fsRes);
//		}catch (IOException e) {
//			throw new UncheckedIOException(e);
//		}
	}
	
	private PersonVO rawToObject(String id, String rawData) {
		String[] tokens = rawData.split("\\|");
		return new PersonVO(id, tokens[0], tokens[1], tokens[2], tokens[3]);
	}
	
	@Override
	public List<PersonVO> selectPersonList(){
		List<PersonVO> people = new ArrayList<>();
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			Object key = (Object) keys.nextElement();
			Object value = props.get(key);
			PersonVO person = rawToObject(key.toString(), value.toString());
			people.add(person);
		}
		return people;
	}
	
	@Override
	public PersonVO selectPerson(String id){
		String property = props.getProperty(id);
//		if(property!=null) {
//			return rawToObject(id, property);
//		}else {
//			return null;
//		}
		//새로운 if문
		return Optional.ofNullable(property).map((p)->rawToObject(id, p)).orElse(null);
	}
}





