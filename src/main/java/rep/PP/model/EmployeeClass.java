package rep.PP.model;

import javafx.animation.RotateTransition;

import javax.management.relation.Role;

public class EmployeeClass {

    private String Name;
    private String FirstName;
    private String CNP;
    private String Role;

    public EmployeeClass(String name  ,String Role , String CNP , String FristName){
        this.Name=name;
        this.CNP=CNP;
        this.Role= Role;
        this.FirstName=FristName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeClass employee = (EmployeeClass) o;

        if (!Name.equals(employee.Name)) return false;
        if (!FirstName.equals(employee.FirstName)) return false;

        return false ;

    }
    @Override
    public String toString() {
        return "UserDTO{" +
                "Name='" + Name + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}