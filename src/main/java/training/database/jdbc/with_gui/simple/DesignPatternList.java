package training.database.jdbc.with_gui.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static training.database.DatabaseAccessData.CIMDATA_DATABASE;
import static training.database.DatabaseAccessData.PASSWORD;
import static training.database.DatabaseAccessData.URL;
import static training.database.DatabaseAccessData.USER;


public class DesignPatternList
{
    private final List<DesignPattern>
        designPatternList = new ArrayList<>();
    
    
    public DesignPatternList()
    {
        try
        {
            Connection con = DriverManager.getConnection(URL + CIMDATA_DATABASE, USER, PASSWORD);
            Statement selectAllStatement = con.createStatement();
            ResultSet rs = selectAllStatement.executeQuery("SELECT * FROM designpattern");
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String beschreibe = rs.getString("beschreibung");
                
                this.designPatternList.add(new DesignPattern(id, name, beschreibe));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public List<DesignPattern> getDesignpatternList()
    {
        return this.designPatternList;
    }
}
