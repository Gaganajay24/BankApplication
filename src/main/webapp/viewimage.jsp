<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
System.out.println(id);
String connectionURL = "jdbc:mysql://localhost:3306/Banking";
String user = "root";
String pass = "password";
String firstname=(String) session.getAttribute("firstname");
System.out.println(firstname);
Connection con = null;
try{
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection(connectionURL, user, pass);
    PreparedStatement ps = con.prepareStatement("select  * from creditCard where age=44");
    ResultSet rs = ps.executeQuery();
    if(rs.next()){
        Blob blob = rs.getBlob("adhar");
        System.out.println("blob : "+blob);
        byte byteArray[] = blob.getBytes(1, (int)blob.length());
        
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        OutputStream os = response.getOutputStream();
        os.write(byteArray);
        os.flush();
        os.close();
    }
}
catch(Exception e){
   // e.printStackTrace();
   
   System.out.println("not possible!!");
}
finally{
    if(con != null){
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
%>