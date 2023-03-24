package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ShangjiaEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
 * 商家
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-14 09:22:59
 */
public class ShangjiaStatisticView extends ShangjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private int yearNum;

	private int monthNum;

	private List<Integer> numLists;

	private List<Float> discounttotalLists;

	public List<Float> getDiscounttotalLists() {
		return discounttotalLists;
	}

	public void setDiscounttotalLists(List<Float> discounttotalLists) {
		this.discounttotalLists = discounttotalLists;
	}

	public List<Integer> getNumLists() {
		return numLists;
	}

	public void setNumLists(List<Integer> numLists) {
		this.numLists = numLists;
	}

	public int getYearNum() {
		return yearNum;
	}

	public void setYearNum(int yearNum) {
		this.yearNum = yearNum;
	}

	public int getMonthNum() {
		return monthNum;
	}

	public void setMonthNum(int monthNum) {
		this.monthNum = monthNum;
	}

	public ShangjiaStatisticView(){
	}

 	public ShangjiaStatisticView(ShangjiaEntity shangjiaEntity){
 	try {
			BeanUtils.copyProperties(this, shangjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
