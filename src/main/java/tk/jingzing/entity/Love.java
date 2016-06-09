package tk.jingzing.entity;

import java.sql.Timestamp;

/**
 * Created by wangyunjing on 16/6/9.
 */
public class Love {

    private Integer id;

    private  String name;

    private Timestamp first_time ;

    private Timestamp create_time ;

    private Timestamp update_time ;

    private String remarks;

    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getFirst_time() {
        return first_time;
    }

    public void setFirst_time(Timestamp first_time) {
        this.first_time = first_time;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
