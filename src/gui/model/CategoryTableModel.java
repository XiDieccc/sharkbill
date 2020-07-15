package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class CategoryTableModel implements TableModel{

	String[] columnNames=new String[] {"��������","���Ѵ���"};
	List<String> cs =new ArrayList<String>();
	
	public CategoryTableModel() {
		cs.add("����");
		cs.add("��ͨ");
        cs.add("ס��");
        cs.add("����");
		
	}
	@Override
	public int getRowCount() {
	
		return cs.size();
	}

	@Override
	public int getColumnCount() {

		return columnNames.length;
	}

	//���ñ�ͷ����
	@Override
	public String getColumnName(int columnIndex) {
		
		return columnNames[columnIndex];
	}

	/**
	 * ���ص�Ԫ��ֵ�ĳ���
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {

		return String.class;
	}

	/**
	 * ���ɱ༭
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(0==columnIndex)
            return cs.get(rowIndex);
        if(1==columnIndex)
            return 0;
        return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO �Զ����ɵķ������
		
	}

}
