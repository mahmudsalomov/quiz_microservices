package uz.maniac4j.data.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;

@Entity
public class ParticipantBlock extends AbstractEntity {

    private String description;
    private String block;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private String result;
    private boolean access;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getBlock() {
        return block;
    }
    public void setBlock(String block) {
        this.block = block;
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public boolean isAccess() {
        return access;
    }
    public void setAccess(boolean access) {
        this.access = access;
    }

}
