package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ShangjiaEntity;
import com.entity.UsersEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
 * 用户
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-14 09:22:59
 */
public class UsersView extends UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Float> currentMonthDiscount;

	public List<Float> getCurrentMonthDiscount() {
		return currentMonthDiscount;
	}

	public void setCurrentMonthDiscount(List<Float> currentMonthDiscount) {
		this.currentMonthDiscount = currentMonthDiscount;
	}

	public UsersView(){
	}

 	public UsersView(UsersEntity usersEntity){
 	try {
			BeanUtils.copyProperties(this, usersEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
