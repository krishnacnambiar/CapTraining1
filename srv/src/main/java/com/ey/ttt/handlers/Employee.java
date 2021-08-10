package com.ey.ttt.handlers;

import com.sap.cds.services.ErrorStatus;
import com.sap.cds.services.ErrorStatuses;
import com.sap.cds.services.EventContext;
import com.sap.cds.services.ServiceException;
import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.ServiceName;

import org.springframework.stereotype.Component;

import cds.gen.db.EmployeeCounselorRelationship;
import cds.gen.employeeservice.EmployeeService_;
import io.vavr.collection.List;


@Component
@ServiceName(EmployeeService_.CDS_NAME)
public class Employee implements EventHandler{
    @Before(event = {CdsService.EVENT_CREATE, CdsService.EVENT_UPDATE, CdsService.EVENT_UPSERT}, entity = EmployeeService_.CDS_NAME)
    public void validateCounselor(List<EmployeeCounselorRelationship> datalist, EventContext eventContext){
        for (EmployeeCounselorRelationship employeeCounselorRelationship : datalist) {
            if(employeeCounselorRelationship.getEmployeeId() == employeeCounselorRelationship.getCounselorId()){
                throw new ServiceException(ErrorStatuses.NOT_ACCEPTABLE, "Manager and Counselor cannot be the same Person");
            }
        }
    }
    
}
