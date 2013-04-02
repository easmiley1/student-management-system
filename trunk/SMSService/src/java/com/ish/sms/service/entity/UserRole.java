package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the role table in the database
 * 
 * @author Naren
 * 
 */
@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_ALL_ROLES, query = QueryConstants.FIND_ALL_ROLES_QUERY) })
@Entity
@Table(name = "role_details")

public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private Integer id;
	
	@Column(name = "role_name")
	private String roleName;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	} 

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
