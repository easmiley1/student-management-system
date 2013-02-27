package com.ish.sms.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassReferenceDataDTO;
import com.ish.sms.service.dto.ClassTimeTableDTO;
import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.web.util.WebUtils;

/**
 * Bean class to hold all the class details in session scope.
 * 
 * @author Naren
 * 
 */
@ManagedBean(name = "classBean")
@SessionScoped
public class ClassBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private List<TimeTableBean> timeTableBeanList = new ArrayList<TimeTableBean>();

	private ClassDTO classDTO = new ClassDTO();

	private List<Integer> classYearList = new ArrayList<Integer>();

	private DualListModel<ReferenceDataDTO> subjectDTODualListModel = new DualListModel<ReferenceDataDTO>();

	private DualListModel<ReferenceDataDTO> examDTODualListModel = new DualListModel<ReferenceDataDTO>();

	/**
	 * @return the examDTODualListModel
	 */
	public DualListModel<ReferenceDataDTO> getExamDTODualListModel() {
		return examDTODualListModel;
	}

	/**
	 * @param examDTODualListModel
	 *            the examDTODualListModel to set
	 */
	public void setExamDTODualListModel(DualListModel<ReferenceDataDTO> examDTODualListModel) {
		this.examDTODualListModel = examDTODualListModel;
	}

	/**
	 * @return the subjectDTODualListModel
	 */
	public DualListModel<ReferenceDataDTO> getSubjectDTODualListModel() {
		return subjectDTODualListModel;
	}

	/**
	 * @param subjectDTODualListModel
	 *            the subjectDTODualListModel to set
	 */
	public void setSubjectDTODualListModel(DualListModel<ReferenceDataDTO> subjectDTODualListModel) {
		this.subjectDTODualListModel = subjectDTODualListModel;
	}

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

	/**
	 * Method to create the default class timetable while creating a class.
	 * 
	 * @param classId
	 * @return classTimeTableList
	 */
	public void createDefaultClass() {

		setClassDTO(objfactory.createClassDTO());
		classDTO.setActive(ACTIVE);
		createDefaultTimeTable();
		populateSubjectAndExamPickList();
	}

	/**
	 * Method to create the default timetable list based on the no of periods for given day and set in the ClassDTO
	 */
	private void createDefaultTimeTable() {
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
	}

	/**
	 * Method to populate the timetable grid based on the classtimeTableDTOList set in the classDTO
	 */

	public void populateClassDetailGrids() {
		populateTimeTableGrid();
		populateSubjectAndExamPickList();
	}

	/**
	 * Method to populate the exam and subject pick list based on the reference data and selected data in the ClassDTO
	 */
	private void populateSubjectAndExamPickList() {

		/* Get the default source for subject from the reference bean and remove the selected values */
		List<ReferenceDataDTO> classSubjectSourceList = new ArrayList<ReferenceDataDTO>();
		List<ReferenceDataDTO> classSubjectTargetList = new ArrayList<ReferenceDataDTO>();
		List<ReferenceDataDTO> classExamSourceList = new ArrayList<ReferenceDataDTO>();
		List<ReferenceDataDTO> classExamTargetList = new ArrayList<ReferenceDataDTO>();
		FacesContext context = FacesContext.getCurrentInstance();
		ReferenceBean referenceBean = (ReferenceBean) context.getApplication().evaluateExpressionGet(context, "#{" + REFERENCE_BEAN + "}", Object.class);

		/* Master source data for subjects without filtering targets */
		classSubjectSourceList.addAll(referenceBean.getSubjectDTOList());

		/* Target list which is also used to filter the source */
		for (ClassReferenceDataDTO classSubjectReferenceDataDTO : classDTO.getClassSubjectReferenceDataDTOList()) {
			classSubjectTargetList.add(classSubjectReferenceDataDTO.getReferenceDataDTO());
		}
		classSubjectSourceList.removeAll(classSubjectTargetList);
		getSubjectDTODualListModel().setSource(classSubjectSourceList);
		getSubjectDTODualListModel().setTarget(classSubjectTargetList);

		/* Master source data for subjects without filtering targets */
		classExamSourceList.addAll(referenceBean.getExamDataDTOList());

		/* Target list which is also used to filter the source */
		for (ClassReferenceDataDTO classExamReferenceDataDTO : classDTO.getClassExamReferenceDataDTOList()) {
			classExamTargetList.add(classExamReferenceDataDTO.getReferenceDataDTO());
		}
		classExamSourceList.removeAll(classExamTargetList);
		getExamDTODualListModel().setSource(classExamSourceList);
		getExamDTODualListModel().setTarget(classExamTargetList);
	}

	/**
	 * Method to populate the time table grid based on the values set in the classDTO, this is required because the data model for the
	 * timetable is different between ClassDTO and the grid
	 */
	private void populateTimeTableGrid() {

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

	/**
	 * Method to get the modifications for the exam and subject reference data by going through the pick lists 
	 * 
	 * @param referenceDataList
	 * @param classReferenceDataDTOList
	 * @return modifiedClassReferenceDataDTOList
	 * @throws Exception
	 */
	public List<ClassReferenceDataDTO> getModifiedClassReferenceDataList(DualListModel<ReferenceDataDTO> referenceDataList,
			List<ClassReferenceDataDTO> classReferenceDataDTOList) throws Exception {

		List<ClassReferenceDataDTO> modifiedClassReferenceDataDTOList = new ArrayList<ClassReferenceDataDTO>();
		for (ReferenceDataDTO referenceDataDTO : referenceDataList.getTarget()) {
  
			boolean foundReferenceData = false;
			for (ClassReferenceDataDTO classReferenceDataDTO : classReferenceDataDTOList) {
				if (referenceDataDTO.equals(classReferenceDataDTO.getReferenceDataDTO())) {
					modifiedClassReferenceDataDTOList.add(classReferenceDataDTO);
					foundReferenceData = true;
					break;
				}
			}
			if (!foundReferenceData) {
				ClassReferenceDataDTO classReferenceDataDTO = new ClassReferenceDataDTO();
				classReferenceDataDTO.setModification(WebUtils.CLASS_DEF_MODIFICATION.Added.name());
				classReferenceDataDTO.setReferenceDataDTO(referenceDataDTO);
				modifiedClassReferenceDataDTOList.add(classReferenceDataDTO);
			}
		}

		return modifiedClassReferenceDataDTOList;
	}

}
