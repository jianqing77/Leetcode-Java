package Refresh_Data_Structure.Lists;

import java.util.Objects;

public class Employee {
  private String firstName;
  private String lastName;
  private int id;

  public Employee(String firstName, String lastName, int id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id= id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return getId() == employee.getId() && Objects.equals(getFirstName(),
        employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getId());
  }

  @Override
  public String toString() {
    return "Employee{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", id=" + id +
        '}';
  }
}
