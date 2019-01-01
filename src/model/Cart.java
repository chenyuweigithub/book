package model;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import vo.Book;
import vo.Orderitem;

public class Cart {
	protected Map<Integer, Orderitem> items;
	public Cart(){
		if(items==null)
			items=new HashedMap();
	}
	public void addBook(Integer bookid,Orderitem orderitem){
		//�Ƿ���ڣ�������ڣ����������
		//��������ڣ�����ӵ�����
		if(items.containsKey("bookid")){
			Orderitem _orderitem=items.get(bookid);
			orderitem.setQuantity(_orderitem.getOrderitemid()+orderitem.getQuantity());
			items.put(bookid,_orderitem);
		}
		else{
			items.put(bookid,orderitem);
		}
	}
	//���¹��ﳵ�Ĺ����鼮����
	public void updateCart(Integer bookid,int quantity){
		Orderitem orderitem=items.get(bookid);
		orderitem.setQuantity(quantity);
		items.put(bookid, orderitem);
	}
	//�����ܼ۸�
	public int getTotalPrice(){
		int totalPrice=0;
		for(Iterator it=items.values().iterator();it.hasNext();){
			Orderitem orderitem=(Orderitem)it.next();
			Book book=orderitem.getBook();
			int quantity=orderitem.getQuantity();
			totalPrice+=book.getPrice()*quantity;
		}
		return totalPrice;
	}
	
	public Map<Integer, Orderitem>getItems() {
		return items;
	}
	public void setItems(Map<Integer, Orderitem>items) {
		this.items=items;
	}
}
