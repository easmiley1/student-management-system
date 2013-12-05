package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the teacher table in the database
 * 
 * @author Naren
 * 
 */
@NamedQueries({ @NamedQuery(name = QueryConstants.FIND_ALL_USERS, query = QueryConstants.FIND_ALL_USERS_QUERY),
		@NamedQuery(name = QueryConstants.FIND_USER_FOR_NAME, query = QueryConstants.FIND_USER_FOR_NAME_QUERY) })
@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private UserRole userRole;

	@Column(nullable = false, name = "user_name")
	private String name;

	@Column(nullable = false, name = "password")
	private String password;

	@Column(name = "associate_access")
	private String associateAccess;

	@Column(name="user_associate_id")
	private String associateId;
	
	/**
	 * @return the associateId
	 */
	public String getAssociateId() {
		return associateId;
	}

	/**
	 * @param associateId the associateId to set
	 */
	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userRole
	 */
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the associateAccess
	 */
	public String getAssociateAccess() {
		return associateAccess;
	}

	/**
	 * @param associateAccess
	 *            the associateAccess to set
	 */
	public void setAssociateAccess(String associateAccess) {
		this.associateAccess = associateAccess;
	}
}
