package com.usermanage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="t_manager"
    ,catalog="usermanage"
, uniqueConstraints = @UniqueConstraint(columnNames="manager_name")
)

public class Tmanager  implements java.io.Serializable {


    // Fields    

     private long managerId;
     private String managerName;
     private String managerPassword;
     private String managerEmail;
     private String managerPhone;
     private Integer spare1;
     private String spare2;


    // Constructors

    /** default constructor */
    public Tmanager() {
    }

	/** minimal constructor */
    public Tmanager(String managerName, String managerPassword) {
        this.managerName = managerName;
        this.managerPassword = managerPassword;
    }
    
    /** full constructor */
    public Tmanager(String managerName, String managerPassword, String managerEmail, String managerPhone, Integer spare1, String spare2) {
        this.managerName = managerName;
        this.managerPassword = managerPassword;
        this.managerEmail = managerEmail;
        this.managerPhone = managerPhone;
        this.spare1 = spare1;
        this.spare2 = spare2;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="manager_id", unique=true, nullable=false)

    public long getManagerId() {
        return this.managerId;
    }
    
    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }
    
    @Column(name="manager_name", unique=true, nullable=false, length=20)

    public String getManagerName() {
        return this.managerName;
    }
    
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    
    @Column(name="manager_password", nullable=false)

    public String getManagerPassword() {
        return this.managerPassword;
    }
    
    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }
    
    @Column(name="manager_email", length=50)

    public String getManagerEmail() {
        return this.managerEmail;
    }
    
    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }
    
    @Column(name="manager_phone", length=20)

    public String getManagerPhone() {
        return this.managerPhone;
    }
    
    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
    
    @Column(name="spare1")

    public Integer getSpare1() {
        return this.spare1;
    }
    
    public void setSpare1(Integer spare1) {
        this.spare1 = spare1;
    }
    
    @Column(name="spare2", length=50)

    public String getSpare2() {
        return this.spare2;
    }
    
    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }
   








}