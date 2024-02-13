package repositories;


import com.data.interfaces.IDB;
import com.models.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class studentRepository implements IstudentRepository {
    private final IDB db;  // Dependency Injection

    public studentRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createstudent(Student student) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(name,surname,gender) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, student.getName());
            st.setString(2, student.getSurname());
            st.setBoolean(3, student.getClass());

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return false;
    }

    public Student studentRepository(int id, IDB db) {
        this.db = db;
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,class FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"));
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }

    @Override
    public List<Student> getAllstudents() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,class FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Student> users = new LinkedList<>();
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("class"));

                users.add(student);
            }

            return users;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                      con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }
}