package example;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class MemberService extends DBInfo {
    public MemberInfo detail(String memberType, String userId) {
        MemberInfo member = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUserId, dbPassword);

            StringBuffer sb = new StringBuffer();
            sb.append("select m.member_type, m.user_id,m.password, m.name,");
            sb.append(" md.mobile_no, md.marketing_yn, md.register_date");
            sb.append(" from member m ");
            sb.append(" left join member_detail md on md.member_type = m.member_type and m.user_id = md.user_id");
            sb.append(" where m.member_type = ? and m.user_id = ?");

            prst = conn.prepareStatement(sb.toString());
            prst.setString(1, memberType);
            prst.setString(2, userId);
            rs = prst.executeQuery();

            if (rs.next()) {
                member = new MemberInfo();

                member.setMember_type(rs.getString("member_type"));
                member.setUser_id(rs.getString("user_id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setMobile_no(rs.getString("mobile_no"));
                member.setMarketing_yn(rs.getBoolean("marketing_yn"));
                member.setRegister_dete(rs.getDate("register_date"));
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (prst != null && !prst.isClosed()) {
                    prst.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return member;
    }

    public List<MemberInfo> MemberSelect() {
        List<MemberInfo> memberList = new ArrayList<>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUserId, dbPassword);

            StringBuffer sb = new StringBuffer();
            sb.append("select * from member");

            prst = conn.prepareStatement(sb.toString());

            rs = prst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("member_type") + ", " + rs.getString("user_id")
                        + ", " + rs.getString("password") + ", " + rs.getString("name"));
                MemberInfo member = new MemberInfo();
                member.setMember_type(rs.getString("member_type"));
                member.setUser_id(rs.getString("user_id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                memberList.add(member);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (prst != null && !prst.isClosed()) {
                    prst.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return memberList;
    }
}
