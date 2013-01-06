package com.ish.sms.web.bean;

import java.io.Serializable;

import javax.el.MethodExpression;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

import org.richfaces.component.AbstractDropDownMenu.Facets;
import org.richfaces.component.UIDropDownMenu;
import org.richfaces.component.UIMenuGroup;
import org.richfaces.component.UIMenuItem;
import org.richfaces.component.UIToolbar;

@ManagedBean(name = "menuBean")
@ViewScoped
public class MenuBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UIToolbar uiToolbar;
	/**
	 * @return the uiToolbar
	 */
	public UIToolbar getUiToolbar() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Application application = facesContext.getApplication();

		uiToolbar = (UIToolbar) application.createComponent(facesContext, UIToolbar.COMPONENT_TYPE, "org.richfaces.ToolbarRenderer");
		uiToolbar.setId("toolbarId");
		
		UIDropDownMenu uiDropDownMenu = (UIDropDownMenu) application.createComponent(facesContext, UIDropDownMenu.COMPONENT_TYPE,"org.richfaces.DropDownMenuRenderer");
		HtmlOutputText studentManagementLabel = (HtmlOutputText) application.createComponent(HtmlOutputText.COMPONENT_TYPE);
		studentManagementLabel.setValue("Student Management");
		studentManagementLabel.setId("studentManagementLabelId");
		uiDropDownMenu.getFacets().put(Facets.label.name(), studentManagementLabel);
		uiDropDownMenu.setId("studentManagementDropDownId");

		UIMenuGroup uiMenuGroup = (UIMenuGroup) application.createComponent(UIMenuGroup.COMPONENT_TYPE);
		uiMenuGroup.setLabel("Add Student");
		uiMenuGroup.setId("addstudentMenuGroupId");
		
		UIMenuItem menItm = (UIMenuItem) application.createComponent(facesContext, UIMenuItem.COMPONENT_TYPE,"org.richfaces.MenuItemRenderer");
		menItm.setLabel("Personal Details");
		Class[] params = {};
		MethodExpression me = application.getExpressionFactory().createMethodExpression(facesContext.getELContext(), "#{associateAction.initAddStudentPersonalDetails}",
				String.class, params);
		menItm.setActionExpression(me);
		menItm.setId("addpersonaldetailsId");
		uiMenuGroup.getChildren().add(menItm);
		uiDropDownMenu.getChildren().add(menItm);
		uiToolbar.getChildren().add(uiDropDownMenu);

		return uiToolbar;
	}

	/**
	 * @param uiToolbar the uiToolbar to set
	 */
	public void setUiToolbar(UIToolbar uiToolbar) {
		this.uiToolbar = uiToolbar;
	}


	public MenuBean() {
	}

}
