package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.vo.StatisticsVo;
import com.utils.PageUtils;
import com.entity.OrdersEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.OrdersVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.OrdersView;


/**
 * 订单
 *
 * @author 
 * @email 
 * @date 2023-03-14 09:22:59
 */
public interface OrdersService extends IService<OrdersEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<OrdersVO> selectListVO(Wrapper<OrdersEntity> wrapper);
   	
   	OrdersVO selectVO(@Param("ew") Wrapper<OrdersEntity> wrapper);
   	
   	List<OrdersView> selectListView(Wrapper<OrdersEntity> wrapper);
   	
   	OrdersView selectView(@Param("ew") Wrapper<OrdersEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<OrdersEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<OrdersEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<OrdersEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<OrdersEntity> wrapper);

	/**
	 * 统计 商家、用户，整个系统的销售量
	 * @return
	 */
	StatisticsVo statisticsList();

}

