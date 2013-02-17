package com.ish.sms.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ish.sms.service.dto.AssociateAttendanceDTO;
import com.ish.sms.service.dto.ClassAttendanceDefDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.web.bean.ClassBean;
import com.ish.sms.web.service.dto.AttendanceMap;

@ManagedBean(name = "classAction")
@RequestScoped
public class ClassAction extends BaseAction {

	private static final long serialVersionUID = 917148070535856940L;
	@ManagedProperty(value = "#{classBean}")
	private ClassBean classBean = new ClassBean();

	/**
	 * @return the classBean
	 */
	public ClassBean getClassBean() {
		return classBean;
	}

	/**
	 * @param classBean
	 *            the classBean to set
	 */
	public void setClassBean(ClassBean classBean) {
		this.classBean = classBean;
	}

	public String createAttendanceBean(Integer classId) throws Exception {

		ClassDTO classDTO = classBusiness.retrieveClassForId(classId);
		classBean.setCurrentClass(classDTO);
		List<ClassAttendanceDefDTO> targetClassAttendanceDefDTOList = classBusiness.retrieveClassAttenDefStringList(classBean.getCurrentClass().getId());
		classBean.initMaintainClassAttendanceDef(targetClassAttendanceDefDTOList);

		String name = "name";
		classBean.getAttendanceRegisterBean().getAttendanceList().clear();
		for (int n = 0; n < 30; n++) {
			AssociateAttendanceDTO attendanceDTO = new AssociateAttendanceDTO();
			AttendanceMap<String, Boolean> attendanceMap = new AttendanceMap<String, Boolean>();
			List<String> columnNames = new ArrayList<String>();
			for (int i = 1; i < 30; i++) {
				String day = "" + i + "/" + 1;
				columnNames.add(day);
				attendanceMap.put(day, i % 2 == 0 ? true : false);
			}
			attendanceDTO.setName(name + " " + n);
			attendanceDTO.setAttendanceMap(attendanceMap);
			classBean.getAttendanceRegisterBean().setColumnNames(columnNames);
			classBean.getAttendanceRegisterBean().getAttendanceList().add(attendanceDTO);
		}

		return MODIFY_CLASS_ATTENDANCE_PAGE;
	}

	public void submitMaintainClassAttendanceDef() throws Exception {

		List<ClassAttendanceDefDTO> modifiedClassAttendanceDefDTOList = classBean.getModifiedClassAttedanceDefList();
		if (modifiedClassAttendanceDefDTOList.size() > 0)
			modifiedClassAttendanceDefDTOList = classBusiness.updateClassAttendanceDefList(modifiedClassAttendanceDefDTOList);
		classBean.getAttendanceRegisterBean().setClassAttendanceDefDTOList(modifiedClassAttendanceDefDTOList);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Save Successful", "Register changes saved successfully"));
	}

}
