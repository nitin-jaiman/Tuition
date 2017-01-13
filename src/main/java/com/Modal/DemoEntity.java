package com.Modal;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by apple on 28/12/16.
 */
@Entity
@Table(name = "Demo", schema = "Tuition", catalog = "")
public class DemoEntity extends ResourceSupport {
    private Integer demoId;
    private String name;

    @Id
    @Column(name = "demo_id", nullable = false)
    public Integer getDemoId() {
        return demoId;
    }

    public void setDemoId(Integer demoId) {
        this.demoId = demoId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DemoEntity that = (DemoEntity) o;

        if (demoId != null ? !demoId.equals(that.demoId) : that.demoId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = demoId != null ? demoId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
