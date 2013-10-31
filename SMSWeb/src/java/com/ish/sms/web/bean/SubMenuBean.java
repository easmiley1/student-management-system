package com.ish.sms.web.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean class representing submenu
 * 
 * @author Naren
 *
 */
public class SubMenuBean {


	private String label ;
	
	private String id;
	
	private List<SubMenuBean> subMenuBeanList = new ArrayList<SubMenuBean>();
	

	/**
	 * @return the subMenuBeanList
	 */
	public List<SubMenuBean> getSubMenuBeanList() {
		return subMenuBeanList;
	}

	/**
	 * @param subMenuBeanList the subMenuBeanList to set
	 */
	public void setSubMenuBeanList(List<SubMenuBean> subMenuBeanList) {
		this.subMenuBeanList = subMenuBeanList;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
