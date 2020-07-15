package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class CategoryComboBoxModel implements ComboBoxModel<String>{

	public List<String> cs=new ArrayList<String>();
	
	String c;
	public CategoryComboBoxModel() {
		cs.add("��ͨ");
		cs.add("ס��");
		cs.add("��ʳ");
		cs.add("����");
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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO �Զ����ɵķ������
		
	}

	//�����ѡ�񣬽�ѡ���ֵ ����c
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
