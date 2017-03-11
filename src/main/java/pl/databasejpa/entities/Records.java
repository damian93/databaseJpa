package pl.databasejpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author damia
 */
@Entity
@Table(name = "test.records")
@NamedQueries({
    @NamedQuery(name = "Records.findAll", query = "SELECT r FROM Records r"),
    @NamedQuery(name = "Records.findById", query = "SELECT r FROM Records r WHERE r.id = :id"),
    @NamedQuery(name = "Records.findByCode", query = "SELECT r FROM Records r WHERE r.code = :code"),
    @NamedQuery(name = "Records.findByValue", query = "SELECT r FROM Records r WHERE r.value = :value")})
public class Records implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "recSeq")
    @SequenceGenerator(name = "recSeq", sequenceName = "test.recseq", allocationSize = 50)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "code")
    @Field
    private String code;
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "dicId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dictionary dicId;

    public Records() {
    }

    public Records(Long id) {
        this.id = id;
    }

    public Records(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Dictionary getDicId() {
        return dicId;
    }

    public void setDicId(Dictionary dicId) {
        this.dicId = dicId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Records)) {
            return false;
        }
        Records other = (Records) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.databasejpa.Records[ id=" + id + " ]";
    }

}
