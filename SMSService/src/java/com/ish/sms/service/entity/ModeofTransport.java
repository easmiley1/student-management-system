package com.ish.sms.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ish.sms.service.util.QueryConstants;

/**
 * This entity represents the ModeofTransport reference table in the database
 * 
 * @author Naren
 *
 */
@NamedQueries( { @NamedQuery(name = QueryConstants.FIND_ALL_MODEOFTRANSPORTS, query = QueryConstants.FIND_ALL_MODEOFTRANSPORTS_QUERY) })
@Entity
@Table(name="mode_of_transport_ref")
public class ModeofTransport extends BaseReference{

	@Id
	@Column(name="mode_of_transport_id")
	private Integer id;
	
	@Column(nullable=false, name="mode_of_transport")
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
