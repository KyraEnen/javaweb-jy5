package com.itdr.pojo;

public class Users {

    //type=0 用户，type=1 管理员
    //stats=0 不被禁用  stats=1 被禁用
    private Integer id;
    private String uname;
    private String psd;
    private String tel;
    private Integer type;
    private Integer stats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStats() {
        return stats;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Users() {
    }

    public Users(Integer id, String uname) {
        this.id = id;
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", psd='" + psd + '\'' +
                ", type=" + type +
                ", stats=" + stats +
                '}';
    }
}
