import java.sql.*;

public class StudentJDBC {

    static final String URL = "jdbc:mysql://localhost:3306/college";
    static final String USER = "root";
    static final String PASSWORD = "root";   // Change to your MySQL password

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Insert Records
            String insert = "INSERT INTO student VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insert);

            ps.setInt(1, 101);
            ps.setString(2, "Rahul");
            ps.setString(3, "CSE");
            ps.setInt(4, 90);
            ps.executeUpdate();

            ps.setInt(1, 102);
            ps.setString(2, "Sneha");
            ps.setString(3, "ISE");
            ps.setInt(4, 91);
            ps.executeUpdate();

            System.out.println("Records Inserted Successfully.\n");

            // Update
            String update = "UPDATE student SET marks=? WHERE rollNo=?";
            PreparedStatement ps1 = con.prepareStatement(update);

            ps1.setInt(1, 95);
            ps1.setInt(2, 101);
            ps1.executeUpdate();

            System.out.println("Record Updated Successfully.\n");

            // Search
            String search = "SELECT * FROM student WHERE rollNo=?";
            PreparedStatement ps2 = con.prepareStatement(search);

            ps2.setInt(1, 101);

            ResultSet rs = ps2.executeQuery();

            System.out.println("Student Details\n");

            while(rs.next()) {
                System.out.println("Roll No : " + rs.getInt("rollNo"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Marks   : " + rs.getInt("marks"));
            }

            // Display
            String display = "SELECT * FROM student";
            PreparedStatement ps3 = con.prepareStatement(display);

            ResultSet rs1 = ps3.executeQuery();

            System.out.println("\nStudent Records");
            System.out.println("----------------------------------------------");
            System.out.printf("%-8s %-10s %-12s %-5s\n",
                    "Roll", "Name", "Department", "Marks");
            System.out.println("----------------------------------------------");

            while(rs1.next()) {
                System.out.printf("%-8d %-10s %-12s %-5d\n",
                        rs1.getInt("rollNo"),
                        rs1.getString("name"),
                        rs1.getString("department"),
                        rs1.getInt("marks"));
            }

            rs.close();
            rs1.close();
            ps.close();
            ps1.close();
            ps2.close();
            ps3.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
