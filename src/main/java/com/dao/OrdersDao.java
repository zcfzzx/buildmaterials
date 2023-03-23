package com.dao;

import com.entity.OrdersEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.view.YonghuView;
import com.entity.vo.MonthCountVo;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.OrdersVO;
import com.entity.view.OrdersView;


/**
 * 订单
 * 
 * @author 
 * @email 
 * @date 2023-03-14 09:22:59
 */
public interface OrdersDao extends BaseMapper<OrdersEntity> {
	
	List<OrdersVO> selectListVO(@Param("ew") Wrapper<OrdersEntity> wrapper);
	
	OrdersVO selectVO(@Param("ew") Wrapper<OrdersEntity> wrapper);
	
	List<OrdersView> selectListView(@Param("ew") Wrapper<OrdersEntity> wrapper);

	List<OrdersView> selectListView(Pagination page,@Param("ew") Wrapper<OrdersEntity> wrapper);
	
	OrdersView selectView(@Param("ew") Wrapper<OrdersEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<OrdersEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<OrdersEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<OrdersEntity> wrapper);

	float selectStatisticsMonthCostByUserId(@Param("userid") Long userid);

	float selectStatisticsYearCostByUserId(@Param("userid") Long userid);

	int selectStatisticsMonthBuynumByShangjia(@Param("shangjia") String shangjia);

	int selectStatisticsYearBuynumByShangjia(@Param("shangjia") String shangjia);

	OrdersVO selectStatistics();

	/**
	 * 统计销量
	 * @return
	 */
    List<MonthCountVo> selectBuynumberCount();
}
