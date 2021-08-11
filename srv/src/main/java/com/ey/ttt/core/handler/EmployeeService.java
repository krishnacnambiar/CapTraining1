package com.ey.ttt.core.handler;

import java.util.List;

import com.sap.cds.services.ErrorStatuses;
import com.sap.cds.services.EventContext;
import com.sap.cds.services.ServiceException;
import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.ServiceName;

import org.springframework.stereotype.Component;

import cds.gen.employeeservice.EmployeeCounselorRelationship;
import cds.gen.employeeservice.EmployeeCounselorRelationship_;


@Component
@ServiceName("EmployeeService")
public class EmployeeService implements EventHandler{
    
    @Before(event = { CdsService.EVENT_CREATE }, entity = EmployeeCounselorRelationship_.CDS_NAME)
    public void validateCounselorRelationship(List<EmployeeCounselorRelationship> datalist, EventContext context){
        for (EmployeeCounselorRelationship employeeCounselorRelationship : datalist) {
            if(employeeCounselorRelationship.getEmployeeId() == employeeCounselorRelationship.getCounselorId()){
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Employee and COuselor Cannot be the same Person");
            }
        }
    }
}
