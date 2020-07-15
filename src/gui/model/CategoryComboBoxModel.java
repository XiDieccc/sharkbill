package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class CategoryComboBoxModel implements ComboBoxModel<String>{

	public List<String> cs=new ArrayList<String>();
	
	String c;
	public CategoryComboBoxModel() {
		cs.add("交通");
		cs.add("住宿");
		cs.add("饮食");
		cs.add("购物");
		c=cs.get(3);
		
	}
	
	@Override
	public int getSize() {
		
		return cs.size();
	}

	@Override
	public String getElementAt(int index) {
		
		return cs.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO 自动生成的方法存根
		
	}

	//鼠标点击选择，将选择的值 赋给c
	@Override
	public void setSelectedItem(Object anItem) {
		c=(String)anItem;
		
	}
	//get c
	@Override
	public Object getSelectedItem() {

		return c;
	}
	

}
