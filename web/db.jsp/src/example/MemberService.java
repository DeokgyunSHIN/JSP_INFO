package example;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class MemberService extends DBInfo{

    public List<MemberInfo> MemberSelect(){
        List<MemberInfo> memberList = new ArrayList<>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn= DriverManager.getConnection(url,dbUserId,dbPassword);

            StringBuffer sb=new StringBuffer();
            sb.append("select * from member");

            prst= conn.prepareStatement(sb.toString());

            rs= prst.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("member_type")+", "+rs.getString("user_id")
                +", "+rs.getString("password")+", "+rs.getString("name"));
                MemberInfo member=new MemberInfo();
                member.setMember_type(rs.getString("member_type"));
                member.setUser_id(rs.getString("user_id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                memberList.add(member);
            }
        }catch (Exception e){

            e.printStackTrace();
        }finally {
            try{
                if(rs!=null && !rs.isClosed()){
                    rs.close();
                }
                if(prst!=null && !prst.isClosed()){
                    prst.close();
                }
                if(conn!=null && !conn.isClosed()){
                    conn.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return memberList;
    }
}
