package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdoministratorRepository;

@Service
@Transactional
public class AdministratorService {
	
	@Autowired
	private AdoministratorRepository repository;
	
	/**
	 * @param administrator
	 * repositoryのinsertメソッド呼び出し。入力された情報の登録
	 */
	public void insert(Administrator administrator) {
		repository.insert(administrator);
		
	}
	
	/**
	 * @param mailAddress
	 * @param password
	 * @return mailAddressとpasswordをrepositoryクラスのfindByMailAddressAndPasswordメソッドに渡す。帰ってきた情報をそのままリターン（ヒット0の場合はNull
	 */
	public Administrator login(String mailAddress,String password) {
		Administrator administrator = repository.findByMailAddressAndPassword(mailAddress, password);
		return administrator;
	}
	
	

}
