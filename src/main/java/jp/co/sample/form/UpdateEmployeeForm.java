package jp.co.sample.form;

/**
 * @author someyahirofumi
 *
 */
public class UpdateEmployeeForm {
	
	private String id;
	private String dependentsCount;
	public int toIntId() {
		return Integer.parseInt(id);
	}
	public int toIntDepndentsCount() {
		return Integer.parseInt(dependentsCount);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDepartmentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}

}
