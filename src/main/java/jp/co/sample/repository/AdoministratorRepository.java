package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository


public class AdoministratorRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER= (rs,i)->{
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mailAddress"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};
	
	public void insert(Administrator administrator) {
		SqlParameterSource param= new BeanPropertySqlParameterSource(administrator);
		if(administrator.getId() == null) {
			String InsertSql ="INSERT INTO administrators(name,mail_address,password) VALUES(:name,:mailAddress,:password);";
			template.update(InsertSql, param);
		}else {
			String UpdateSql="UPDATE administrators set name=:name,mail_address=:mailAddress,password=:password WHERE id=:id;";
			template.update(UpdateSql, param);		}
		
	}
	
	public Administrator findByMailAddressAndPassword(String mailAddress,String password) {
		String sql ="SELECT * FROM adminsitrators WHERE mail_addres=:mailAddress AND password=:password;";
		SqlParameterSource param =new MapSqlParameterSource().addValue("mailAddress",mailAddress).addValue("password",password);
		Administrator administrator =template.queryForObject(sql, param, ADMINISTRATOR_ROW_MAPPER);
		try {
			return administrator;
		}catch(Exception e) {
			return null;
		}
				
				
	}
	
	

}
