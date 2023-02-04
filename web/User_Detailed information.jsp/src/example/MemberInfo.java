package example;

import java.util.Date;

public class MemberInfo {
    private String member_type;
    private String user_id;
    private String password;
    private String name;

    private String mobile_no;

    private boolean marketing_yn;

    private Date register_dete;

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public boolean isMarketing_yn() {
        return marketing_yn;
    }

    public void setMarketing_yn(boolean marketing_yn) {
        this.marketing_yn = marketing_yn;
    }

    public Date getRegister_dete() {
        return register_dete;
    }

    public void setRegister_dete(Date register_dete) {
        this.register_dete = register_dete;
    }

    public String getMember_type() {
        return member_type;
    }

    public void setMember_type(String member_type) {
        this.member_type = member_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
