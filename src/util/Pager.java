package util;

public class Pager {
	private int currentPage;   //当前页面
	private int PageSize=3;  //每页记录数
	private int totalSize; //总记录数
	private int totalPage; //总页数
	
	private boolean hasFirst;
	private boolean hasPrevious;
	private boolean hasNext;
	private boolean hasLast;
	
	//构造方法
	public Pager (int currentPage,int totalSize){
		this.currentPage=currentPage;
		this.totalSize=totalSize;
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	//获得总页数
	public int getTotalPage() {
		totalPage = totalSize/PageSize;
		if(totalSize%PageSize!=0)
			totalPage++;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	//是否有首页
	public boolean isHasFirst() {
		if(currentPage==1)
			return false;
		return true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	
	//是否有上一页
	public boolean isHasPrevious() {
		if(isHasFirst())
			return true;
		return false;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	
	//是否有下一页
	public boolean isHasNext() {
		if(isHasLast())
			return true;
		return false;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	//是否有尾页
	public boolean isHasLast() {
		if(currentPage==getTotalPage())
			return false;
		return true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	
	
	
	
}
