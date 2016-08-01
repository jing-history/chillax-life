package tk.jingzing.model;

/**
 * @Description:城市基类
 * Created by Louis Wang on 2016/8/1.
 */

public class City extends BaseEntity{

    private String name;

    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
