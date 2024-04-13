package kr.or.ddit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import lombok.extern.slf4j.Slf4j;


@SpringJUnitWebConfig(locations = "classpath:kr/or/ddit/case2/conf/*-context.xml")
public abstract class AbstractModelContextTest {



}
