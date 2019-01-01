package action;

import java.util.Map;

import model.Cart;
import service.impl.IBookService;
import vo.Book;
import vo.Orderitem;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingAction extends ActionSupport {
	private int quantity;
	private Integer bookid;
	private IBookService bookService;
	//添加到购物车
	public String addToCart() throws Exception{
		Book book=bookService.getBookbyId(bookid);
		Orderitem orderitem=new Orderitem();
		orderitem.setBook(book);
		orderitem.setQuantity(quantity);
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		cart.addBook(bookid, orderitem);
		session.put("cart",cart);
		return SUCCESS;
	}
	
	public String updateCart() throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		cart.updateCart(bookid, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}

	
	//属性bookid的getter/setter方法
	public Integer getBookid(){
		return bookid;
	}
	public void setBookid(Integer bookid){
		this.bookid=bookid;
	}
	//属性quantity的getter/setter方法
	public int getQuantity(){
		return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	//属性bookService的getter/setter方法
	public IBookService getBookService(){
		return bookService;
	}
	public void setBookService(IBookService bookService){
		this.bookService=bookService;
	}

}
