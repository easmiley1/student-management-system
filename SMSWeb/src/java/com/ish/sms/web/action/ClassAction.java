package com.ish.sms.web.action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ish.sms.service.dto.AttendanceDTO;
import com.ish.sms.service.dto.AttendanceDayDTO;
import com.ish.sms.service.dto.AttendanceDaysList;
import com.ish.sms.service.dto.AttendanceMonthDTO;
import com.ish.sms.web.service.ServiceTransformer;
import com.ish.sms.web.service.dto.AttendanceDayMap;

@ManagedBean(name = "classAction")
@RequestScoped
public class ClassAction {

	private AttendanceDTO attendanceDTO = new AttendanceDTO();

	public ClassAction() {

	}


	public static void main(String[] args) throws Exception {

		AttendanceDayMap<String, AttendanceDaysList> attendanceMap = new AttendanceDayMap<String, AttendanceDaysList>();
		AttendanceMonthDTO attendanceMonthDTO = new AttendanceMonthDTO();
		attendanceMonthDTO.setAttendanceDayMap(attendanceMap);
		for (int j = 0; j < 5; j++) {
			AttendanceDaysList attendanceDaysList = new AttendanceDaysList();
			for (int i = 0; i < 30; i++) {
				AttendanceDayDTO attendanceDayDTO = new AttendanceDayDTO();
				attendanceDayDTO.setDay("" + i);
				attendanceDayDTO.setPresent(i % 2 == 0 ? true : false);
				attendanceDaysList.getAttendanceDayListDTO().add(attendanceDayDTO);
			}
			attendanceMonthDTO.getAttendanceDayMap().put("" + j, attendanceDaysList);
		}
		ServiceTransformer serviceTransformer = new ServiceTransformer();
		String xml = serviceTransformer.transformToXML(attendanceMonthDTO, "attendanceMonthDTO");
		System.out.println(xml); 
	}
}
