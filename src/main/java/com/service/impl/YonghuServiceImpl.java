package com.service.impl;

import com.dao.CommonDao;
import com.dao.OrdersDao;
import com.entity.view.YonghuStaticView;
import com.entity.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YonghuDao;
import com.entity.YonghuEntity;
import com.service.YonghuService;
import com.entity.vo.YonghuVO;
import com.entity.view.YonghuView;

@Service("yonghuService")
public class YonghuServiceImpl extends ServiceImpl<YonghuDao, YonghuEntity> implements YonghuService {

	@Autowired
	private OrdersDao ordersDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghuEntity> page = this.selectPage(
                new Query<YonghuEntity>(params).getPage(),
                new EntityWrapper<YonghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghuEntity> wrapper) {
		  Page<YonghuView> page =new Query<YonghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

	@Override
	public YonghuStaticView getStatistics(long id) {
		float yearCost = ordersDao.selectStatisticsYearCostByUserId(id);
		float monthCost = ordersDao.selectStatisticsMonthCostByUserId(id);
		OrdersVO vo = ordersDao.selectStatisticsMonthCostAllByUserId(id);
		YonghuStaticView view = new YonghuStaticView();
		view.setMonthCost(monthCost);
		view.setYearCost(yearCost);
		view.setCurrentMonthDiscount(buildCurrentMonthDiscount(vo));
		return view;
	}


	private  List<Float> buildCurrentMonthDiscount(OrdersVO vo) {
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
			currentMonthDiscount.add(monthDiscount.get(i));
		}
		return currentMonthDiscount;
	}

	@Override
	public List<YonghuVO> selectListVO(Wrapper<YonghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghuVO selectVO(Wrapper<YonghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghuView> selectListView(Wrapper<YonghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghuView selectView(Wrapper<YonghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
