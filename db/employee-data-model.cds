namespace db;
using { cuid,managed } from '@sap/cds/common';
using {CounselorStatus} from './types';


entity Employee:cuid,managed{
    firstName : String;
    lastName : String;
    dateOfBirth : Date;
    dateOfJoining : Date; 
};

entity EmployeeCounselorRelationship:cuid,managed{
    employee: Association to Employee;
    counselor : Association to Employee;
    status : CounselorStatus;
}