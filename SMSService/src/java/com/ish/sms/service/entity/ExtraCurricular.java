package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the Extra curricular reference table in the database
 * 
 * @author Naren
 *
 */
@NamedQueries( { @NamedQuery(name = QueryConstants.FIND_ALL_EXTRACURRICULAR, query = QueryConstants.FIND_ALL_EXTRACURRICULAR_QUERY) })
@Entity
@Table(name="extra_curricular_interest_ref")
public class ExtraCurricular extends BaseReference{

	@Id
	@Column(name="extra_curricular_interest_ref_id")
	private Integer id;
	@Column(nullable=false, name="extra_curricular_interest")
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
