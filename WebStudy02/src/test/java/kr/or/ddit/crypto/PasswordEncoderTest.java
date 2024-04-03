package kr.or.ddit.crypto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class PasswordEncoderTest {

	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	@Test
	void tesEncrypt() {
		String plain = "java";
		String encoded = encoder.encode(plain);
		log.info("encoded : {}", encoded);
		
	}

	@Test
	void testMatches() {
		String savedPass = "{bcrypt}$2a$10$ImfGgR9WF9nccrJnHIJ86uscyUfwNoaoAwN4/T8JT0RoqvhGpDUH.";
		String inputPass = "java";
		log.info("인증 성공 여부 : {}", encoder.matches(inputPass, savedPass));
		
	}
	
}
