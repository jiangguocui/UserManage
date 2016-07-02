package com.usermanage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="t_user"
    ,catalog="usermanage"
, uniqueConstraints = @UniqueConstraint(columnNames="user_name")
)

public class Tuser  implements java.io.Serializable {


    // Fields    

     private long id;
     private Degree degree;
     private Political political;
     private String userName;
     private String userPassword;
     private String userBirthday;
     private String userGender;
     private String userEmail;
     private String userPhone;
     private String userSchool;
     private String userAdress;
     private String userPicture;
     private Double salary;
     private String company;
     private String job;
     private Integer spare1;
     private String spare2;
     private String spare3;



    public Tuser() {
    }

	/** minimal constructor */
    public Tuser(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
    
    /** full constructor */
    public Tuser(Degree degree, Political political, String userName, String userPassword, String userBirthday, String userGender, String userEmail, String userPhone, String userSchool, String userAdress, String userPicture, Double salary, String company, String job, Integer spare1, String spare2, String spare3) {
        this.degree = degree;
        this.political = political;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userBirthday = userBirthday;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userSchool = userSchool;
        this.userAdress = userAdress;
        this.userPicture = userPicture;
        this.salary = salary;
        this.company = company;
        this.job = job;
        this.spare1 = spare1;
        this.spare2 = spare2;
        this.spare3 = spare3;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)

    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="user_degreesId")

    public Degree getDegree() {
        return this.degree;
    }
    
    public void setDegree(Degree degree) {
        this.degree = degree;
    }
	@ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="user_politicalId")

    public Political getPolitical() {
        return this.political;
    }
    
    public void setPolitical(Political political) {
        this.political = political;
    }
    
    @Column(name="user_name", nullable=false, length=20)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="user_password", nullable=false, length=200)

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    @Column(name="user_birthday", length=50)

    public String getUserBirthday() {
        return this.userBirthday;
    }
    
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }
    
    @Column(name="user_gender", length=10)

    public String getUserGender() {
        return this.userGender;
    }
    
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    
    @Column(name="user_email", length=50)

    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    @Column(name="user_phone", length=20)

    public String getUserPhone() {
        return this.userPhone;
    }
    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    
    @Column(name="user_school", length=50)

    public String getUserSchool() {
        return this.userSchool;
    }
    
    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }
    
    @Column(name="user_adress", length=200)

    public String getUserAdress() {
        return this.userAdress;
    }
    
    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }
    
    @Column(name="user_picture", length=200)

    public String getUserPicture() {
        return this.userPicture;
    }
    
    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }
    
    @Column(name="salary", precision=12, scale=4)

    public Double getSalary() {
        return this.salary;
    }
    
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    @Column(name="company", length=100)

    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    @Column(name="job", length=100)

    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
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
    
    @Column(name="spare3", length=200)

    public String getSpare3() {
        return this.spare3;
    }
    
    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }
   








}