package training.database.jdbc.with_gui.address.address_part4.dao;

import training.database.jdbc.with_gui.address.address_part4.model.Person;

import java.util.List;


public interface PersonDAO
{
    /**
     * @return
     */
    public List<Person> findAllPersons();
    
    public boolean savePerson(Person person);
    
    public boolean deletePerson(int id);
    
    public boolean updatePerson(int id, String fieldName, String newValue);
    
}
