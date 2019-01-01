package action;

import java.util.List;
import java.util.Map;

import service.impl.*;
import util.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	private ICatalogService catalogService;
	private Integer catalogid;
	private IBookService bookService;
	private Integer currentPage=1;
	private String bookname;
	
	//分页显示图书
	public String browseBookPaging() throws Exception{

		int totalSize=bookService.getTotalbyCatalog(catalogid); //获得totalSize（总记录数）
		Pager pager=new Pager(currentPage,totalSize);
		List books=bookService.getBookbyCatalogidPaging(catalogid, currentPage, pager.getPageSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("pager",pager);
		return SUCCESS;
	}

	public String browseCatalog() {
		List catalogs = catalogService.getAllCatalogs();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return SUCCESS;
	}
	
	public String browseBook(){
		System.out.print(catalogid);
		List books = bookService.getBookbycatalogid(catalogid);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
		
	}
	public String searchBook(){
		StringBuffer hql=new StringBuffer("from Book b ");
		if(bookname!=null&&bookname.length()!=0)
			hql.append("where b.bookname like '%"+bookname+"%'");
		List books=bookService.getRequiredBookbyHql(hql.toString());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books",books);
		return SUCCESS;
	}
	
	public String searchBookPaging(){
		StringBuffer hql=new StringBuffer("from Book b ");
		if(bookname!=null&&bookname.length()!=0)
			hql.append("where b.bookname like '%"+bookname+"%'");
		int totalSize = bookService.getTotalbyRequiredBook(hql.toString());
		Pager pager=new Pager(currentPage,totalSize);
		List books=bookService.getRequiredBookbyHqlPaging(hql.toString(), currentPage, pager.getPageSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books",books);
		request.put("pager",pager);
		return SUCCESS;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public ICatalogService getCatalogService() {
		return catalogService;
	}
	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}
	public Integer getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

}
