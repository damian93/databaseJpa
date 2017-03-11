package pl.databasejpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 *
 * @author damia
 */
@Entity
@Table(name = "test.dictionary")
@Indexed
@NamedQueries({
    @NamedQuery(name = "Dictionary.findAll", query = "SELECT d FROM Dictionary d"),
    @NamedQuery(name = "Dictionary.findById", query = "SELECT d FROM Dictionary d WHERE d.id = :id"),
    @NamedQuery(name = "Dictionary.findByName", query = "SELECT d FROM Dictionary d WHERE d.name = :name"),
    @NamedQuery(name = "Dictionary.findByDescription", query = "SELECT d FROM Dictionary d WHERE d.description = :description")})
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "dicSeq")
    @SequenceGenerator(name = "dicSeq", sequenceName = "test.dicseq", allocationSize = 50)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @Field
    private String name;
    @Column(name = "description")
    private String description;
    @IndexedEmbedded(depth = 1)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dicId", fetch = FetchType.LAZY)
    private List<Records> recordsList;

    public Dictionary() {
    }

    public Dictionary(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Records> getRecordsList() {
        return recordsList;
    }

    public void setRecordsList(List<Records> recordsList) {
        this.recordsList = recordsList;
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
        if (!(object instanceof Dictionary)) {
            return false;
        }
        Dictionary other = (Dictionary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.databasejpa.Dictionary[ id=" + id + " ]";
    }

}
