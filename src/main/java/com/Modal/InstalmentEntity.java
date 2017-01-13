package com.Modal;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by apple on 28/12/16.
 */
@Entity
@Table(name = "instalment", schema = "Tuition", catalog = "")
public class InstalmentEntity extends ResourceSupport {
    private Integer instalmentId;
    private Double instalmentMoney;

    @Id
    @Column(name = "instalment_id", nullable = false)
    public Integer getInstalmentId() {
        return instalmentId;
    }

    public void setInstalmentId(Integer instalmentId) {
        this.instalmentId = instalmentId;
    }

    @Basic
    @Column(name = "instalment_money", nullable = false, precision = 0)
    public Double getInstalmentMoney() {
        return instalmentMoney;
    }

    public void setInstalmentMoney(Double instalmentMoney) {
        this.instalmentMoney = instalmentMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstalmentEntity that = (InstalmentEntity) o;

        if (instalmentId != null ? !instalmentId.equals(that.instalmentId) : that.instalmentId != null) return false;
        if (instalmentMoney != null ? !instalmentMoney.equals(that.instalmentMoney) : that.instalmentMoney != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = instalmentId != null ? instalmentId.hashCode() : 0;
        result = 31 * result + (instalmentMoney != null ? instalmentMoney.hashCode() : 0);
        return result;
    }
}
