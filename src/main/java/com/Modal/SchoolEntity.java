package com.Modal;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by apple on 04/01/17.
 */
@Entity
@Table(name = "school", schema = "Tuition", catalog = "")
public class SchoolEntity  extends ResourceSupport {
    private Integer schoolId;
    private String schoolName;

    @Id
    @Column(name = "school_id", nullable = false)
    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Basic
    @Column(name = "school_name", nullable = false, length = 1000)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchoolEntity that = (SchoolEntity) o;

        if (schoolId != null ? !schoolId.equals(that.schoolId) : that.schoolId != null) return false;
        if (schoolName != null ? !schoolName.equals(that.schoolName) : that.schoolName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schoolId != null ? schoolId.hashCode() : 0;
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        return result;
    }
}
