package training.database.jdbc.with_gui.address.my_address_db.dao;

import training.database.jdbc.with_gui.address.DBConnect;
import training.database.jdbc.with_gui.address.DBConnectException;
import training.database.jdbc.with_gui.address.my_address_db.model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLPersonDAO implements PersonDAO
{
    private DBConnect dbconnect;
    
    public MySQLPersonDAO() throws DBConnectException
    {
        this.dbconnect = DBConnect.getInstance();
    }
    
    
    @Override
    public List<Person> findAllPersons()
    {
        List<Person> personList = new ArrayList<>();
        Connection con = this.dbconnect.getConnection();
        
        try
        {
            Statement selectAllStatement = con.createStatement();
            ResultSet rs = selectAllStatement.executeQuery("SELECT * FROM adressen");
            
            while(rs.next())
            {
                personList.add(new Person(rs.getInt("id"),
                    rs.getString("vorname"),
                    rs.getString("nachname"),
                    rs.getInt("plz"),
                    rs.getString("ort"),
                    rs.getString("strasse"),
                    rs.getString("telefon"),
                    rs.getString("mobil"),
                    rs.getString("email")));
                
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return personList;
    }
    
    @Override
    public boolean savePerson(Person person)
    {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean deletePerson(int id)
    {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean updatePerson(int id, String fieldName, String newValue)
    {
        // TODO Auto-generated method stub
        return false;
    }
    
    public static void main(String[] args) throws DBConnectException
    {
        MySQLPersonDAO dao = new MySQLPersonDAO();
        dao.findAllPersons().forEach(System.out::println);
    }
}
