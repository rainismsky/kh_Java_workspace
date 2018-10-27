package pds.model;

import java.util.ArrayList;
import java.util.List;

public class PdsItemListModel{

private List<PdsItem> pdsItemList;
private int requestPage;//
private int totalPageCount;
private int startRow;
private int endRow;

public PdsItemListModel() {
	this(new ArrayList<PdsItem>(),0,0,0,0);
}

public PdsItemListModel(List<PdsItem> PdsItemList, int requestpageNumber,
int totalPagecount, int startRow, int endRow) {

this.pdsItemList = PdsItemList;
this.requestPage = requestpageNumber;
this.totalPageCount = totalPagecount;
this.startRow = startRow;
this.endRow = endRow;
}

public List<PdsItem> getPdsItemList() {
	return pdsItemList;
}

public boolean isHasPdsItem() {
	return ! pdsItemList.isEmpty(); //���� �����ϰ� �ִ� ����Ʈ ��ü
}

public void setPdsItemList(List<PdsItem> pdsItemList) {
	this.pdsItemList = pdsItemList;
}

public int getRequestPage() {
	return requestPage;
}

public void setRequestPage(int requestPage) {
	this.requestPage = requestPage;
}

public int getTotalPageCount() {
	return totalPageCount;
}

public void setTotalPageCount(int totalPageCount) {
	this.totalPageCount = totalPageCount;
}

public int getStartRow() {
	return startRow;
}

public void setStartRow(int startRow) {
	this.startRow = startRow;
}

public int getEndRow() {
	return endRow;
}

public void setEndRow(int endRow) {
	this.endRow = endRow;
}
}
