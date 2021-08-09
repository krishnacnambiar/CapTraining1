using {db } from '../db/employee-data-model';

Service EmployeeService {
    entity Employee as projection on db.Employee;
}
