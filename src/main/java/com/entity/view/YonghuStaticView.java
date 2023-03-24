package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.YonghuEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
 * 用户统计数据
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-14 09:22:58
 */
public class YonghuStaticView extends YonghuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 月消费
	 */
	private float monthCost;
	/**
	 * 年消费
	 */
	private float yearCost;

	private List<Float> currentMonthDiscount;

	public List<Float> getCurrentMonthDiscount() {
		return currentMonthDiscount;
	}

	public void setCurrentMonthDiscount(List<Float> currentMonthDiscount) {
		this.currentMonthDiscount = currentMonthDiscount;
	}

	public float getMonthCost() {
		return monthCost;
	}

	public void setMonthCost(float monthCost) {
		this.monthCost = monthCost;
	}

	public float getYearCost() {
		return yearCost;
	}

	public void setYearCost(float yearCost) {
		this.yearCost = yearCost;
	}
	public YonghuStaticView(){
	}

 	public YonghuStaticView(YonghuEntity yonghuEntity){
 	try {
			BeanUtils.copyProperties(this, yonghuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
