package com.usermanage.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="political"
    ,catalog="usermanage"
)

public class Political  implements java.io.Serializable {


    // Fields    

     private long id;
     private String name;
     private Integer spare1;
     private String spare2;
     private Set<Tuser> tusers = new HashSet<Tuser>(0);


    // Constructors

    /** default constructor */
    public Political() {
    }

    
    /** full constructor */
    public Political(String name, Integer spare1, String spare2, Set<Tuser> tusers) {
        this.name = name;
        this.spare1 = spare1;
        this.spare2 = spare2;
        this.tusers = tusers;
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
    
    @Column(name="name", unique=true,length=50)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="political")

    public Set<Tuser> getTusers() {
        return this.tusers;
    }
    
    public void setTusers(Set<Tuser> tusers) {
        this.tusers = tusers;
    }
   








}