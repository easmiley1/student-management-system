package com.ish.sms.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ClassExamReferenceDataDTO;
import com.ish.sms.service.dto.ClassReferenceDataDTO;
import com.ish.sms.service.dto.ClassSubjectReferenceDataDTO;
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
	private List<ClassDTO> classDTOList = new ArrayList<ClassDTO>();
	private ClassDTO classDTO = new ClassDTO();
	private List<Integer> classYearList = new ArrayList<Integer>();
	private List<ClassSubjectReferenceDataDTO> selectedClassSubjectReferenceDataDTOList  = new ArrayList<ClassSubjectReferenceDataDTO>();
	private DualListModel<ReferenceDataDTO> examDTODualListModel = new DualListModel<ReferenceDataDTO>();
	private SubjectDataModel subjectDataModel = new SubjectDataModel();
	@ManagedProperty(value = "#{referenceBean}")
	private ReferenceBean referenceBean;

	
	/**
	 * @return the referenceBean
	 */
	public ReferenceBean getReferenceBean() {
		return referenceBean;
	}

	/**
	 * @param referenceBean the referenceBean to set
	 */
	public void setReferenceBean(ReferenceBean referenceBean) {
		this.referenceBean = referenceBean;
	}

	/**
	 * @return the classDTOList
	 */
	public List<ClassDTO> getClassDTOList() {
		return classDTOList;
	}

	/**
	 * @param classDTOList the classDTOList to set
	 */
	public void setClassDTOList(List<ClassDTO> classDTOList) {
		this.classDTOList = classDTOList;
	}

	/**
	 * @return the subjectDataModel
	 */
	public SubjectDataModel getSubjectDataModel() {
		return subjectDataModel;
	}

	/**
	 * @param subjectDataModel the subjectDataModel to set
	 */
	public void setSubjectDataModel(SubjectDataModel subjectDataModel) {
		this.subjectDataModel = subjectDataModel;
	}

	/**
	 * @return the selectedClassSubjectReferenceDataDTOList
	 */
	public List<ClassSubjectReferenceDataDTO> getSelectedClassSubjectReferenceDataDTOList() {
		return selectedClassSubjectReferenceDataDTOList;
	}

	/**
	 * @param selectedClassSubjectReferenceDataDTOList the selectedClassSubjectReferenceDataDTOList to set
	 */
	public void setSelectedClassSubjectReferenceDataDTOList(List<ClassSubjectReferenceDataDTO> selectedClassSubjectReferenceDataDTOList) {
		this.selectedClassSubjectReferenceDataDTOList = selectedClassSubjectReferenceDataDTOList;
	}

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
		populateSubjectAndExamPickList();
	}

	/**
	 * Method to create the default timetable list based on the no of periods for given day and set in the ClassDTO
	 */
	public void createDefaultTimeTable() {
		List<ClassTimeTableDTO> newClasstimeTableList = new ArrayList<ClassTimeTableDTO>();
		List<ReferenceDataDTO> dayOfWeekDTOList = referenceBean.getDaysOfWeekDTOList();
		for (ReferenceDataDTO dayOfWeekDTO : dayOfWeekDTOList) {
			Integer noOfPeriods = new Integer(dayOfWeekDTO.getAdditionalData());
			if (noOfPeriods > 0) {
				for (int noOfPeriodsCount = 1; noOfPeriodsCount <= noOfPeriods; noOfPeriodsCount++) {
					ClassTimeTableDTO classTimeTableDTO = new ClassTimeTableDTO();
					classTimeTableDTO.setDayOfWeekDTO(dayOfWeekDTO);
					classTimeTableDTO.setClassSubjectReferenceDataDTO(selectedClassSubjectReferenceDataDTOList.get(0));
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
		populateSubjectAndExamPickList();
	}

	/**
	 * Method to populate the exam and subject pick list based on the reference data and selected data in the ClassDTO
	 */
	private void populateSubjectAndExamPickList() {
		setClassYearList(WebUtils.getYearListForClass());
		/* Get the default source for subject from the reference bean and remove the selected values */
		List<ClassSubjectReferenceDataDTO> classSubjectSourceList = new ArrayList<ClassSubjectReferenceDataDTO>();
		List<ClassSubjectReferenceDataDTO> classSubjectTargetList = new ArrayList<ClassSubjectReferenceDataDTO>();
		List<ReferenceDataDTO> classExamSourceList = new ArrayList<ReferenceDataDTO>();
		List<ReferenceDataDTO> classExamTargetList = new ArrayList<ReferenceDataDTO>();

		
		/* Target list which is also used to filter the source */
		for (ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO : classDTO.getClassSubjectReferenceDataDTOList()) {
			classSubjectTargetList.add(classSubjectReferenceDataDTO);
		}
		/* Master source data for subjects without filtering targets */
		for(ReferenceDataDTO referenceDataDTO: referenceBean.getSubjectDTOList()){
			boolean subjectExistinDB = false;
			for (ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO : classDTO.getClassSubjectReferenceDataDTOList()) {
				if(classSubjectReferenceDataDTO.getReferenceDataDTO().getName().equals(referenceDataDTO.getName())){
					classSubjectSourceList.add(classSubjectReferenceDataDTO);
					subjectExistinDB = true;
					break;
				}
				
			}
			if(!subjectExistinDB){
				ClassSubjectReferenceDataDTO classSubjectReferenceDataDTO = new ClassSubjectReferenceDataDTO();
				classSubjectReferenceDataDTO.setReferenceDataDTO(referenceDataDTO);
				classSubjectSourceList.add(classSubjectReferenceDataDTO);
			}
		}

		subjectDataModel = new SubjectDataModel(classSubjectSourceList);
		setSelectedClassSubjectReferenceDataDTOList(classSubjectTargetList);

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
	public List<ClassExamReferenceDataDTO> getModifiedClassExamReferenceDataList(DualListModel<ReferenceDataDTO> referenceDataList,
			List<ClassExamReferenceDataDTO> classReferenceDataDTOList) throws Exception {

		List<ClassExamReferenceDataDTO> modifiedClassExamReferenceDataDTOList = new ArrayList<ClassExamReferenceDataDTO>();
		for (ReferenceDataDTO referenceDataDTO : referenceDataList.getTarget()) {
  
			boolean foundReferenceData = false;
			for (ClassExamReferenceDataDTO classExamReferenceDataDTO : classReferenceDataDTOList) {
				if (referenceDataDTO.equals(classExamReferenceDataDTO.getReferenceDataDTO())) {
					modifiedClassExamReferenceDataDTOList.add(classExamReferenceDataDTO);
					foundReferenceData = true;
					break;
				}
			}
			if (!foundReferenceData) {
				ClassExamReferenceDataDTO classExamReferenceDataDTO = new ClassExamReferenceDataDTO();
				classExamReferenceDataDTO.setReferenceDataDTO(referenceDataDTO);
				modifiedClassExamReferenceDataDTOList.add(classExamReferenceDataDTO);
			}
		}

		return modifiedClassExamReferenceDataDTOList;
	}

}
