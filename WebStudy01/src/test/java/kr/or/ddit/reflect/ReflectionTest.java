package kr.or.ddit.reflect;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class ReflectionTest {

	@Test
	void test() {
		Class instanceType = member.getClass();
		Field[] fields = instanceType.getDeclaredFields();
		for(Field fld : fields) {
			if(paramName.equals(fld.getName())) {
	//			member.setMemId("a001");
	//			member[paramName]=paramValue;
				try {
					PropertyDescriptor pd = new PropertyDescriptor(paramName,instanceType);
					
					pd.getWriteMethod().invoke(member, paramValue);
					Object propValue = pd.getReadMethod().invoke(member);
					System.out.printf("%s : %s\n", pd.getName(), propValue);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				break;
			}
		}
	}

}
