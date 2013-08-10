package com.ish.sms.web.action;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.ish.sms.service.dto.ClassDTO;
import com.ish.sms.service.dto.ReportCardDTO;
import com.ish.sms.service.dto.StudentDTO;
import com.ish.sms.web.bean.ReportCardBean;
import com.ish.sms.web.util.WebUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Action Bean class which is in request scope for all the report card related actions.
 * 
 * @author Naren
 */

@ManagedBean(name = "reportCardAction")
@ViewScoped
public class ReportCardAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{reportCardBean}")
	private ReportCardBean reportCardBean;

	/**
	 * @return the reportCardBean
	 */
	public ReportCardBean getReportCardBean() {
		return reportCardBean;
	}

	/**
	 * @param reportCardBean
	 *            the reportCardBean to set
	 */
	public void setReportCardBean(ReportCardBean reportCardBean) {
		this.reportCardBean = reportCardBean;
	}

	/**
	 * Method to populate the student list and populate the report card for the first student.
	 * 
	 * @param classId
	 * @return reportCard.xhtml
	 */
	public String openReportCardRegister(Integer classId) {

		try {
			ClassDTO classDTO = classBusiness.retrieveClassForId(classId);
			if (!reportCardBean.setClassDetails(classDTO)) {
				return REPORT_CARD_PAGE;
			} else {
				setStudentDetails();
				List<ReportCardDTO> reportCardDTOList = classBusiness.retrieveClassGradeDetailsForStudent(classId, reportCardBean.getSelectedStudentDTO()
						.getId());
				reportCardBean.setReportCardDTOList(reportCardDTOList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
		return REPORT_CARD_PAGE;
	}

	/**
	 * Method to listen the student change event and set the appropriate student report card.
	 * 
	 * @param ajaxBehaviorEvent
	 */
	public void changeStudent(AjaxBehaviorEvent ajaxBehaviorEvent) {
		try {
			List<ReportCardDTO> reportCardDTOList = classBusiness.retrieveClassGradeDetailsForStudent(reportCardBean.getClassDTO().getId(), reportCardBean
					.getSelectedStudentDTO().getId());
			reportCardBean.setReportCardDTOList(reportCardDTOList);

		} catch (Exception e) {
			e.printStackTrace();
			WebUtils.registerErrorMessage();
		}
	}

	public void generatePDF() throws Exception{
		// Get the text that will be added to the PDF
		FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();		
		String text = "dummyText";
		if (text == null || text.trim().length() == 0) {
			text = "You didn't enter any text.";
		}
		// step 1
        ec.responseReset(); 
		Document document = new Document();
		// step 2
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, baos);
		// step 3
		document.open();
		// step 4
		document.add(new Paragraph("You have submitted the following text using the %s method:"));
		document.add(new Paragraph(text));
		// step 5
		document.close();
		// setting some response headers
		 ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + "mypdf.pdf");
		// setting the content type
		 ec.setResponseContentType("application/pdf");
		// the contentlength
		ec.setResponseContentLength(baos.size());
		// write ByteArrayOutputStream to the ServletOutputStream
	    OutputStream os = ec.getResponseOutputStream();
		baos.writeTo(os);
		os.flush();
		os.close();
		fc.responseComplete();
	}

	/**
	 * Method to retrieve the student details for the specified class and set them in the bean
	 * 
	 * @throws Exception
	 */
	private void setStudentDetails() throws Exception {

		List<String> classIdList = new ArrayList<String>();
		classIdList.add("" + reportCardBean.getClassDTO().getId());
		List<StudentDTO> studentDTOList = associateBusiness.retrieveAllStudents(classIdList);
		reportCardBean.setStudentDTOList(studentDTOList);
		if (studentDTOList != null && studentDTOList.size() > 0) {
			reportCardBean.setSelectedStudentDTO(studentDTOList.get(0));
		}
	}

}
