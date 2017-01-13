package com.Modal;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by apple on 28/12/16.
 */
@Entity
@Table(name = "branch", schema = "Tuition", catalog = "")
public class BranchEntity extends ResourceSupport {
    private Integer branchId;
    private String branchName;
    private InstituteEntity instituteEntity;
    private AddressEntity addressEntity;


    @ManyToOne
    @JoinColumn(name="address_id")
    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

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
    @Column(name = "branch_id", nullable = false)
    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    @Basic
    @Column(name = "branch_name", nullable = true)
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchEntity that = (BranchEntity) o;

        if (branchId != null ? !branchId.equals(that.branchId) : that.branchId != null) return false;
        if (branchName != null ? !branchName.equals(that.branchName) : that.branchName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = branchId != null ? branchId.hashCode() : 0;
        result = 31 * result + (branchName != null ? branchName.hashCode() : 0);
        return result;
    }
}
