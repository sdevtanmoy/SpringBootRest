/**
 * 
 */
package me.aboullaite.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author tanmoydas
 *
 */
@Document(collection = "jwt_users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6950350952668667317L;
	
	@Id
	private String id;

	@NotNull
	@Indexed(direction = IndexDirection.ASCENDING)
	@Field("user_id")
	private String userId;
	
	@Field("passwd")
	private String passwd;
	
	@Field("user_fname")
	private String userFname;
	
	@Field("user_lname")
	private String userLname;
	
	@Field("active_flag")
	private String activeFlag;
	
	@Field("roles")
	private List<String> roles;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Field("create_time")
	private Date createTime;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", passwd=" + passwd + ", userFname=" + userFname
				+ ", userLname=" + userLname + ", activeFlag=" + activeFlag + ", roles=" + roles + ", createTime="
				+ createTime + "]";
	}
	
	
}
