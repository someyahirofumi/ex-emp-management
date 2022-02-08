package jp.co.sample.form;

import javax.validation.constraints.NotBlank;

/**
 * @author someyahirofumi
 *
 */
public class UpdateEmployeeForm {
	
	private String id;
	@NotBlank(message ="扶養人数を入力してください。")
	private String dependentsCount;
	public int toIntId() {
		return Integer.parseInt(id);
	}
	public int toIntDependentsCount() {
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
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}

}
