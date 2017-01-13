package com.Modal;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apple on 28/12/16.
 */
@Entity
@Table(name = "batch", schema = "Tuition", catalog = "")
public class BatchEntity extends ResourceSupport {
    private Integer batchId;
    private Time batchStartTime;
    private Time batchEndTime;
    private Integer batchMaximumStrength;
    private Byte batchIsTrial;
    private Integer batchTrialDays;
    private Double batchDiscount;
    private Date batchStartDate;
    private Date batchEndDate;
    private Double batchExtraExpenses;
    private BranchEntity branchEntity;

    private Set<TeacherEntity> teachers = new HashSet<TeacherEntity>(0);
    private Set<StudentEntity> students = new HashSet<StudentEntity>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_batch",  joinColumns = {
            @JoinColumn(name = "batch_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") })
    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_batch",  joinColumns = {
            @JoinColumn(name = "batch_id") },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id") })
    public Set<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    @ManyToOne
    @JoinColumn(name = "branch_id")
    public BranchEntity getBranchEntity() {
        return branchEntity;
    }

    public void setBranchEntity(BranchEntity branchEntity) {
        this.branchEntity = branchEntity;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "batch_id", nullable = false)
    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    @Basic
    @Column(name = "batch_start_time", nullable = true)
    public Time getBatchStartTime() {
        return batchStartTime;
    }

    public void setBatchStartTime(Time batchStartTime) {
        this.batchStartTime = batchStartTime;
    }

    @Basic
    @Column(name = "batch_end_time", nullable = true)
    public Time getBatchEndTime() {
        return batchEndTime;
    }

    public void setBatchEndTime(Time batchEndTime) {
        this.batchEndTime = batchEndTime;
    }

    @Basic
    @Column(name = "batch_maximum_strength", nullable = true)
    public Integer getBatchMaximumStrength() {
        return batchMaximumStrength;
    }

    public void setBatchMaximumStrength(Integer batchMaximumStrength) {
        this.batchMaximumStrength = batchMaximumStrength;
    }

    @Basic
    @Column(name = "batch_is_trial", nullable = true)
    public Byte getBatchIsTrial() {
        return batchIsTrial;
    }

    public void setBatchIsTrial(Byte batchIsTrial) {
        this.batchIsTrial = batchIsTrial;
    }

    @Basic
    @Column(name = "batch_trial_days", nullable = true)
    public Integer getBatchTrialDays() {
        return batchTrialDays;
    }

    public void setBatchTrialDays(Integer batchTrialDays) {
        this.batchTrialDays = batchTrialDays;
    }

    @Basic
    @Column(name = "batch_discount", nullable = true, precision = 0)
    public Double getBatchDiscount() {
        return batchDiscount;
    }

    public void setBatchDiscount(Double batchDiscount) {
        this.batchDiscount = batchDiscount;
    }

    @Basic
    @Column(name = "batch_start_date", nullable = true)
    public Date getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(Date batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    @Basic
    @Column(name = "batch_end_date", nullable = true)
    public Date getBatchEndDate() {
        return batchEndDate;
    }

    public void setBatchEndDate(Date batchEndDate) {
        this.batchEndDate = batchEndDate;
    }

    @Basic
    @Column(name = "batch_extra_expenses", nullable = true, precision = 0)
    public Double getBatchExtraExpenses() {
        return batchExtraExpenses;
    }

    public void setBatchExtraExpenses(Double batchExtraExpenses) {
        this.batchExtraExpenses = batchExtraExpenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchEntity that = (BatchEntity) o;

        if (batchId != null ? !batchId.equals(that.batchId) : that.batchId != null) return false;
        if (batchStartTime != null ? !batchStartTime.equals(that.batchStartTime) : that.batchStartTime != null)
            return false;
        if (batchEndTime != null ? !batchEndTime.equals(that.batchEndTime) : that.batchEndTime != null) return false;
        if (batchMaximumStrength != null ? !batchMaximumStrength.equals(that.batchMaximumStrength) : that.batchMaximumStrength != null)
            return false;
        if (batchIsTrial != null ? !batchIsTrial.equals(that.batchIsTrial) : that.batchIsTrial != null) return false;
        if (batchTrialDays != null ? !batchTrialDays.equals(that.batchTrialDays) : that.batchTrialDays != null)
            return false;
        if (batchDiscount != null ? !batchDiscount.equals(that.batchDiscount) : that.batchDiscount != null)
            return false;
        if (batchStartDate != null ? !batchStartDate.equals(that.batchStartDate) : that.batchStartDate != null)
            return false;
        if (batchEndDate != null ? !batchEndDate.equals(that.batchEndDate) : that.batchEndDate != null) return false;
        if (batchExtraExpenses != null ? !batchExtraExpenses.equals(that.batchExtraExpenses) : that.batchExtraExpenses != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = batchId != null ? batchId.hashCode() : 0;
        result = 31 * result + (batchStartTime != null ? batchStartTime.hashCode() : 0);
        result = 31 * result + (batchEndTime != null ? batchEndTime.hashCode() : 0);
        result = 31 * result + (batchMaximumStrength != null ? batchMaximumStrength.hashCode() : 0);
        result = 31 * result + (batchIsTrial != null ? batchIsTrial.hashCode() : 0);
        result = 31 * result + (batchTrialDays != null ? batchTrialDays.hashCode() : 0);
        result = 31 * result + (batchDiscount != null ? batchDiscount.hashCode() : 0);
        result = 31 * result + (batchStartDate != null ? batchStartDate.hashCode() : 0);
        result = 31 * result + (batchEndDate != null ? batchEndDate.hashCode() : 0);
        result = 31 * result + (batchExtraExpenses != null ? batchExtraExpenses.hashCode() : 0);
        return result;
    }
}
