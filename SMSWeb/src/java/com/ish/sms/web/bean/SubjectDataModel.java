package com.ish.sms.web.bean;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.ish.sms.service.dto.ClassSubjectReferenceDataDTO;

/**
 * Data model to be represent the subject list in the grid
 * 
 * @author Naren
 *
 */
public class SubjectDataModel extends ListDataModel<ClassSubjectReferenceDataDTO> implements SelectableDataModel<ClassSubjectReferenceDataDTO> {

	public SubjectDataModel() {
	}

	public SubjectDataModel(List<ClassSubjectReferenceDataDTO> data) {
		super(data);
	}

	/* (non-Javadoc)
	 * @see org.primefaces.model.SelectableDataModel#getRowData(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ClassSubjectReferenceDataDTO getRowData(String rowKey) {

		List<ClassSubjectReferenceDataDTO> ClassSubjectReferenceDataDTOs = (List<ClassSubjectReferenceDataDTO>) getWrappedData();

		for (ClassSubjectReferenceDataDTO ClassSubjectReferenceDataDTO : ClassSubjectReferenceDataDTOs) {
			if (ClassSubjectReferenceDataDTO.getReferenceDataDTO().getName().equals(rowKey))
				return ClassSubjectReferenceDataDTO;
		}

		return null;
	}

	@Override
	public Object getRowKey(ClassSubjectReferenceDataDTO ClassSubjectReferenceDataDTO) {
		return ClassSubjectReferenceDataDTO.getReferenceDataDTO().getName();
	}

}
