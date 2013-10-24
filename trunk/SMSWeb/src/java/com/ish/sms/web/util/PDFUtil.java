package com.ish.sms.web.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.ish.sms.service.dto.ClassExamReferenceDataDTO;
import com.ish.sms.service.dto.ReportCardDTO;
import com.ish.sms.web.bean.ReportCardBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * PDF Creation Utility
 * 
 * @author Naren
 * 
 */
public class PDFUtil implements WebConstants {

	/**
	 * @param reportCardBean
	 * @throws Exception
	 */
	public static void generateReportCardPDF(ReportCardBean reportCardBean) throws Exception {

		// Get the text that will be added to the PDF
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		// step 1
		ec.responseReset();
		Document document = new Document();
		// step 2
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, baos);
		// step 3
		document.open();
		// step 4
		BaseColor blueBackgroundColor = WebColors.getRGBColor(BLUE_COLOR);
		Font fontRegular = FontFactory.getFont(TIMES_NEW_ROMAN, 12, Font.NORMAL);
		Font fontbold = FontFactory.getFont(TIMES_NEW_ROMAN, 12, Font.BOLD);

		Paragraph schoolName = new Paragraph("High Secondary School " + NEW_LINE, fontbold);

		Paragraph studentName = new Paragraph(STUDENT + reportCardBean.getSelectedStudentDTO().getFirstName() + BLANK
				+ reportCardBean.getSelectedStudentDTO().getFatherName() + NEW_LINE, fontRegular);
		Paragraph className = new Paragraph(CLASS + reportCardBean.getClassDTO().getName() + NEW_LINE, fontRegular);
		document.add(schoolName);
		document.add(studentName);
		document.add(className);
		document.add(new Paragraph(NEW_LINE));

		float[] columnRelativeWidths = new float[reportCardBean.getClassExamReferenceDataDTOList().size() + 1];
		PdfPTable table = new PdfPTable(reportCardBean.getClassExamReferenceDataDTOList().size() + 1);
		table.setWidthPercentage(100);

		PdfPCell cell = new PdfPCell(new Phrase(SUBJECT, fontbold));
		cell.setBackgroundColor(blueBackgroundColor);
		table.addCell(cell);
		columnRelativeWidths[0] = 1.5f;

		// set column headers
		for (int i = 0; i < reportCardBean.getClassExamReferenceDataDTOList().size(); i++) {
			cell = new PdfPCell(new Phrase(reportCardBean.getClassExamReferenceDataDTOList().get(i).getReferenceDataDTO().getName(), fontbold));
			cell.setBackgroundColor(blueBackgroundColor);
			table.addCell(cell);
			columnRelativeWidths[i] = 1f;
		}
		table.setWidths(columnRelativeWidths);

		for (ReportCardDTO reportCardDTO : reportCardBean.getReportCardDTOList()) {
			cell = new PdfPCell(new Phrase(reportCardDTO.getClassSubjectReferenceDataDTO().getReferenceDataDTO().getName(), fontbold));
			cell.setBackgroundColor(blueBackgroundColor);
			table.addCell(cell);
			for (ClassExamReferenceDataDTO classExamReferenceDataDTO : reportCardBean.getClassExamReferenceDataDTOList()) {
				Integer mark = reportCardDTO.getReportCardDetailsMap().get(classExamReferenceDataDTO) != null ? reportCardDTO.getReportCardDetailsMap()
						.get(classExamReferenceDataDTO).getMark() : null;
				table.addCell("" + (mark != null ? mark : ""));
			}
		}

		document.add(table);

		Paragraph commentsHeader = new Paragraph(NEW_LINE + COMMENTS + NEW_LINE, fontbold);
		Paragraph comments = new Paragraph(reportCardBean.getClassStudentDTO().getComments(), fontRegular);
		document.add(commentsHeader);
		document.add(comments);

		// step 5
		document.close();
		// setting some response headers
		ec.setResponseHeader(RESPONSE_HEADER_CONTENT, RESPONSE_HEADER_ATTACHEMENT + reportCardBean.getSelectedStudentDTO().getFirstName() + PDF_EXTENSION);
		// setting the content type
		ec.setResponseContentType(CONTENT_TYPE);
		// the contentlength
		ec.setResponseContentLength(baos.size());
		// write ByteArrayOutputStream to the ServletOutputStream
		OutputStream os = ec.getResponseOutputStream();
		baos.writeTo(os);
		os.flush();
		os.close();
		fc.responseComplete();

	}
}
