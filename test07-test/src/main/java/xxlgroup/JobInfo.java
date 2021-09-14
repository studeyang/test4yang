package xxlgroup;

import java.util.Objects;

/**
 * @author Administrator
 */
public class JobInfo {

    private String id;

    private String group;

    public JobInfo(String id, String group) {
        this.id = id;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "id='" + id + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobInfo jobInfo = (JobInfo) o;
        return Objects.equals(id, jobInfo.id) &&
                Objects.equals(group, jobInfo.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group);
    }
}
