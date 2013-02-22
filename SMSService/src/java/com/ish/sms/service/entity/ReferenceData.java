package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the reference data table in the database
 * 
 * @author Naren
 *
 */
@NamedQueries( { @NamedQuery(name = QueryConstants.FIND_ALL_REFERENCE_DATA, query = QueryConstants.FIND_ALL_REFERENCE_DATA_QUERY) })
@Entity
@Table(name="reference_data")
public class ReferenceData {

	@Id
	@Column(name="reference_data_id")
	private Integer id;
	
	@Column(name="reference_data_name")
	private String name;

	@Column(name="reference_data_type")
	private String type;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

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
