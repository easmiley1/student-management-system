package com.ish.sms.web.bean;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassTimeTableDTO;
import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.web.util.WebUtils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Bean class to hold all the class details in session scope.
 * 
 * @author enselv
 * 
 */
@ManagedBean(name = "classBean")
@SessionScoped
public class ClassBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private List<TimeTableBean> timeTableBeanList = new ArrayList<TimeTableBean>();

	private ClassDTO classDTO = new ClassDTO();

	private List<Integer> classYearList = new ArrayList<Integer>();

	/**
	 * @return the classYearList
	 */
	public List<Integer> getClassYearList() {
		return classYearList;
	}

	/**
	 * @param classYearList
	 *            the classYearList to set
	 */
	public void setClassYearList(List<Integer> classYearList) {
		this.classYearList = classYearList;
	}

	/**
	 * @return the classDTO
	 */
	public ClassDTO getClassDTO() {
		return classDTO;
	}

	/**
	 * @param classDTO
	 *            the classDTO to set
	 */
	public void setClassDTO(ClassDTO classDTO) {
		this.classDTO = classDTO;
	}

	/**
	 * @return the timeTableBeanList
	 */
	public List<TimeTableBean> getTimeTableBeanList() {
		return timeTableBeanList;
	}

	/**
	 * @param timeTableBeanList
	 *            the timeTableBeanList to set
	 */
	public void setTimeTableBeanList(List<TimeTableBean> timeTableBeanList) {
		this.timeTableBeanList = timeTableBeanList;
	}

	public void populateTimeTableGrid() {

		getTimeTableBeanList().clear();
		for (ClassTimeTableDTO classTimeTableDTO : classDTO.getClassTimeTableDTOList()) {
			List<TimeTableBean> timeTableBeanList = getTimeTableBeanList();
			if (timeTableBeanList.size() > 0) {
				boolean foundDay = false;
				for (TimeTableBean timeTableBean : timeTableBeanList) {
					if (timeTableBean.getDayOfWeek().equals(classTimeTableDTO.getDayOfWeekDTO())) {
						foundDay = true;
						timeTableBean.getPeriodList().add(classTimeTableDTO);
						break;
					}
				}
				if (!foundDay) {
					createNewDay(classTimeTableDTO);
				}
			} else {
				createNewDay(classTimeTableDTO);
			}
		}
		setClassYearList(WebUtils.getYearListForClass());
	}

	/**
	 * Method to create the default class timetable while creating a class.
	 * 
	 * @param classId
	 * @return classTimeTableList
	 */
	public List<ClassTimeTableDTO> createDefaultClassTimeTable() {

		setClassDTO(objfactory.createClassDTO());
		classDTO.setActive("active");
		List<ClassTimeTableDTO> newClasstimeTableList = new ArrayList<ClassTimeTableDTO>();
		FacesContext context = FacesContext.getCurrentInstance();
		ReferenceBean referenceBean = (ReferenceBean) context.getApplication().evaluateExpressionGet(context, "#{" + REFERENCE_BEAN + "}", Object.class);
		List<ReferenceDataDTO> dayOfWeekDTOList = referenceBean.getDaysOfWeekDTOList();
		List<ReferenceDataDTO> subjectDTOList = referenceBean.getSubjectDTOList();
		for (ReferenceDataDTO dayOfWeekDTO : dayOfWeekDTOList) {
			Integer noOfPeriods = new Integer(dayOfWeekDTO.getAdditionalData());
			if (noOfPeriods > 0) {
				for (int noOfPeriodsCount = 1; noOfPeriodsCount <= noOfPeriods; noOfPeriodsCount++) {
					ClassTimeTableDTO classTimeTableDTO = new ClassTimeTableDTO();
					classTimeTableDTO.setDayOfWeekDTO(dayOfWeekDTO);
					classTimeTableDTO.setSubjectDTO(subjectDTOList.get(0));
					classTimeTableDTO.setPeriodName(PERIOD + noOfPeriodsCount);
					newClasstimeTableList.add(classTimeTableDTO);
				}
			}
		}
		classDTO.setClassTimeTableDTOList(newClasstimeTableList);
		populateTimeTableGrid();
		return newClasstimeTableList;
	}

	/**
	 * Method to create a new day with the first period
	 * 
	 * @param classTimeTableDTO
	 */
	private void createNewDay(ClassTimeTableDTO classTimeTableDTO) {
		TimeTableBean timeTableBean = new TimeTableBean();
		timeTableBean.setDayOfWeek(classTimeTableDTO.getDayOfWeekDTO());
		timeTableBean.getPeriodList().add(classTimeTableDTO);
		getTimeTableBeanList().add(timeTableBean);
	}

}
