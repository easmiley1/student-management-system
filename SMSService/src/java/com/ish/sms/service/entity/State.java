package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the state reference table in the database
 * 
 * @author Naren
 *
 */
@NamedQueries( { @NamedQuery(name = QueryConstants.FIND_ALL_STATES, query = QueryConstants.FIND_ALL_STATES_QUERY) })
@Entity
@Table(name="state_name_ref")
public class State extends BaseReference{

	@Id
	@Column(name="state_id")
	private Integer id;
	
	@Column(name="state_name")
	private String name;
	
	@Column(name="state_name_abbr")
	private String abbrevation;

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

	/**
	 * @return the abbrevation
	 */
	public String getAbbrevation() {
		return abbrevation;
	}

	/**
	 * @param abbrevation the abbrevation to set
	 */
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
}
