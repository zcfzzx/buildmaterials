package com.service.impl;

import com.dao.CommonDao;
import com.dao.OrdersDao;
import com.entity.view.YonghuStaticView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.List;

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
		YonghuStaticView view = new YonghuStaticView();
		view.setMonthCost(monthCost);
		view.setYearCost(yearCost);
		return view;
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
