package uz.maniac4j.data.entity;

import javax.persistence.Entity;

@Entity
public class Block extends AbstractEntity {

    private String name;
    private String description;
    private String type;
    private String timeLimit;
    private boolean active;

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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTimeLimit() {
        return timeLimit;
    }
    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

}
