package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the blood group reference table in the database
 * 
 * @author Naren
 *
 */
@NamedQueries( { @NamedQuery(name = QueryConstants.FIND_ALL_BLOODGROUPS, query = QueryConstants.FIND_ALL_BLOODGROUPS_QUERY) })
@Entity
@Table(name="blood_group_ref")
public class BloodGroup extends BaseReference{

	@Id
	@Column(name="blood_group_id")
	private Integer id;
	
	@Column(name="blood_group_name")
	private String name;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
