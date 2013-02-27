package com.ish.sms.web.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ReferenceDataDTO;
import com.ish.sms.service.dto.TeacherDTO;
import com.ish.sms.web.cache.JBossCacheProvider;
import com.ish.sms.web.util.SMSSpringFactory;

/**
 * Bean class to hold all reference data. They will be refreshed once a day or if some reference data is updated
 * 
 * @author Naren
 * 
 */
@ManagedBean(name = "referenceBean")
@SessionScoped
public class ReferenceBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private JBossCacheProvider jbossCacheProvider;

	@SuppressWarnings("unchecked")
	public ReferenceBean() throws Exception {

		jbossCacheProvider = (JBossCacheProvider) SMSSpringFactory.getInstance().getBean("jbossCacheProvider");
		setBloodGroupDTOList((List<ReferenceDataDTO>) jbossCacheProvider.get(BLOOD_GROUP_FQN, BLOOD_GROUP_KEY));
		setModeofTransportDTOList((List<ReferenceDataDTO>) jbossCacheProvider.get(MODE_OF_TRANSPORT_FQN, MODE_OF_TRANSPORT_KEY));
		setExtraCurricularDTOList((List<ReferenceDataDTO>) jbossCacheProvider.get(EXTRA_CURRICULAR_FQN, EXTRA_CURRICULAR_KEY));
		setStateDTOList((List<ReferenceDataDTO>) jbossCacheProvider.get(STATE_FQN, STATE_KEY));
		setClassDTOList((List<ClassDTO>) jbossCacheProvider.get(CLASS_FQN, CLASS_KEY));
		setSubjectDTOList((List<ReferenceDataDTO>) jbossCacheProvider.get(SUBJECT_FQN, SUBJECT_KEY));
		setTeacherDTOList((List<TeacherDTO>) jbossCacheProvider.get(TEACHER_FQN, TEACHER_KEY));
		setDaysOfWeekDTOList((List<ReferenceDataDTO>) jbossCacheProvider.get(DAYS_OF_WEEK_FQN, DAYS_OF_WEEK_KEY));
		setExamDataDTOList((List<ReferenceDataDTO>) jbossCacheProvider.get(EXAM_FQN, EXAM_KEY));
	}

	private List<ReferenceDataDTO> bloodGroupDTOList;

	private List<ReferenceDataDTO> modeofTransportDTOList;

	private List<ReferenceDataDTO> extraCurricularDTOList;

	private List<ReferenceDataDTO> stateDTOList;

	private List<ClassDTO> classDTOList;

	private List<ReferenceDataDTO> subjectDTOList;

	private List<TeacherDTO> teacherDTOList;

	private List<ReferenceDataDTO> daysOfWeekDTOList;

	private List<ReferenceDataDTO> examDataDTOList;

	/**
	 * @return the examDataDTOList
	 */
	public List<ReferenceDataDTO> getExamDataDTOList() {
		return examDataDTOList;
	}

	/**
	 * @param examDataDTOList
	 *            the examDataDTOList to set
	 */
	public void setExamDataDTOList(List<ReferenceDataDTO> examDataDTOList) {
		this.examDataDTOList = examDataDTOList;
	}

	/**
	 * @return the daysOfWeekDTOList
	 */
	public List<ReferenceDataDTO> getDaysOfWeekDTOList() {
		return daysOfWeekDTOList;
	}

	/**
	 * @param daysOfWeekDTOList
	 *            the daysOfWeekDTOList to set
	 */
	public void setDaysOfWeekDTOList(List<ReferenceDataDTO> daysOfWeekDTOList) {
		this.daysOfWeekDTOList = daysOfWeekDTOList;
	}

	/**
	 * @return the teacherDTOList
	 */
	public List<TeacherDTO> getTeacherDTOList() {
		return teacherDTOList;
	}

	/**
	 * @param teacherDTOList
	 *            the teacherDTOList to set
	 */
	public void setTeacherDTOList(List<TeacherDTO> teacherDTOList) {
		this.teacherDTOList = teacherDTOList;
	}

	/**
	 * @return the subjectDTOList
	 */
	public List<ReferenceDataDTO> getSubjectDTOList() {
		return subjectDTOList;
	}

	/**
	 * @param subjectDTOList
	 *            the subjectDTOList to set
	 */
	public void setSubjectDTOList(List<ReferenceDataDTO> subjectDTOList) {
		this.subjectDTOList = subjectDTOList;
	}

	/**
	 * @return the classDTOList
	 */
	public List<ClassDTO> getClassDTOList() {
		return classDTOList;
	}

	/**
	 * @param classDTOList
	 *            the classDTOList to set
	 */
	public void setClassDTOList(List<ClassDTO> classDTOList) {
		this.classDTOList = classDTOList;
	}

	/**
	 * @return the bloodGroupDTOList
	 */
	public List<ReferenceDataDTO> getBloodGroupDTOList() {
		return bloodGroupDTOList;
	}

	/**
	 * @param bloodGroupDTOList
	 *            the bloodGroupDTOList to set
	 */
	public void setBloodGroupDTOList(List<ReferenceDataDTO> bloodGroupDTOList) {
		this.bloodGroupDTOList = bloodGroupDTOList;
	}

	/**
	 * @return the modeofTransportDTOList
	 */
	public List<ReferenceDataDTO> getModeofTransportDTOList() {
		return modeofTransportDTOList;
	}

	/**
	 * @param modeofTransportDTOList
	 *            the modeofTransportDTOList to set
	 */
	public void setModeofTransportDTOList(List<ReferenceDataDTO> modeofTransportDTOList) {
		this.modeofTransportDTOList = modeofTransportDTOList;
	}

	/**
	 * @return the extraCurricularDTOList
	 */
	public List<ReferenceDataDTO> getExtraCurricularDTOList() {
		return extraCurricularDTOList;
	}

	/**
	 * @param extraCurricularDTOList
	 *            the extraCurricularDTOList to set
	 */
	public void setExtraCurricularDTOList(List<ReferenceDataDTO> extraCurricularDTOList) {
		this.extraCurricularDTOList = extraCurricularDTOList;
	}

	/**
	 * @return the stateDTOList
	 */
	public List<ReferenceDataDTO> getStateDTOList() {
		return stateDTOList;
	}

	/**
	 * @param stateDTOList
	 *            the stateDTOList to set
	 */
	public void setStateDTOList(List<ReferenceDataDTO> stateDTOList) {
		this.stateDTOList = stateDTOList;
	}

}
