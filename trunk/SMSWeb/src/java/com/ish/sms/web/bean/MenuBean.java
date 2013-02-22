package com.ish.sms.web.bean;

import java.io.Serializable;

import javax.el.MethodExpression;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.menubar.Menubar;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.component.toolbar.Toolbar;
import org.primefaces.component.toolbar.ToolbarGroup;

@ManagedBean(name = "menuBean")
@ViewScoped
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Toolbar uiToolbar;

	/**
	 * @return the uiToolbar
	 */
	@SuppressWarnings("rawtypes")
	public Toolbar getUiToolbar() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Application application = facesContext.getApplication();

		uiToolbar = (Toolbar) application.createComponent(Toolbar.COMPONENT_TYPE);
		uiToolbar.setId("toolbarId");
		ToolbarGroup toolbarGroup = (ToolbarGroup) application.createComponent(ToolbarGroup.COMPONENT_TYPE);
		toolbarGroup.setId("tooolbargroupd");
		toolbarGroup.setAlign("left");
		Menubar uiDropDownMenu = (Menubar) application.createComponent(facesContext, Menubar.COMPONENT_TYPE, "org.primefaces.component.MenubarRenderer");
		uiDropDownMenu.setId("someid");
		Submenu submenu = (Submenu) application.createComponent(Submenu.COMPONENT_TYPE);
		submenu.setLabel("Add Student");
		submenu.setId("addstudentMenuGroupId");

		MenuItem menItm = (MenuItem) application.createComponent(MenuItem.COMPONENT_TYPE);
		menItm.setValue("Personal Details");
		Class[] params = {};
		MethodExpression me = application.getExpressionFactory().createMethodExpression(facesContext.getELContext(),
				"#{associateAction.initAddStudentPersonalDetails}", String.class, params);
		menItm.setActionExpression(me);
		menItm.setId("addpersonaldetailsId");
		menItm.setAjax(false);
		submenu.getChildren().add(menItm);
		uiDropDownMenu.getChildren().add(submenu);
		toolbarGroup.getChildren().add(uiDropDownMenu);
		uiToolbar.getChildren().add(toolbarGroup);

		return uiToolbar;
	}

	/**
	 * @param uiToolbar
	 *            the uiToolbar to set
	 */
	public void setUiToolbar(Toolbar uiToolbar) {
		this.uiToolbar = uiToolbar;
	}

	public MenuBean() {
	}

}
