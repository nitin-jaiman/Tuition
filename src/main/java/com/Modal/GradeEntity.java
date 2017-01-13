package com.Modal;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by apple on 28/12/16.
 */
@Entity
@Table(name = "grade", schema = "Tuition", catalog = "")
public class GradeEntity extends ResourceSupport {
    private Integer gradeId;
    private String gradeName;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "grade_id", nullable = false)
    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "grade_name", nullable = true, length = 500)
    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradeEntity that = (GradeEntity) o;

        if (gradeId != null ? !gradeId.equals(that.gradeId) : that.gradeId != null) return false;
        if (gradeName != null ? !gradeName.equals(that.gradeName) : that.gradeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gradeId != null ? gradeId.hashCode() : 0;
        result = 31 * result + (gradeName != null ? gradeName.hashCode() : 0);
        return result;
    }
}
