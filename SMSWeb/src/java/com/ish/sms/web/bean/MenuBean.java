package com.ish.sms.web.bean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.menubar.Menubar;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.component.toolbar.ToolbarGroup;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassListDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.service.dto.UserDetailsDTO;
import com.ish.sms.web.util.WebConstants;

@ManagedBean(name = "menuBean")
@ViewScoped
public class MenuBean implements Serializable, WebConstants {

	private static final long serialVersionUID = 1L;
	private ToolbarGroup toolbarGroup;

	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	public MenuBean() {
	}

	/**
	 * @return the toolbarGroup
	 */
	public ToolbarGroup getToolbarGroup() {
		return toolbarGroup;
	}

	/**
	 * @param toolbarGroup
	 *            the toolbarGroup to set
	 */
	public void setToolbarGroup(ToolbarGroup toolbarGroup) {
		this.toolbarGroup = toolbarGroup;
	}

	/**
	 * @return the userBean
	 */
	public UserBean getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean
	 *            the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the uiToolbar
	 */
	@PostConstruct
	public void createToolBarBasedOnRole() {

		/* Get the required data to create the menu */
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Application application = facesContext.getApplication();
		UserDetailsDTO userDetailsDTO = userBean.getUserDetailsDTO();
		ClassListDTO classListDTO = userDetailsDTO.getClassListDTO();

		/* Create Toolbar Group */
		toolbarGroup = (ToolbarGroup) application.createComponent(ToolbarGroup.COMPONENT_TYPE);
		toolbarGroup.setId(TOOLBAR_GROUP_ID);
		toolbarGroup.setAlign(LEFT_ALIGN);

		/* Create Menubar */
		Menubar menuBar = (Menubar) application.createComponent(Menubar.COMPONENT_TYPE);
		menuBar.setStyle(ZERO_PADDING);
		menuBar.setId(MENUBAR_ID);

		/* If user role - parent role */
		if (userDetailsDTO.getUserRoleDTO().getRoleName().equals(ROLE_NAME.PARENT_ROLE.name())) {
			StudentDTO studentDTO = userDetailsDTO.getStudentListDTO().getStudentDTOList().get(0);
			createParentPortalMenu(facesContext, application, studentDTO, menuBar);
		}
		/* If user role - office role */
		else if (userDetailsDTO.getUserRoleDTO().getRoleName().equals(ROLE_NAME.OFFICE_ROLE.name())) {
			createStudentManagementMenu(facesContext, application, menuBar);
			createTeacherManagementMenu(facesContext, application, menuBar);
			createClassManagementMenuForOfficeRole(facesContext, application, menuBar);
		}
		/* If user role - Teacher role */
		else if (userDetailsDTO.getUserRoleDTO().getRoleName().equals(ROLE_NAME.TEACHER_ROLE.name())) {
			TeacherDTO teacherDTO = userDetailsDTO.getTeacherDTO();
			createMyPagesMenu(facesContext, application, teacherDTO, menuBar);
			createClassMaintenanceMenu(facesContext, application, menuBar, classListDTO);
		}
		/* If user role - Admin role */
		else if (userDetailsDTO.getUserRoleDTO().getRoleName().equals(ROLE_NAME.ADMIN_ROLE.name())) {
			createStudentManagementMenu(facesContext, application, menuBar);
			createTeacherManagementMenu(facesContext, application, menuBar);
			createClassManagementMenuForOfficeRole(facesContext, application, menuBar);
			createClassMaintenanceMenu(facesContext, application, menuBar, classListDTO);
		}

		toolbarGroup.getChildren().add(menuBar);

	}

	/**
	 * @param facesContext
	 * @param application
	 * @param studentDTO
	 * @param uiDropDownMenu
	 */
	private void createMyPagesMenu(FacesContext facesContext, Application application, TeacherDTO teacherDTO, Menubar menuBar) {

		Submenu submenu = createSubMenu(application, MY_PAGES, MY_PAGES_SUBMENU_ID);
		MenuItem myScheduleMenuItem = createMenuItem(facesContext, application, MY_SCHEDULE, MY_SCHEDULE_MENU_ID, MY_SCHEDULE_ACTION + teacherDTO.getId() + CLOSE_BRACES,
				String.class, new Class[] { Integer.class });

		submenu.getChildren().add(myScheduleMenuItem);
		menuBar.getChildren().add(submenu);
	}

