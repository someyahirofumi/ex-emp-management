package jp.co.sample.domain;

import java.util.Date;

/**
 * @author someyahirofumi
 *
 */
public class Employee {

	private Integer id;
	private String name;
	private String image;
	private String gender;
	private Date hireDate;
	private String mailAddress;
	private String zipCode;
	private String address;
	private String telephone;
	private Integer salaly;
	private String characteristics;
	private Integer dependentsCount;
	public Employee() {};
	
	public Employee(Integer id, String name, String image, String gender, Date hireDate, String mailAddress,
			String zipCode, String address, String telephone, Integer salaly, String characteristics,
			Integer dependentsCount) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.gender = gender;
		this.hireDate = hireDate;
		this.mailAddress = mailAddress;
		this.zipCode = zipCode;
		this.address = address;
		this.telephone = telephone;
		this.salaly = salaly;
		this.characteristics = characteristics;
		this.dependentsCount = dependentsCount;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getSalaly() {
		return salaly;
	}
	public void setSalaly(Integer salaly) {
		this.salaly = salaly;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public Integer getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(Integer dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender + ", hireDate="
				+ hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address=" + address
				+ ", telephone=" + telephone + ", salaly=" + salaly + ", characteristics=" + characteristics
				+ ", dependentsCount=" + dependentsCount + "]";
	}
	
	
}
