package com.ish.sms.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.ish.sms.service.dto.ChartSeriesDTO;
import com.ish.sms.service.dto.ChartSeriesListDTO;
import com.ish.sms.service.dto.ChartValueDTO;
import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.util.WebConstants;
import com.ish.sms.web.util.WebUtils;

/**
 * Bean class to hold all the attendance report details in session scope.
 * 
 * @author Naren
 * 
 */

@ManagedBean(name = WebConstants.ATTENDANCE_REPORT_BEAN)
@SessionScoped
public class AttendanceReportBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	private CartesianChartModel categoryModel = new CartesianChartModel();
	private List<ClassDTO> classDTOList = new ArrayList<ClassDTO>();
	private ClassDTO selectedClassDTO = new ClassDTO();
	private List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
	private StudentDTO selectedStudentDTO = new StudentDTO();
	private boolean readOnly;

	/**
	 * @return the readOnly
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * @param readOnly
	 *            the readOnly to set
	 */
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * @return the studentDTOList
	 */
	public List<StudentDTO> getStudentDTOList() {
		return studentDTOList;
	}

	/**
	 * @param studentDTOList
	 *            the studentDTOList to set
	 */
	public void setStudentDTOList(List<StudentDTO> studentDTOList) {
		this.studentDTOList = studentDTOList;
	}

	/**
	 * @return the selectedStudentDTO
	 */
	public StudentDTO getSelectedStudentDTO() {
		return selectedStudentDTO;
	}

	/**
	 * @param selectedStudentDTO
	 *            the selectedStudentDTO to set
	 */
	public void setSelectedStudentDTO(StudentDTO selectedStudentDTO) {
		this.selectedStudentDTO = selectedStudentDTO;
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
	 * @return the selectedClassDTO
	 */
	public ClassDTO getSelectedClassDTO() {
		return selectedClassDTO;
	}

	/**
	 * @param selectedClassDTO
	 *            the selectedClassDTO to set
	 */
	public void setSelectedClassDTO(ClassDTO selectedClassDTO) {
		this.selectedClassDTO = selectedClassDTO;
	}

	/**
	 * @return the categoryModel
	 */
	public CartesianChartModel getCategoryModel() {
		return categoryModel;
	}

	/**
	 * @param categoryModel
	 *            the categoryModel to set
	 */
	public void setCategoryModel(CartesianChartModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	/**
	 * Method to set the selected class details
	 * 
	 * @param userBean
	 * @return validation
	 */
	public boolean setClassDetails(UserBean userBean) {

		List<ClassDTO> classDTOList = userBean.getUserDetailsDTO().getClassListDTO().getClassDTOList();
		if (classDTOList == null || classDTOList.size() == 0) {
			WebUtils.registerMessage(FacesMessage.SEVERITY_WARN, AUTH_ERROR, CLASS_DETAILS_NOT_FOUND);
			return false;
		} else {
			setClassDTOList(classDTOList);
			setSelectedClassDTO(classDTOList.get(0));
			return true;
		}
	}

	/**
	 * Method to populate the chartModel for the student attendance leave report
	 * 
	 * @param chartSeriesListDTO
	 */
	public void populateChartModel(ChartSeriesListDTO chartSeriesListDTO) {

		CartesianChartModel categoryModel = new CartesianChartModel();
		List<ChartSeriesDTO> chartSeriesDTOList = chartSeriesListDTO.getChartSeriesListDTO();
		if (chartSeriesDTOList != null & chartSeriesDTOList.size() > 0) {

			ChartSeriesDTO chartSeriesDTO = chartSeriesDTOList.get(0);
			ChartSeries chartSeries = new ChartSeries();
			chartSeries.setLabel(chartSeriesDTO.getSeriesLabel());
			for (ChartValueDTO chartValueDTO : chartSeriesDTO.getChartValueListDTO()) {
				chartSeries.set(chartValueDTO.getXLabel(), new Integer(chartValueDTO.getYValue()).intValue());
			}
			categoryModel.addSeries(chartSeries);
			if (chartSeriesDTO.getChartValueListDTO() != null & chartSeriesDTO.getChartValueListDTO().size() > 0)
				setCategoryModel(categoryModel);
		}
	}

	/**
	 * Method to create the default attendance report chart
	 */
	public void createDefaultChart() {
		CartesianChartModel categoryModel = new CartesianChartModel();
		ChartSeries chartSeries = new ChartSeries();
		chartSeries.setLabel("Attendance Report");
		chartSeries.set("Month", 0);
		categoryModel.addSeries(chartSeries);
		setCategoryModel(categoryModel);
	}

	/**
	 * Method to populate the student details for the drop downs for parent access reports
	 * 
	 * @param studentDTO
	 */
	public void populateStudentAttendanceDetails(StudentDTO studentDTO) {
		
		List<ClassDTO> classDTOList = new ArrayList<ClassDTO>();
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		classDTOList.add(studentDTO.getCurrentClassDTO());
		studentDTOList.add(studentDTO);

		setSelectedStudentDTO(studentDTO);
		setSelectedClassDTO(studentDTO.getCurrentClassDTO());
		setClassDTOList(classDTOList);
		setStudentDTOList(studentDTOList);
		setReadOnly(true);
	}
}
