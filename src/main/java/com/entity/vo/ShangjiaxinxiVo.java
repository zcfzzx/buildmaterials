package com.entity.vo;

import com.entity.ShangjiaEntity;
import com.entity.ShangpinxinxiEntity;

import java.util.List;

/**
 * @author
 * @data 2023/3/22 15:19
 */
public class ShangjiaxinxiVo extends ShangjiaEntity {

    //商品信息
    private List<ShangpinxinxiEntity> goods;

    public List<ShangpinxinxiEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<ShangpinxinxiEntity> goods) {
        this.goods = goods;
    }
}
