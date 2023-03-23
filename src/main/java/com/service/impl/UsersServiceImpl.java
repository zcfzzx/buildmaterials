
package com.service.impl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.dao.OrdersDao;
import com.entity.ShangjiaEntity;
import com.entity.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.UsersDao;
import com.entity.UsersEntity;
import com.service.UsersService;
import com.utils.PageUtils;
import com.utils.Query;


/**
 * 系统用户
 */
@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {

	@Autowired
	private OrdersDao ordersDao;
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<UsersEntity> page = this.selectPage(
                new Query<UsersEntity>(params).getPage(),
                new EntityWrapper<UsersEntity>()
        );
        return new PageUtils(page);
	}

	@Override
	public List<UsersEntity> selectListView(Wrapper<UsersEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params,
			Wrapper<UsersEntity> wrapper) {
		 Page<UsersEntity> page =new Query<UsersEntity>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
	}

	@Override
	public int selectUserCount() {
		//查询用户数量
		EntityWrapper<UsersEntity> ew = new EntityWrapper<UsersEntity>();
		return baseMapper.selectCount(ew);
	}

	@Override
	public List<Float> selectStatisticsMonthCostAllByUserId(Long id) {
		OrdersVO vo = ordersDao.selectStatisticsMonthCostAllByUserId(id);
		List<Float> monthDiscount = new ArrayList<>();
		monthDiscount.add(vo.getMonth1());
		monthDiscount.add(vo.getMonth2());
		monthDiscount.add(vo.getMonth3());
		monthDiscount.add(vo.getMonth4());
		monthDiscount.add(vo.getMonth5());
		monthDiscount.add(vo.getMonth6());
		monthDiscount.add(vo.getMonth7());
		monthDiscount.add(vo.getMonth8());
		monthDiscount.add(vo.getMonth9());
		monthDiscount.add(vo.getMonth10());
		monthDiscount.add(vo.getMonth11());
		monthDiscount.add(vo.getMonth12());

		Calendar calendar = Calendar.getInstance();
		// 获取当前月
		int month = calendar.get(Calendar.MONTH) + 1;
		List<Float> currentMonthDiscount = new ArrayList<>();
		for(int i = 0; i < month; i++){
			currentMonthDiscount.add(currentMonthDiscount.get(i));
		}
		return currentMonthDiscount;
	}
}
