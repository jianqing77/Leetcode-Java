package Refresh_Data_Structure.Lists;

public class EmployeeNode {
  private Employee employee; // value: Employee
  private EmployeeNode next; // next: another node

  public EmployeeNode(Employee employee) {
    this.employee = employee;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public EmployeeNode getNext() {
    return next;
  }

  public void setNext(EmployeeNode next) {
    this.next = next;
  }

  public String toString() {
    return employee.toString();
  }
}
