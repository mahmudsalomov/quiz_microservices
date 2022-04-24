package uz.maniac4j.data.entity;

import javax.persistence.Entity;

@Entity
public class Category extends AbstractEntity {

    private String name;
    private String description;
    private String organization;

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
    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }

}
