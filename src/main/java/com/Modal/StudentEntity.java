package com.Modal;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apple on 04/01/17.
 */
@Entity
@Table(name = "student", schema = "Tuition", catalog = "")
public class StudentEntity  extends ResourceSupport {
    private Integer studentId;
    private AddressEntity addressEntity;
    private GradeEntity gradeEntity;
    private SchoolEntity schoolEntity;
    private UserEntity userEntity;


    @OneToOne
    @JoinColumn(name= "address_id")
    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    @ManyToOne
    @JoinColumn(name= "grade_id")
    public GradeEntity getGradeEntity() {
        return gradeEntity;
    }

    public void setGradeEntity(GradeEntity gradeEntity) {
        this.gradeEntity = gradeEntity;
    }

    @ManyToOne
    @JoinColumn(name= "school_id")
    public SchoolEntity getSchoolEntity() {
        return schoolEntity;
    }

    public void setSchoolEntity(SchoolEntity schoolEntity) {
        this.schoolEntity = schoolEntity;
    }

    @OneToOne
    @JoinColumn(name= "user_id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Id
    @Column(name = "student_id", nullable = false)
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return studentId != null ? studentId.hashCode() : 0;
    }
}
