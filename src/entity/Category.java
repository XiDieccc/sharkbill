package entity;

public class Category {
	public int id;
	public String name;//分类名称
	public int recordNumber;//该分类消费次数，对应着Record表
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}
	
	/**
	 * 在JComboBox中显示会显示分类名称
	 */
	@Override
	public String toString() {
		
		return name;
	}
	
	
}
