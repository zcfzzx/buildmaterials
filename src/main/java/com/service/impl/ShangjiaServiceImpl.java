package com.service.impl;

import com.dao.OrdersDao;
import com.entity.view.ShangjiaStatisticView;
import com.entity.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShangjiaDao;
import com.entity.ShangjiaEntity;
import com.service.ShangjiaService;
import com.entity.vo.ShangjiaVO;
import com.entity.view.ShangjiaView;

@Service("shangjiaService")
public class ShangjiaServiceImpl extends ServiceImpl<ShangjiaDao, ShangjiaEntity> implements ShangjiaService {

	@Autowired
	private OrdersDao ordersDao;



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangjiaEntity> page = this.selectPage(
                new Query<ShangjiaEntity>(params).getPage(),
                new EntityWrapper<ShangjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangjiaEntity> wrapper) {
		  Page<ShangjiaView> page =new Query<ShangjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
	@Override
	public int shangjiaCount() {
		//查询商家数量
		EntityWrapper<ShangjiaEntity> ew = new EntityWrapper<ShangjiaEntity>();
		return baseMapper.selectCount(ew);
	}

	@Override
	public ShangjiaEntity getByZhangHao(String shangjiazhanghao){
		return baseMapper.selectOne(new ShangjiaEntity(shangjiazhanghao));
	}

	@Override
	public List<ShangjiaVO> selectListVO(Wrapper<ShangjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangjiaVO selectVO(Wrapper<ShangjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangjiaView> selectListView(Wrapper<ShangjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangjiaStatisticView selectStatistic(String shangjiazhanghao) {
		//统计商家本周，当月，今年销售数量
		int monthBuynumber = ordersDao.selectStatisticsMonthBuynumByShangjia(shangjiazhanghao);
		int yearBuynumber = ordersDao.selectStatisticsYearBuynumByShangjia(shangjiazhanghao);
		ShangjiaStatisticView view = new ShangjiaStatisticView();
		view.setMonthNum(monthBuynumber);
		view.setYearNum(yearBuynumber);
		OrdersVO vo = ordersDao.selectStatisticsMonthBuynumAllByShangjia(shangjiazhanghao);
		List<Integer> numLists = buildCurrentMonthNum(vo);
		view.setNumLists(numLists);
		OrdersVO discounttotalVo = ordersDao.selectStatisticsMonthDiscounttotalAllByShangjia(shangjiazhanghao);
		List<Float> discounttotalLists = buildCurrentMonthDiscount(discounttotalVo);
		view.setDiscounttotalLists(discounttotalLists);
		return view;
	}

	private  List<Integer> buildCurrentMonthNum(OrdersVO vo) {
		List<Integer> monthDiscount = new ArrayList<>();
		monthDiscount.add(vo.getNum1());
		monthDiscount.add(vo.getNum2());
		monthDiscount.add(vo.getNum3());
		monthDiscount.add(vo.getNum4());
		monthDiscount.add(vo.getNum5());
		monthDiscount.add(vo.getNum6());
		monthDiscount.add(vo.getNum7());
		monthDiscount.add(vo.getNum8());
		monthDiscount.add(vo.getNum9());
		monthDiscount.add(vo.getNum10());
		monthDiscount.add(vo.getNum11());
		monthDiscount.add(vo.getNum12());

		Calendar calendar = Calendar.getInstance();
		// 获取当前月
		int month = calendar.get(Calendar.MONTH) + 1;
		List<Integer> currentMonthDiscount = new ArrayList<>();
		for(int i = 0; i < month; i++){
			currentMonthDiscount.add(monthDiscount.get(i));
		}
		return currentMonthDiscount;
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
	public ShangjiaView selectView(Wrapper<ShangjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
