package pds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pds.model.PdsItem;
import jdbc.JdbcUtil;

public class PdsItemDao {

private static PdsItemDao instance = new PdsItemDao();
public static PdsItemDao getInstance() {
	return instance;
}
private PdsItemDao() {
}

public int selectCount(Connection conn) throws SQLException{

Statement stmt = null;
ResultSet rs = null;
try {
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select count(*) from pds_item");
	rs.next();
	return rs.getInt(1);
}finally {
JdbcUtil.close(rs);
JdbcUtil.close(stmt);
}
}

public List<PdsItem> select(Connection conn,int firstRow,int endRow) throws SQLException{
PreparedStatement pstmt = null;
ResultSet rs = null;
try {
pstmt = conn.prepareStatement("select * from("
+" select rownum rnum,pds_item_id,filename,realpath,filesize,downloadcount,description from("
+" select*frim pds_item m order by m.pds_item_id desc"
+" )where rownum <=?"
+ ")where rnum >= ?");

pstmt.setInt(1,endRow);
pstmt.setInt(2,firstRow);
rs=pstmt.executeQuery();
if(!rs.next()) {
return Collections.emptyList();
}
List<PdsItem> itemList = new ArrayList<PdsItem>();
do{
	PdsItem article = makeItemFromResultSet(rs);
	itemList.add(article);
}while(rs.next());
return itemList;
}finally {
	JdbcUtil.close(rs);
	JdbcUtil.close(pstmt);
}
}
private PdsItem makeItemFromResultSet(ResultSet rs) throws SQLException{
	PdsItem item = new PdsItem();
	item.setId(rs.getInt("pds_item_id"));
	item.setFileName(rs.getString("fileName"));
	item.setRealPath(rs.getString("realPath"));
	item.setFileSize(rs.getLong("fileSize"));
	item.setDownloadCount(rs.getInt("downloadCount"));
	item.setDesctiption(rs.getString("desctiption"));
	return item;
}

public PdsItem selectById(Connection conn,int itemId) throws SQLException{
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = conn.prepareStatement("select * from pds_item" + "where pds_item_id=?");
		pstmt.setInt(1,itemId);
		rs = pstmt.executeQuery();
		if(!rs.next()) {
			return null;
		}
		PdsItem item = makeItemFromResultSet(rs);
		return item;
	}finally {
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
	}
}

public int insert(Connection conn,PdsItem item)throws SQLException{
	
PreparedStatement pstmt = null;
Statement stmt = null;
ResultSet rs = null;

try {
pstmt = conn.prepareStatement("insert into pds_item"
+"(Pds_item_id,filename,realpath,filesize,downloadcount,"
+"description)"
+"values(pds_item_id_seq.NEXTVAL,?,?,?,0,?)");

pstmt.setString(1,item.getFileName());
pstmt.setString(2,item.getRealPath());
pstmt.setLong(3,item.getFileSize());
pstmt.setString(4,item.getDesctiption());
int insertedCount = pstmt.executeUpdate();
	
if(insertedCount > 0) {
stmt = conn.createStatement();
rs = stmt.executeQuery("select pds_item_id_seq.CURRVAL form dual");
if(rs.next()) {
	return rs.getInt(1);
}
}
return -1;

}finally {
	JdbcUtil.close(rs);
	JdbcUtil.close(stmt);
	JdbcUtil.close(pstmt);
}
}

public int increaseCount(Connection conn, int id) throws SQLException{
	PreparedStatement pstmt=null;
	try {
		pstmt=conn.prepareStatement("update pds_item set downloadcount = downloadcount + 1 where pds_item_id = ?");
		pstmt.setInt(1,id);
		return pstmt.executeUpdate();
	}finally {
		JdbcUtil.close(pstmt);
	}
}
}
