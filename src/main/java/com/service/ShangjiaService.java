package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.view.ShangjiaStatisticView;
import com.utils.PageUtils;
import com.entity.ShangjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangjiaView;


/**
 * 商家
 *
 * @author 
 * @email 
 * @date 2023-03-14 09:22:59
 */
public interface ShangjiaService extends IService<ShangjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangjiaVO> selectListVO(Wrapper<ShangjiaEntity> wrapper);

	ShangjiaEntity getByZhangHao(String shangjiazhanghao);
   	
   	ShangjiaVO selectVO(@Param("ew") Wrapper<ShangjiaEntity> wrapper);
   	
   	List<ShangjiaView> selectListView(Wrapper<ShangjiaEntity> wrapper);

	ShangjiaStatisticView selectStatistic(String shangjiazhanghao);
   	
   	ShangjiaView selectView(@Param("ew") Wrapper<ShangjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangjiaEntity> wrapper);

	int shangjiaCount();

}

