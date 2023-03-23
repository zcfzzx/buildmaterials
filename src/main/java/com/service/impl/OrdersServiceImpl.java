package com.service.impl;

import com.dao.ShangjiaDao;
import com.dao.YonghuDao;
import com.entity.vo.MonthCountVo;
import com.entity.vo.StatisticsVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.OrdersDao;
import com.entity.OrdersEntity;
import com.service.OrdersService;
import com.entity.vo.OrdersVO;
import com.entity.view.OrdersView;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersEntity> implements OrdersService {

	@Resource
	private YonghuDao yonghuDao;

	@Resource
	private ShangjiaDao shangjiaDao;

	@Override
	public StatisticsVo statisticsList(){
		StatisticsVo vo = new StatisticsVo();
		List<Integer> months = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		List<MonthCountVo> yongHu = yonghuDao.statisticsMonthCount();
		List<MonthCountVo> shangJia = shangjiaDao.statisticsMonthCount();
		List<MonthCountVo> buyNumbers = baseMapper.selectBuynumberCount();
		List<Integer> yongHuCountList = new ArrayList<>();
		List<Integer> shangJiaCountList = new ArrayList<>();
		List<Integer> buyNumbersCountList = new ArrayList<>();
		for (Integer month : months) {
			MonthCountVo yongHuCountVo = yongHu.stream().filter(f -> f.getCurrentMonth().equals(month)).findFirst().orElse(null);
			MonthCountVo shangJiaCountVo = shangJia.stream().filter(f -> f.getCurrentMonth().equals(month)).findFirst().orElse(null);
			MonthCountVo buyNumbersCountVo = buyNumbers.stream().filter(f -> f.getCurrentMonth().equals(month)).findFirst().orElse(null);
			shangJiaCountList.add(ObjectUtils.isEmpty(yongHuCountVo) ? 0 : yongHuCountVo.getQuantity());
			yongHuCountList.add(ObjectUtils.isEmpty(shangJiaCountVo) ? 0 : shangJiaCountVo.getQuantity());
			buyNumbersCountList.add(ObjectUtils.isEmpty(buyNumbersCountVo) ? 0 : buyNumbersCountVo.getQuantity());
		}
		vo.setYongHuCountList(yongHuCountList);
		vo.setShangJiaCountList(shangJiaCountList);
		vo.setBuyNumberCountList(buyNumbersCountList);
		return vo;
	}

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrdersEntity> page = this.selectPage(
                new Query<OrdersEntity>(params).getPage(),
                new EntityWrapper<OrdersEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper) {
		  Page<OrdersView> page =new Query<OrdersView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<OrdersVO> selectListVO(Wrapper<OrdersEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public OrdersVO selectVO(Wrapper<OrdersEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<OrdersView> selectListView(Wrapper<OrdersEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public OrdersView selectView(Wrapper<OrdersEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<OrdersEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<OrdersEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<OrdersEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
