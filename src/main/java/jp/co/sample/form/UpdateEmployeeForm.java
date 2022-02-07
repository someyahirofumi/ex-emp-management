package jp.co.sample.form;

/**
 * @author someyahirofumi
 *
 */
public class UpdateEmployeeForm {
	
	private String id;
	private String departmentsCount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartmentsCount() {
		return departmentsCount;
	}
	public void setDepartmentsCount(String departmentsCount) {
		this.departmentsCount = departmentsCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", departmentsCount=" + departmentsCount + "]";
	}

}
