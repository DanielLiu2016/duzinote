package cn.duzi.note.mvp.bean;

/**
 * Simple to Introduction
 *
 * @ProjectName: duzinote
 * @Package: cn.duzi.note.mvp.bean
 * @Description:登录Bean文件
 * @Author: Majest
 * @CreateDate: 2018/1/7 16:55
 * @UpdateUser: Majest
 * @UpdateDate: 2018/1/7 16:55
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class UserBean {

    private String username;
    private String password;

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
