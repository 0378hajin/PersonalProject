package project.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PageMaker {
//리스트 페이지 하단에 번호를 계산해주는 클래스
	private int totalCount;
	private int startPage; 
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 10;
	private SearchCriteria scri;
	
	
	public SearchCriteria getScri() {
		return scri;
	}
	public void setScri(SearchCriteria scri) {
		this.scri = scri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcDate();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	
	public void calcDate() {
		
		endPage = (int)(Math.ceil(scri.getPage() / (double)displayPageNum) * displayPageNum);
		System.out.println("endPage : " + endPage);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage  = (int)(Math.ceil(totalCount / (double)scri.getPerPageNum()));
		System.out.println("tempEndPage : " + tempEndPage);
		System.out.println("totalCount : " + totalCount);
		System.out.println("scri.getPerPageNum() : " + scri.getPerPageNum());
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = startPage == 1 ? false : true;
		next = endPage * scri.getPerPageNum() >= totalCount ? false : true;
		
		
	}
	
	public String encoding(String keyword) {
		String str = null;
		
		try {
			if (keyword != null) {
				str = URLEncoder.encode(keyword, "UTF-8");
			}
			
			} catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			
		}
		return str;
	}
	

}
