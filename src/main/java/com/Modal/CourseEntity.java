package com.Modal;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by apple on 28/12/16.
 */
@Entity
@Table(name = "course", schema = "Tuition", catalog = "")
public class CourseEntity extends ResourceSupport {
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private Double courseFee;
    private InstituteEntity instituteEntity;


    @ManyToOne
    @JoinColumn(name="institute_id")
    public InstituteEntity getInstituteEntity() {
        return instituteEntity;
    }

    public void setInstituteEntity(InstituteEntity instituteEntity) {
        this.instituteEntity = instituteEntity;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "course_id", nullable = false)
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "course_name", nullable = true, length = 500)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "course_description", nullable = true, length = 3000)
    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Basic
    @Column(name = "course_fee", nullable = true, precision = 0)
    public Double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Double courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (courseDescription != null ? !courseDescription.equals(that.courseDescription) : that.courseDescription != null)
            return false;
        if (courseFee != null ? !courseFee.equals(that.courseFee) : that.courseFee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (courseDescription != null ? courseDescription.hashCode() : 0);
        result = 31 * result + (courseFee != null ? courseFee.hashCode() : 0);
        return result;
    }
}
