namespace db;
using { cuid,managed } from '@sap/cds/common';


entity Employee:cuid,managed{
    firstName : String;
    lastName : String;
    dateOfBirth : Date;
    dateOfJoining : Date; 
}