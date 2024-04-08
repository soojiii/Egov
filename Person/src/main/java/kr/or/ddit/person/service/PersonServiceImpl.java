package kr.or.ddit.person.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.person.dao.PersonDAO;
import kr.or.ddit.person.dao.PersonDAOImpl;
import kr.or.ddit.vo.PersonVO;

public class PersonServiceImpl implements PersonService {

	private PersonDAO dao = new PersonDAOImpl();
	
	@Override
	public List<PersonVO> retrievePersonList() {
		return dao.selectPersonList();
	}

	@Override
	public PersonVO retrievePerson(String id) throws PkNotFoundException {
		PersonVO person = dao.selectPerson(id);
		if(person==null)
			throw new PkNotFoundException(500);
		return person;
	}

	@Override
	public ServiceResult createPerson(PersonVO person) {
		ServiceResult result = null;
		if(dao.selectPerson(person.getId())==null) {
			int rowcnt = dao.insertPerson(person);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		return result;
	}

	@Override
	public ServiceResult modifyPerson(PersonVO person) throws PkNotFoundException {
		return dao.updatePerson(person) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult removePerson(String id) throws PkNotFoundException {
		return dao.deletePerson(id) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	
}
