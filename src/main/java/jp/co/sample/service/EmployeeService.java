package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	/**
	 * @return　EmployeeRepositoryのFindallメソッド呼び出し。全従業員情報をlistでリターン
	 */
	public List<Employee> showList(){
		List<Employee> list = repository.findAll();

		return list;
	}

	
	
}
