package com.ish.sms.web.bean;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.ish.sms.service.dto.StudentDTO;

/**
 * Data model to be represent the student list in the grid
 * 
 * @author Naren
 *
 */
public class StudentDataModel extends ListDataModel<StudentDTO> implements SelectableDataModel<StudentDTO> {

	public StudentDataModel() {
	}

	public StudentDataModel(List<StudentDTO> data) {
		super(data);
	}

	/* (non-Javadoc)
	 * @see org.primefaces.model.SelectableDataModel#getRowData(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public StudentDTO getRowData(String rowKey) {

		List<StudentDTO> studentDTOList = (List<StudentDTO>) getWrappedData();

		for (StudentDTO studentDTO : studentDTOList) {
			if (studentDTO.getId().equals(rowKey))
				return studentDTO;
		}

		return null;
	}

	@Override
	public Object getRowKey(StudentDTO studentDTO) {
		return studentDTO.getId();
	}

}
