package me.holostan.hk.framework.utils.string;

import org.apache.commons.lang.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringUtil {
	
	public static boolean isBlank(String str){
		return StringUtils.isBlank(str);
	}
	public static String parseList(List<?> list){
		return parseList(list,",");
	}
	public static String parseList(List<?> list,String separate){
		StringBuffer buffer = null;
		if(list != null){
			buffer = new StringBuffer();
		}else{
			return null;
		}
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			buffer.append(object);
			if(iterator.hasNext()){
				buffer.append(separate);
			}
		}
		return buffer.toString();
	}

	public static String parseMap(Map<String,String> map){
		return parseMap(map,null);
	}

	public static String parseMap(Map<String,String> map,Set<String> pkSet){
		StringBuffer buffer = null;
		if(map != null){
			buffer = new StringBuffer();
		}else{
			return null;
		}
		for (Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, String> entry = iterator.next();
			if(pkSet == null || pkSet.isEmpty()){
				buffer.append(entry.getKey()).append("=").append(entry.getValue());
			}else{
				for(String pk : pkSet){
					if(!pk.equals(entry.getKey())){
						buffer.append(entry.getKey()).append("=").append(entry.getValue());
					}
				}
			}
			if(iterator.hasNext()){
				buffer.append(',');
			}
		}
		return buffer.toString();
	}

}
