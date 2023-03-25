package training.database.jdbc.with_gui.address.my_address_db.dao;


import training.database.jdbc.with_gui.address.my_address_db.model.Person;

import java.util.List;

public interface PersonDAO {
	
	public List<Person> findAllPersons();
	public boolean savePerson(Person person);
	public boolean deletePerson(int id);
	public boolean updatePerson(int id, String fieldName, String newValue);

}
