package me.holostan.hk.framework.utils.mapper;

import me.holostan.hk.framework.mvc.Entity;
import me.holostan.hk.framework.utils.string.StringUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapperProvider {
	
	private Logger logger = Logger.getLogger(MapperProvider.class);
	
	public <T extends Entity> String insert(T entity){
		Class<? extends Entity> clazz = entity.getClass();
		StringBuffer sqlBuffer = new StringBuffer("INSERT INTO ");
		String tableName = MapperSqlHelper.getTable(clazz);
		//解析实体
		Map<String, String> columnsAndFieldNames = MapperSqlHelper.getColumnsAndFieldNames(entity, false);
		List<String> columns = new ArrayList<String>();
		List<Object> fieldNames = new ArrayList<Object>();
		for (Entry<String, String> entry : columnsAndFieldNames.entrySet()) {
			columns.add(entry.getKey());
			fieldNames.add(entry.getValue());
		}
		//拼接表名 列名 值，可通过[JPA]@Table(name="")注解，默认使用类名
		sqlBuffer.append(tableName).append(" ( ").append(StringUtil.parseList(columns)).append(" ) VALUES ( ").append(StringUtil.parseList(fieldNames)).append(" ) ");
		logger.debug(sqlBuffer);
		return sqlBuffer.toString();
	}

	public String batchInsert(List<Entity> entities) {
		return "";
		
	}

	public <T extends Entity> String save(T entity) {
		return "";
	}

	public String batchSave(List<Entity> tList) {
		return "";
		
	}

	public <T extends Entity> String delete(T entity) {
		Class<? extends Entity> clazz = entity.getClass();
		StringBuffer sqlBuffer = new StringBuffer("DELETE FROM ");
		String tableName = MapperSqlHelper.getTable(clazz);
		return "";
		
	}

	public String batchDelete(List<Integer> ids) {
		return "";
		
	}

	public <T extends Entity> String update(T entity) {
		Class<? extends Entity> clazz = entity.getClass();
		StringBuffer sqlBuffer = new StringBuffer("UPDATE ");
		String tableName = MapperSqlHelper.getTable(clazz);
		Map<String,String> columnsAndFieldNames = MapperSqlHelper.getColumnsAndFieldNames(entity,true);
		Map<String,String> pkAndValue = MapperSqlHelper.getPKAndValue(entity);
		sqlBuffer.append(tableName).append(" SET ").append(StringUtil.parseMap(columnsAndFieldNames,pkAndValue.keySet())).append(" WHERE ").append(StringUtil.parseMap(pkAndValue));
		logger.debug(sqlBuffer);
		return sqlBuffer.toString();
	}

	public String batchUpdate(List<Entity> tList) {
		return "";
		
	}

	public String findOneById(Integer id) {
		return "";
	}

	public String findAll() {
		return "";
	}

	public String count() {
		return "";
	}

	public String pageList() {
		return "";
		
	}

}