	/**
	 * @param facesContext
	 * @param application
	 * @param studentDTO
	 * @param uiDropDownMenu
	 */
	private void createParentPortalMenu(FacesContext facesContext, Application application, StudentDTO studentDTO, Menubar menuBar) {

		Submenu submenu = createSubMenu(application, PARENT_PORTAL, PARENT_PORTAL_SUBMENU_ID);
		MenuItem personalDetailsMenuItem = createMenuItem(facesContext, application, STUDENT_DETAILS, STUDENT_DETAILS_MENU_ID,
				STUDENT_DETAILS_ACTION_EXPR + studentDTO.getId() + CLOSE_BRACES, String.class, new Class[] { Integer.class });
		MenuItem attendanceDetailsMenuItem = createMenuItem(facesContext, application, ATTENDANCE_DETAILS, ATTENDANCE_DETAILS_MENU_ID, ATTENDANCE_DETAILS_ACTION_EXPR
				+ studentDTO.getId() + CLOSE_BRACES, String.class, new Class[] { Integer.class });
		MenuItem reportCardMenuItem = createMenuItem(facesContext, application, REPORT_CARD, REPORT_CARD_MENU_ID, REPORT_CARD_ACTION_EXPR + studentDTO.getId()
				+ CLOSE_BRACES, String.class, new Class[] { Integer.class });
		MenuItem timeTableMenuItem = createMenuItem(facesContext, application, TIME_TABLE, TIME_TABLE_SUBMENU_ID, OPEN_STUDENT_TIMETABLE_ACTION
				+ studentDTO.getCurrentClassDTO().getId() + CLOSE_BRACES, String.class, new Class[] { Integer.class });

		submenu.getChildren().add(personalDetailsMenuItem);
		submenu.getChildren().add(attendanceDetailsMenuItem);
		submenu.getChildren().add(reportCardMenuItem);
		submenu.getChildren().add(timeTableMenuItem);
		menuBar.getChildren().add(submenu);
	}

	/**
	 * @param facesContext
	 * @param application
	 * @param menuBar
	 */
	private void createStudentManagementMenu(FacesContext facesContext, Application application, Menubar menuBar) {

		Submenu submenu = createSubMenu(application, STUDENT_MANAGEMENT, STUDENT_MANAGEMENT_SUBMENU_ID);
		MenuItem addStudentDetailsMenuItem = createMenuItem(facesContext, application, ADD_STUDENT_DETAILS, ADD_STUDENT_DETAILS_MENU_ID, ADD_STUDENT_DETAILS_ACTION,
				String.class, new Class[] {});
		MenuItem modifyStudentMenuItem = createMenuItem(facesContext, application, MODIFY_STUDENT, MODIFY_STUDENT_MENU_ID, MODIFY_STUDENT_ACTION, String.class,
				new Class[] {});
		MenuItem viewStudentMenuItem = createMenuItem(facesContext, application, VIEW_STUDENT, VIEW_STUDENT_MENU_ID, VIEW_STUDENT_ACTION, String.class, new Class[] {});

		submenu.getChildren().add(addStudentDetailsMenuItem);
		submenu.getChildren().add(modifyStudentMenuItem);
		submenu.getChildren().add(viewStudentMenuItem);
		menuBar.getChildren().add(submenu);

	}

	/**
	 * @param facesContext
	 * @param application
	 * @param menuBar
	 */
	private void createTeacherManagementMenu(FacesContext facesContext, Application application, Menubar menuBar) {

		Submenu submenu = createSubMenu(application, TEACHER_MANAGEMENT, TEACHER_MANAGEMENT_SUBMENU_ID);
		MenuItem addTeacherDetailsMenuItem = createMenuItem(facesContext, application, ADD_TEACHER_DETAILS, ADD_TEACHER_DETAILS_MENU_ID, ADD_TEACHER_DETAILS_ACTION,
				String.class, new Class[] {});
		MenuItem modifyTeacherMenuItem = createMenuItem(facesContext, application, MODIFY_TEACHER, MODIFY_TEACHER_MENU_ID, MODIFY_TEACHER_ACTION, String.class,
				new Class[] {});
		MenuItem viewTeacherMenuItem = createMenuItem(facesContext, application, VIEW_TEACHER, VIEW_TEACHER_MENU_ID, VIEW_TEACHER_ACTION, String.class, new Class[] {});

		submenu.getChildren().add(addTeacherDetailsMenuItem);
		submenu.getChildren().add(modifyTeacherMenuItem);
		submenu.getChildren().add(viewTeacherMenuItem);
		menuBar.getChildren().add(submenu);

	}

	/**
	 * @param facesContext
	 * @param application
	 * @param menuBar
	 */
	private void createClassManagementMenuForOfficeRole(FacesContext facesContext, Application application, Menubar menuBar) {

		Submenu submenu = createSubMenu(application, CLASS_MANAGEMENT, CLASS_MANAGEMENT_SUBMENU_ID);
		MenuItem addClassDetailsMenuItem = createMenuItem(facesContext, application, ADD_CLASS_DETAILS, ADD_CLASS_DETAILS_MENU_ID, ADD_CLASS_DETAILS_ACTION,
				String.class, new Class[] {});
		MenuItem modifyClassMenuItem = createMenuItem(facesContext, application, MODIFY_CLASS_DETAILS, MODIFY_CLASS_DETAILS_MENU_ID, MODIFY_CLASS_DETAILS_ACTION,
				String.class, new Class[] {});

		submenu.getChildren().add(addClassDetailsMenuItem);
		submenu.getChildren().add(modifyClassMenuItem);
		menuBar.getChildren().add(submenu);

	}

