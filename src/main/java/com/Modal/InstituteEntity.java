package com.Modal;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by apple on 27/12/16.
 */
@XmlRootElement
@Entity
@Table(name = "institute", schema = "Tuition", catalog = "")
public class InstituteEntity extends ResourceSupport {
    private Integer instituteId;
    private String instituteName;
    private Timestamp instituteCreateDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    private UserEntity userEntity;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "institute_id", nullable = false)
    public Integer getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Integer instituteId) {
        this.instituteId = instituteId;
    }

    @Basic
    @Column(name = "institute_name", nullable = false, length = 500)
    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    @Basic
    @Column(name = "institute_create_date", nullable = true)
    public Timestamp getInstituteCreateDate() {
        return instituteCreateDate;
    }

    public void setInstituteCreateDate(Timestamp instituteCreateDate) {
        this.instituteCreateDate = instituteCreateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstituteEntity that = (InstituteEntity) o;

        if (instituteId != null ? !instituteId.equals(that.instituteId) : that.instituteId != null) return false;
        if (instituteName != null ? !instituteName.equals(that.instituteName) : that.instituteName != null)
            return false;
        if (instituteCreateDate != null ? !instituteCreateDate.equals(that.instituteCreateDate) : that.instituteCreateDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = instituteId != null ? instituteId.hashCode() : 0;
        result = 31 * result + (instituteName != null ? instituteName.hashCode() : 0);
        result = 31 * result + (instituteCreateDate != null ? instituteCreateDate.hashCode() : 0);
        return result;
    }
}
