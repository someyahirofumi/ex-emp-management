package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {
	/**
	 * @return フォームの作成
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpForm() {
		return new InsertAdministratorForm();
	}
	
	@Autowired
	private HttpSession session;
	
	
	@ModelAttribute
	public LoginForm setUpForm2() {
		return new LoginForm();
	}
	
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	
	/**
	 * サービスクラスの宣言
	 */
	@Autowired
	private AdministratorService service;
	 
	
	/**
	 * 入力画面へ
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	/**
	 * serviceクラスからinsertメソッド呼び出し。データ登録処理
	 * @param form
	 * @return ログイン画面へリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		
		Administrator administrator = new Administrator();
		administrator.setName(form.getName());
		administrator.setMailAddress(form.getMailAddress());
		administrator.setPassword(form.getPassword());
		service.insert(administrator);
		return "redirect:/";
		
		
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		Administrator administrator= service.login(form.getMailAddress(), form.getPassword());
		if(administrator == null) {
			model.addAttribute("error","メールアドレスまたはパスワードが不正です");
			return "administrator/login";
		}else {
			session.setAttribute("administratorName", administrator.getName());
			return "forward:/employee/showlist";
		}
	}
	

}