	/**
	 * @param facesContext
	 * @param application
	 * @param menuBar
	 */
	private void createClassMaintenanceMenu(FacesContext facesContext, Application application, Menubar menuBar, ClassListDTO classListDTO) {

		Submenu classManagementSubmenu = createSubMenu(application, CLASS_MAINTENANCE, CLASS_MAINTENANCE_SUBMENU_ID);
		Submenu attendanceRegisterSubmenu = createClassManagementIterativeMenu(facesContext, application, classListDTO, ATTENDANCE_REGISTER,
				ATTENDANCE_REGISTER_SUBMENU_ID, OPEN_REGISTER_ID, OPEN_REGISTER_ACTION);
		Submenu timeTableSubmenu = createClassManagementIterativeMenu(facesContext, application, classListDTO, TIME_TABLE, TIME_TABLE_SUBMENU_ID, OPEN_TIMETABLE_ID,
				OPEN_TIMETABLE_ACTION);
		Submenu gradeBookSubmenu = createClassManagementIterativeMenu(facesContext, application, classListDTO, GRADE_BOOK, GRADE_BOOK_SUBMENU_ID, GRADE_BOOK_ID,
				GRADE_BOOK_ACTION);
		MenuItem classPromotionsMenuItem = createMenuItem(facesContext, application, CLASS_PROMOTIONS, CLASS_PROMOTIONS_MENU_ID, CLASS_PROMOTIONS_ACTION, String.class,
				new Class[] {});

		Submenu reportsSubmenu = createSubMenu(application, REPORTS, REPORTS_SUBMENU_ID);
		MenuItem attendanceReportsMenuItem = createMenuItem(facesContext, application, ATTENDANCE_REPORTS, ATTENDANCE_REPORTS_MENU_ID, ATTENDANCE_REPORTS_ACTION,
				String.class, new Class[] {});
		reportsSubmenu.getChildren().add(attendanceReportsMenuItem);

		classManagementSubmenu.getChildren().add(attendanceRegisterSubmenu);
		classManagementSubmenu.getChildren().add(timeTableSubmenu);
		classManagementSubmenu.getChildren().add(gradeBookSubmenu);
		classManagementSubmenu.getChildren().add(classPromotionsMenuItem);
		classManagementSubmenu.getChildren().add(reportsSubmenu);
		menuBar.getChildren().add(classManagementSubmenu);
	}

	/**
	 * @param facesContext
	 * @param application
	 * @param classListDTO
	 * @param subMenu
	 * @param subMenuId
	 * @param menuItemName
	 * @param menuItemdid
	 * @return subMenu
	 */
	private Submenu createClassManagementIterativeMenu(FacesContext facesContext, Application application, ClassListDTO classListDTO, String subMenu, String subMenuId,
			String menuItemName, String menuItemdid) {

		Submenu submenu = createSubMenu(application, subMenu, subMenuId);

		int i = 0;
		for (ClassDTO classDTO : classListDTO.getClassDTOList()) {

			MenuItem menuItem = createMenuItem(facesContext, application, classDTO.getName(), menuItemName + i, menuItemdid + classDTO.getId() + CLOSE_BRACES,
					String.class, new Class[] { Integer.class });
			submenu.getChildren().add(menuItem);
			i++;

		}
		return submenu;
	}

	/**
	 * @param facesContext
	 * @param application
	 * @param label
	 * @param id
	 * @param methodExpressionStr
	 * @param returnType
	 * @param argTypes
	 * @return menuItem
	 */
	private MenuItem createMenuItem(FacesContext facesContext, Application application, String label, String id, String methodExpressionStr, Class<?> returnType,
			Class<?>[] argTypes) {

		MenuItem menuItem = (MenuItem) application.createComponent(MenuItem.COMPONENT_TYPE);
		menuItem.setValue(label);
		MethodExpression methodExpression = application.getExpressionFactory().createMethodExpression(facesContext.getELContext(), methodExpressionStr, returnType,
				argTypes);
		menuItem.setActionExpression(methodExpression);
		menuItem.setId(id);
		menuItem.setAjax(false);
		return menuItem;
	}

	/**
	 * @param application
	 * @param label
	 * @param id
	 * @return submenu
	 */
	private Submenu createSubMenu(Application application, String label, String id) {
		Submenu submenu = (Submenu) application.createComponent(Submenu.COMPONENT_TYPE);
		submenu.setLabel(label);
		submenu.setId(id);
		return submenu;
	}

	public static void main(String args[]) throws Exception{
		FileOutputStream fileOut = new FileOutputStream("employee.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(new MenuBean());
		out.close();
		fileOut.close();
		
		FileInputStream fileIn = new FileInputStream("employee.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		in.readObject();
		fileIn.close();
	}

	int i;

	MenuBean(int i) {
		this.i = i;
	}

	public int hashCode() {
		System.out.println("hashCode " + i);
		return i;
	}

	public boolean equals(Object object) {
		if (i == ((MenuBean) object).i) {
			return true;
		}
		System.out.println("equals " + i);
		return false;
	}

	private void writeObject(ObjectOutputStream aOutputStream) throws IOException {
		System.out.println("write object");
		// perform the default serialization for all non-transient, non-static fields
		aOutputStream.defaultWriteObject();
	}

	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
		System.out.println("read object");
		// always perform the default de-serialization first
		aInputStream.defaultReadObject();
	}

}
