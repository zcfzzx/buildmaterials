package com.service.impl;

import com.entity.ShangjiaEntity;
import com.entity.vo.ShangjiaxinxiVo;
import com.service.ShangjiaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShangpinxinxiDao;
import com.entity.ShangpinxinxiEntity;
import com.service.ShangpinxinxiService;
import com.entity.vo.ShangpinxinxiVO;
import com.entity.view.ShangpinxinxiView;
import org.springframework.util.ObjectUtils;

@Service("shangpinxinxiService")
public class ShangpinxinxiServiceImpl extends ServiceImpl<ShangpinxinxiDao, ShangpinxinxiEntity> implements ShangpinxinxiService {

	@Autowired
	private ShangjiaService shangJiaService;

	@Override
	public ShangjiaxinxiVo getGoodsById(String shangjiazhanghao){
		ShangjiaxinxiVo vo = new ShangjiaxinxiVo();
		ShangjiaEntity byZhangHao = shangJiaService.getByZhangHao(shangjiazhanghao);
		if(!ObjectUtils.isEmpty(byZhangHao)){
			BeanUtils.copyProperties(byZhangHao,vo);
			Wrapper<ShangpinxinxiEntity> wrapper = new EntityWrapper<>();
			wrapper.eq("shangjiazhanghao",vo.getShangjiazhanghao());
			List<ShangpinxinxiEntity> list = baseMapper.selectList(wrapper);
			if(!ObjectUtils.isEmpty(list)){
				vo.setGoods(list);
			}
		}
		return vo;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangpinxinxiEntity> page = this.selectPage(
                new Query<ShangpinxinxiEntity>(params).getPage(),
                new EntityWrapper<ShangpinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangpinxinxiEntity> wrapper) {
		  Page<ShangpinxinxiView> page =new Query<ShangpinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangpinxinxiVO> selectListVO(Wrapper<ShangpinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangpinxinxiVO selectVO(Wrapper<ShangpinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangpinxinxiView> selectListView(Wrapper<ShangpinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangpinxinxiView selectView(Wrapper<ShangpinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
