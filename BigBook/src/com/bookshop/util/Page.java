package com.bookshop.util;

public class Page<T> {
	private Long totalcount;//������
	private Long pagecount=(long) 4;//ÿҳ��ʾ������
	private Long totalpage;//��ҳ��
	private Long dpage;//��ǰ��ʾ��ҳ��
	public Long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}
	public Long getPagecount() {
		return pagecount;
	}
	public void setPagecount(Long pagecount) {
		this.pagecount = pagecount;
	}
	public Long getTotalpage() {
		return totalpage;
	}
	public void setTotalpage() {
		if(totalcount%pagecount==0) {
			this.totalpage =  (totalcount/pagecount);
		}else {
			this.totalpage =  (totalcount/pagecount+1);
			
		}
	}
	public Long getDpage() {
		return dpage;
	}
	public void setDpage(Long dpage) {
		this.dpage = dpage;
	}

}
