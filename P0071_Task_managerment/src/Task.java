
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Yankee
 */
public class Task {

    private int id;
    private String taskTypeId;
    private String requirementName;
    private Date date;
    private String planFrom;
    private String planTo;
    private String assign;
    private String reviewer;

    public Task() {
        
    }

    public Task(int id, String taskTypeId, String requirementName, Date date, String planFrom, String planTo, String assign, String reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getassign() {
        return assign;
    }

    public void setassign(String assign) {
        this.assign = assign;
    }

    public String getreviewer() {
        return reviewer;
    }

    public void setreviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String result = String.format("%-5s | %-10s | %-15s | %-15s | %-15s | %-15s | %-15s\n",
                id, requirementName, taskTypeId, sdf.format(date), Double.parseDouble(getPlanTo()) - Double.parseDouble(planFrom), assign, reviewer);
        return result;
    }

}
