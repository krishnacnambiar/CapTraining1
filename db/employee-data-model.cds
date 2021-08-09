namespace db;
using { cuid } from '@sap/cds/common';


entity Employee:cuid{
    firstName : String;
    lastName : String;
    dateOfBirth : Date;
    dateOfJoining : Date; 
}