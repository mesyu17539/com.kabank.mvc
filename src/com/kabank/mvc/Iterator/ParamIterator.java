package com.kabank.mvc.Iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;


public class ParamIterator {
	public static Map<?,?> execute(HttpServletRequest request){
		Map<String,String> result=new HashMap<>();
		Map<String,String[]> map=request.getParameterMap();
		Set<Entry<String, String[]>> set=map.entrySet();//맵에 있는 것을 셋에 옮겨 담았다. 왜냐하면 while 돌려야 내용물을 보는데 맵으로는 안되니까 셋에 담은 것.
		Iterator<Map.Entry<String, String[]>> it= set.iterator();//이터레이터는 셋에서 돌아다니며 찾아간 값은 표시를 해놓고 다시 찾아가지 않는다.
		String params[]=new String[set.size()];
		int i=0;
		while(it.hasNext()) {
			Map.Entry<String, String[]> e=it.next();
			params[i]=e.getKey();
			i++;
		}
		for(i=0;i<params.length;i++) {
			if(map.get(params[i]).length==1) {//길이가 1인건 체크박스 제외한 나머지.
				result.put(params[i], map.get(params[i])[0]);
			}else {
				String temp="";
				for(int j=0;j<map.get(params[i]).length;j++) {//체크박스
					temp+=map.get(params[i])[j]+",";//넘어온 집합을 1:1 대응으로 바꿈
				}
				result.put(params[i], temp);
			}
		}
		System.out.println("cmd 존재 여부 : "+map.containsKey("cmd"));
		return result;
	}
}
