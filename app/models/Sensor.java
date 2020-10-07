package models;


import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sensor extends Model {

    @Id
    public long id;

    public String name;

    public String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
