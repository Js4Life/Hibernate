import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "alien_table")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Alien {

    @Id
    private int aid;

    private String aname;

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



//    @OneToMany(mappedBy = "alien",fetch = FetchType.EAGER)
//    private Collection<Laptop> laps = new ArrayList<Laptop>();


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

//    public Collection<Laptop> getLaps() {
//        return laps;
//    }
//
//    public void setLaps(Collection<Laptop> laps) {
//        this.laps = laps;
//    }
}
