package training.database.jdbc.with_gui.generic_db.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Entity implements Serializable {
	
	private String tableName;
	private final Map<String, Object> fields = new HashMap<>();

	public Object getFieldValue(String name) {
		return fields.get(name);
	}
	
	
	public void addField(String name, Object obj) {
		fields.put(name, obj);

	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String name) {
		this.tableName = name;
	}

	@Override
	public String toString() {
		return "Entity [tableName=" + tableName + ", fields=" + fields + "]";
	}
}
