package org.scm.model;

public class Employee {
    private int employee_ID;
    private String employee_Name;
    private String employee_Address;
    private String employee_Contact_No;
    private String employee_Email;

  
    /**
     * @return the employee_Name
     */
    public String getEmployee_Name() {
        return employee_Name;
    }

    /**
     * @param employee_Name the employee_Name to set
     */
    public void setEmployee_Name(String employee_Name) {
        this.employee_Name = employee_Name;
    }

    /**
     * @return the employee_Address
     */
    public String getEmployee_Address() {
        return employee_Address;
    }

    /**
     * @param employee_Address the employee_Address to set
     */
    public void setEmployee_Address(String employee_Address) {
        this.employee_Address = employee_Address;
    }

    /**
     * @return the employee_Contact_No
     */
    public String getEmployee_Contact_No() {
        return employee_Contact_No;
    }

    /**
     * @param employee_Contact_No the employee_Contact_No to set
     */
    public void setEmployee_Contact_No(String employee_Contact_No) {
        this.employee_Contact_No = employee_Contact_No;
    }

    /**
     * @return the employee_Email
     */
    public String getEmployee_Email() {
        return employee_Email;
    }

    /**
     * @param employee_Email the employee_Email to set
     */
    public void setEmployee_Email(String employee_Email) {
        this.employee_Email = employee_Email;
    }

    /**
     * @return the employee_ID
     */
    public int getEmployee_ID() {
        return employee_ID;
    }

    /**
     * @param employee_ID the employee_ID to set
     */
    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }
}

