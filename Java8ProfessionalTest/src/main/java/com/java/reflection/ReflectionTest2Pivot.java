package com.java.reflection;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReflectionTest2Pivot {

	public static void main(String[] args) throws Exception{
		List<BasePartAttr> lists = Arrays.asList(
				new BasePartAttr(100387, 5001, "100", null, null),
				new BasePartAttr(100388, 5003, "100", null, null),
				new BasePartAttr(100387, 5002, null, "10", null),
				new BasePartAttr(100388, 5004, null, "10", null),
				new BasePartAttr(100387, 5005, null, null, "301")
				);
		
		//lists.forEach(l-> System.out.println(l));
		
		ReflectionTest2Pivot pi = new ReflectionTest2Pivot();
		
		List<BasePartAttr> result = pi.reflxSummer(lists);
		
		result.forEach(l-> System.out.println(l));
		
		
		
		System.out.println("done");
	}
	
	private List<BasePartAttr> reflxSummer(List<BasePartAttr> lists) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Map<BigInteger, List<BasePartAttr>> basePartObjs = 
				lists.stream().collect(
		                Collectors.groupingBy(BasePartAttr::getBasepartId, Collectors.toList()));
		List<BasePartAttr> result = new ArrayList<>();
		for(Map.Entry<BigInteger, List<BasePartAttr>> entry : basePartObjs.entrySet()) {
			List<BasePartAttr> bpaLi = entry.getValue();
			System.out.println(bpaLi.size()+" -- "+entry.getKey());
			// ideally should be one object created for one entry Key
			BasePartAttr pivotObj = new BasePartAttr();
			for(BasePartAttr bpa : bpaLi) {
				Map<String, Object> objData = mapper(bpa);
				
				pivotObj.setBasepartId(entry.getKey()); // set base part Id
				
				for (Map.Entry<String, Object> entry2 : objData.entrySet()) {
					if (entry2.getValue() instanceof String || entry2.getValue() instanceof Integer
							|| entry2.getValue() instanceof Double || entry2.getValue() instanceof Character
							|| entry2.getValue() instanceof BigInteger) {
						//System.out.println(entry2.getKey() + "-->" + entry2.getValue());
						Field f1 = pivotObj.getClass().getDeclaredField(entry2.getKey());
						f1.setAccessible(true);
						f1.set(pivotObj, entry2.getValue());
					}
				}
			}
			result.add(pivotObj);
			//System.out.println(pivotObj);
		}
		
		return result;
	}
	
	private Map<String, Object> mapper(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Map<String, Object> props = new HashMap<>();

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			props.put(f.getName(), f.get(obj));
		}

		return props;
	}
}


class BasePartAttr{
	
	private BigInteger basepartId;
	private BigInteger attrValId;
	
	private String trayedMinimumOrder;
	
	private String relateMinimumOrder;
	
	private String janCode;

	public BigInteger getBasepartId() {
		return basepartId;
	}

	public void setBasepartId(BigInteger basepartId) {
		this.basepartId = basepartId;
	}

	public BigInteger getAttrValId() {
		return attrValId;
	}

	public void setAttrValId(BigInteger attrValId) {
		this.attrValId = attrValId;
	}

	public String getTrayedMinimumOrder() {
		return trayedMinimumOrder;
	}

	public void setTrayedMinimumOrder(String trayedMinimumOrder) {
		this.trayedMinimumOrder = trayedMinimumOrder;
	}

	public String getRelateMinimumOrder() {
		return relateMinimumOrder;
	}

	public void setRelateMinimumOrder(String relateMinimumOrder) {
		this.relateMinimumOrder = relateMinimumOrder;
	}

	public BasePartAttr() {
		// TODO Auto-generated constructor stub
	}

	public BasePartAttr(int basepartId, int attrValId, String trayedMinimumOrder,
			String relateMinimumOrder, String janCode) {
		this.basepartId = new BigInteger(basepartId+"");
		this.attrValId = new BigInteger(attrValId+"");
		this.trayedMinimumOrder = trayedMinimumOrder;
		this.relateMinimumOrder = relateMinimumOrder;
		this.janCode = janCode;
	}

	@Override
	public String toString() {
		return "BasePartAttr [basepartId=" + basepartId + ", attrValId=" + attrValId + ", trayedMinimumOrder="
				+ trayedMinimumOrder + ", relateMinimumOrder=" + relateMinimumOrder + ", janCode="+janCode+"]";
	}

	public String getJanCode() {
		return janCode;
	}

	public void setJanCode(String janCode) {
		this.janCode = janCode;
	}
	
	
}