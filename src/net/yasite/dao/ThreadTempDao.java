package net.yasite.dao;

import net.yasite.entity.ThreadTempEntity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class ThreadTempDao extends AbstractDao< ThreadTempEntity , Long> {
	public static final String TABLENAME = "ThreadTemp";
	public ThreadTempDao(DaoConfig config) {
		super(config);
	}
	public ThreadTempDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
	}
	public static class Properties { 
		public final static Property _id = new Property(0,Long.class,"_id",true,"_ID");
		public final static Property Content = new Property(1,String.class,"content",false,"CONTENT");
		public final static Property MsgId = new Property(2,String.class,"msgId",false,"MSGID");
		public final static Property Thumb_pic1 = new Property(3,String.class,"thumb_pic1",false,"THUMB_PIC1");
		public final static Property Pic1 = new Property(4,String.class,"pic1",false,"PIC1");
		public final static Property Status_pic1 = new Property(5,String.class,"status_pic1",false,"STATUS_PIC1");
		public final static Property Thumb_pic2 = new Property(6,String.class,"thumb_pic2",false,"THUMB_PIC2");
		public final static Property Pic2 = new Property(7,String.class,"pic2",false,"PIC2");
		public final static Property Status_pic2 = new Property(8,String.class,"status_pic2",false,"STATUS_PIC2");
		public final static Property Thumb_pic3 = new Property(9,String.class,"thumb_pic3",false,"THUMB_PIC3");
		public final static Property Pic3 = new Property(10,String.class,"pic3",false,"PIC3");
		public final static Property Status_pic3 = new Property(11,String.class,"status_pic3",false,"STATUS_PIC3");
		public final static Property Thumb_pic4 = new Property(12,String.class,"thumb_pic4",false,"THUMB_PIC4");
		public final static Property Pic4 = new Property(13,String.class,"pic4",false,"PIC4");
		public final static Property Status_pic4 = new Property(14,String.class,"status_pic4",false,"STATUS_PIC4");
		public final static Property Thumb_pic5 = new Property(15,String.class,"thumb_pic5",false,"THUMB_PIC5");
		public final static Property Pic5 = new Property(16,String.class,"pic5",false,"PIC5");
		public final static Property Status_pic5 = new Property(17,String.class,"status_pic5",false,"STATUS_PIC5");
		public final static Property Thumb_pic6 = new Property(18,String.class,"thumb_pic6",false,"THUMB_PIC6");
		public final static Property Pic6 = new Property(19,String.class,"pic6",false,"PIC6");
		public final static Property Status_pic6 = new Property(20,String.class,"status_pic6",false,"STATUS_PIC6");
		public final static Property Thumb_pic7 = new Property(21,String.class,"thumb_pic7",false,"THUMB_PIC7");
		public final static Property Pic7 = new Property(22,String.class,"pic7",false,"PIC7");
		public final static Property Status_pic7 = new Property(23,String.class,"status_pic7",false,"STATUS_PIC7");
		public final static Property Thumb_pic8 = new Property(24,String.class,"thumb_pic8",false,"THUMB_PIC8");
		public final static Property Pic8 = new Property(25,String.class,"pic8",false,"PIC8");
		public final static Property Status_pic8 = new Property(26,String.class,"status_pic8",false,"STATUS_PIC8");
		public final static Property Thumb_pic9 = new Property(27,String.class,"thumb_pic9",false,"THUMB_PIC9");
		public final static Property Pic9 = new Property(28,String.class,"pic9",false,"PIC9");
		public final static Property Status_pic9 = new Property(29,String.class,"status_pic9",false,"STATUS_PIC9");
	}
	public static void createTable(SQLiteDatabase db, boolean ifNotExists) { 
		String constraint = ifNotExists ? "IF NOT EXISTS " : "";
		StringBuffer sql = new StringBuffer(0);
		sql.append("CREATE TABLE " + constraint + "'" + TABLENAME + "' ( ")
		.append("_ID INTEGER PRIMARY KEY ,")
		.append("CONTENT TEXT ,")
		.append("MSGID TEXT ,")
		.append("THUMB_PIC1 TEXT ,")
		.append("PIC1 TEXT ,")
		.append("STATUS_PIC1 TEXT ,")
		.append("THUMB_PIC2 TEXT ,")
		.append("PIC2 TEXT ,")
		.append("STATUS_PIC2 TEXT ,")
		.append("THUMB_PIC3 TEXT ,")
		.append("PIC3 TEXT ,")
		.append("STATUS_PIC3 TEXT ,")
		.append("THUMB_PIC4 TEXT ,")
		.append("PIC4 TEXT ,")
		.append("STATUS_PIC4 TEXT ,")
		.append("THUMB_PIC5 TEXT ,")
		.append("PIC5 TEXT ,")
		.append("STATUS_PIC5 TEXT ,")
		.append("THUMB_PIC6 TEXT ,")
		.append("PIC6 TEXT ,")
		.append("STATUS_PIC6 TEXT ,")
		.append("THUMB_PIC7 TEXT ,")
		.append("PIC7 TEXT ,")
		.append("STATUS_PIC7 TEXT ,")
		.append("THUMB_PIC8 TEXT ,")
		.append("PIC8 TEXT ,")
		.append("STATUS_PIC8 TEXT ,")
		.append("THUMB_PIC9 TEXT ,")
		.append("PIC9 TEXT ,")
		.append("STATUS_PIC9 TEXT );");
		db.execSQL(sql.toString());
	}
	public static void dropTable(SQLiteDatabase db, boolean ifExists) {
		String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'" + TABLENAME + "'";
		db.execSQL(sql);
	}
	@Override
	protected void bindValues(SQLiteStatement stmt, ThreadTempEntity entity) {
		if(entity.get_id() != null){
			stmt.bindLong(1, entity.get_id());
		}
		if(entity.getContent() != null){
			stmt.bindString(2, entity.getContent());
		}
		if(entity.getMsgId() != null){
			stmt.bindString(3, entity.getMsgId());
		}
		if(entity.getThumb_pic1() != null){
			stmt.bindString(4, entity.getThumb_pic1());
		}
		if(entity.getPic1() != null){
			stmt.bindString(5, entity.getPic1());
		}
		if(entity.getStatus_pic1() != null){
			stmt.bindString(6, entity.getStatus_pic1());
		}
		if(entity.getThumb_pic2() != null){
			stmt.bindString(7, entity.getThumb_pic2());
		}
		if(entity.getPic2() != null){
			stmt.bindString(8, entity.getPic2());
		}
		if(entity.getStatus_pic2() != null){
			stmt.bindString(9, entity.getStatus_pic2());
		}
		if(entity.getThumb_pic3() != null){
			stmt.bindString(10, entity.getThumb_pic3());
		}
		if(entity.getPic3() != null){
			stmt.bindString(11, entity.getPic3());
		}
		if(entity.getStatus_pic3() != null){
			stmt.bindString(12, entity.getStatus_pic3());
		}
		if(entity.getThumb_pic4() != null){
			stmt.bindString(13, entity.getThumb_pic4());
		}
		if(entity.getPic4() != null){
			stmt.bindString(14, entity.getPic4());
		}
		if(entity.getStatus_pic4() != null){
			stmt.bindString(15, entity.getStatus_pic4());
		}
		if(entity.getThumb_pic5() != null){
			stmt.bindString(16, entity.getThumb_pic5());
		}
		if(entity.getPic5() != null){
			stmt.bindString(17, entity.getPic5());
		}
		if(entity.getStatus_pic5() != null){
			stmt.bindString(18, entity.getStatus_pic5());
		}
		if(entity.getThumb_pic6() != null){
			stmt.bindString(19, entity.getThumb_pic6());
		}
		if(entity.getPic6() != null){
			stmt.bindString(20, entity.getPic6());
		}
		if(entity.getStatus_pic6() != null){
			stmt.bindString(21, entity.getStatus_pic6());
		}
		if(entity.getThumb_pic7() != null){
			stmt.bindString(22, entity.getThumb_pic7());
		}
		if(entity.getPic7() != null){
			stmt.bindString(23, entity.getPic7());
		}
		if(entity.getStatus_pic7() != null){
			stmt.bindString(24, entity.getStatus_pic7());
		}
		if(entity.getThumb_pic8() != null){
			stmt.bindString(25, entity.getThumb_pic8());
		}
		if(entity.getPic8() != null){
			stmt.bindString(26, entity.getPic8());
		}
		if(entity.getStatus_pic8() != null){
			stmt.bindString(27, entity.getStatus_pic8());
		}
		if(entity.getThumb_pic9() != null){
			stmt.bindString(28, entity.getThumb_pic9());
		}
		if(entity.getPic9() != null){
			stmt.bindString(29, entity.getPic9());
		}
		if(entity.getStatus_pic9() != null){
			stmt.bindString(30, entity.getStatus_pic9());
		}
	}
	@Override
	protected Long getKey(ThreadTempEntity entity) {
		if (entity != null) {
			return entity.get_id();
		} else {
			return null;
		}
	}
	@Override
	protected boolean isEntityUpdateable() {
		return true;
	}
	@Override
	protected Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}
	@Override
	protected Long updateKeyAfterInsert(ThreadTempEntity entity, long rowId) {
		entity.set_id(rowId);
		return rowId;
	}
	private ThreadTempEntity setEntity(Cursor cursor, ThreadTempEntity entity, int offset){
		entity.set_id(cursor.getLong(offset + 0));
		entity.setContent(cursor.getString(offset + 1));
		entity.setMsgId(cursor.getString(offset + 2));
		entity.setThumb_pic1(cursor.getString(offset + 3));
		entity.setPic1(cursor.getString(offset + 4));
		entity.setStatus_pic1(cursor.getString(offset + 5));
		entity.setThumb_pic2(cursor.getString(offset + 6));
		entity.setPic2(cursor.getString(offset + 7));
		entity.setStatus_pic2(cursor.getString(offset + 8));
		entity.setThumb_pic3(cursor.getString(offset + 9));
		entity.setPic3(cursor.getString(offset + 10));
		entity.setStatus_pic3(cursor.getString(offset + 11));
		entity.setThumb_pic4(cursor.getString(offset + 12));
		entity.setPic4(cursor.getString(offset + 13));
		entity.setStatus_pic4(cursor.getString(offset + 14));
		entity.setThumb_pic5(cursor.getString(offset + 15));
		entity.setPic5(cursor.getString(offset + 16));
		entity.setStatus_pic5(cursor.getString(offset + 17));
		entity.setThumb_pic6(cursor.getString(offset + 18));
		entity.setPic6(cursor.getString(offset + 19));
		entity.setStatus_pic6(cursor.getString(offset + 20));
		entity.setThumb_pic7(cursor.getString(offset + 21));
		entity.setPic7(cursor.getString(offset + 22));
		entity.setStatus_pic7(cursor.getString(offset + 23));
		entity.setThumb_pic8(cursor.getString(offset + 24));
		entity.setPic8(cursor.getString(offset + 25));
		entity.setStatus_pic8(cursor.getString(offset + 26));
		entity.setThumb_pic9(cursor.getString(offset + 27));
		entity.setPic9(cursor.getString(offset + 28));
		entity.setStatus_pic9(cursor.getString(offset + 29));
		return entity;
	}
	@Override
	protected ThreadTempEntity readEntity(Cursor cursor, int offset) {
		ThreadTempEntity entity = new ThreadTempEntity();
		return setEntity(cursor,entity,offset);
	}
	@Override
	protected void readEntity(Cursor cursor, ThreadTempEntity entity, int offset) {
		entity = setEntity(cursor,entity,offset);
	}
}