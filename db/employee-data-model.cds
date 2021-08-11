namespace db;
using { cuid,managed } from '@sap/cds/common';
using { CounselorStatus,EmployeeRole } from './types';



entity Employee:cuid,managed{
    firstName : String;
    lastName : String;
    dateOfBirth : Date;
    dateOfJoining : Date; 
    role : EmployeeRole;
}

entity EmployeeCounselorRelationship:cuid,managed{
    employee : Association to Employee;
    counselor : Association to Employee;
    status : CounselorStatus;
}