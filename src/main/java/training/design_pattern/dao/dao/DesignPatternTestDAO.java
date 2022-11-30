package training.design_pattern.dao.dao;

import training.design_pattern.dao.model.DesignPattern;

import java.util.ArrayList;
import java.util.List;



public class DesignPatternTestDAO implements DesignPatternDAO{
	private final List<DesignPattern> list = new ArrayList<>();
	private int id;
	
	public DesignPatternTestDAO()
	{
		DesignPattern mvc = new DesignPattern(1, "MVC", "Trennung Daten und View");
		DesignPattern singleton = new DesignPattern(2, "Singleton", "Nur eine Instanz");
		add(mvc);
		add(singleton);
		id = 2;
	}
	
	@Override
	public boolean save(DesignPattern designPattern) {
		id++;
		designPattern.setId(id);
		add(designPattern);
		return true;
	}

	@Override
	public List<DesignPattern> findAll() {
		return list;
	}
	
	private void add(DesignPattern designPattern)
	{
		list.add(new DesignPattern(designPattern.getId(), designPattern.getName(), designPattern.getBeschreibung()));
	}
}
