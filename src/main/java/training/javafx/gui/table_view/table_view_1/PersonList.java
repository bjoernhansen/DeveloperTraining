package training.javafx.gui.table_view.table_view_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonList {
	private List<Person> personList = new ArrayList<>();

	public PersonList() {
		this.personList.addAll(Arrays.asList(
				new Person("Max", "Meier", LocalDate.of(1977, 10, 3), 1),
				new Person("Ina", "Müller", LocalDate.of(1973, 6, 1), 2),
				new Person("Emma", "Weber", LocalDate.of(1971, 4, 12), 3),
				new Person("Anton", "Schultz", LocalDate.of(1967, 9, 6), 4)

		));

	}

	public List<Person> getPersonList() {
		return this.personList;
	}

}
