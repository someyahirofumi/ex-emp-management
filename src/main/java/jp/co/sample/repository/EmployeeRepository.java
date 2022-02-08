package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = new BeanPropertyRowMapper<>(Employee.class);

	/**
	 * @return　入社日降順の従業員全件リスト
	 */
	public List<Employee> findAll() {
		String sql = "SELECT*FROM employees ORDER BY hire_date desc;";
		List<Employee> list = template.query(sql, EMPLOYEE_ROW_MAPPER);
		return list;
	}

	/**
	 * @param id
	 * @return　検索した従業員情報
	 */
	public Employee load(Integer id) {
		String sql = "SELECT * FROM employees WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		return employee;
	}

	/**
	 * @param employee
	 * idがnullの場合はINSERT処理、それ以外はUPDATE処理
	 */
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		if (employee.getId() == null) {
			String insertSql = "INSERT INTO employees VALUES(:id,:name,:image,:gender,:hireDate,:mailAddress,:zipCode,:address,:telephone,:salary,:characteristics,:dependentsCount);";
			template.update(insertSql, param);
		} else {
			String updateSql = "UPDATE employees "
					+ "SET name=:name,image=:image,gender=:gender,hire_date=:hireDate,mail_address=:mailAddress,zip_code=:zipCode,address=:address,telephone=:telephone,salary=:salary,characteristics=:characteristics,dependents_count=:dependentsCount "
					+ "WHERE id=:id;";
			template.update(updateSql, param);
		}
	}

}
