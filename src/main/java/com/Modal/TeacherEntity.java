package com.Modal;

import com.Services.BatchService;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apple on 28/12/16.
 */
@Entity
@Table(name = "Teacher", schema = "Tuition", catalog = "")
public class TeacherEntity  extends ResourceSupport {
    private Integer teacherId;
    private String teacherFirstName;
    private String teacherLastName;
    private Integer teacherExperience;
    private InstituteEntity instituteEntity;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id")
    public InstituteEntity getInstituteEntity() {
        return instituteEntity;
    }

    public void setInstituteEntity(InstituteEntity instituteEntity) {
        this.instituteEntity = instituteEntity;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "teacher_id", nullable = false)
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "teacher_first_name", nullable = true, length = 255)
    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    @Basic
    @Column(name = "teacher_last_name", nullable = true, length = 255)
    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    @Basic
    @Column(name = "teacher_experience", nullable = true)
    public Integer getTeacherExperience() {
        return teacherExperience;
    }

    public void setTeacherExperience(Integer teacherExperience) {
        this.teacherExperience = teacherExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherEntity that = (TeacherEntity) o;

        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (teacherFirstName != null ? !teacherFirstName.equals(that.teacherFirstName) : that.teacherFirstName != null)
            return false;
        if (teacherLastName != null ? !teacherLastName.equals(that.teacherLastName) : that.teacherLastName != null)
            return false;
        if (teacherExperience != null ? !teacherExperience.equals(that.teacherExperience) : that.teacherExperience != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherId != null ? teacherId.hashCode() : 0;
        result = 31 * result + (teacherFirstName != null ? teacherFirstName.hashCode() : 0);
        result = 31 * result + (teacherLastName != null ? teacherLastName.hashCode() : 0);
        result = 31 * result + (teacherExperience != null ? teacherExperience.hashCode() : 0);
        return result;
    }
}
