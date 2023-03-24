package com.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 * @data 2023/3/23 14:10
 */
public class StatisticsVo implements Serializable {
    //用户数量
    private List<Integer> yongHuCountList;

    //商家数量
    private List<Integer> shangJiaCountList;

    //销量
    private List<Integer> buyNumberCountList;

    public List<Integer> getYongHuCountList() {
        return yongHuCountList;
    }

    public void setYongHuCountList(List<Integer> yongHuCountList) {
        this.yongHuCountList = yongHuCountList;
    }

    public List<Integer> getShangJiaCountList() {
        return shangJiaCountList;
    }

    public void setShangJiaCountList(List<Integer> shangJiaCountList) {
        this.shangJiaCountList = shangJiaCountList;
    }

    public List<Integer> getBuyNumberCountList() {
        return buyNumberCountList;
    }

    public void setBuyNumberCountList(List<Integer> buyNumberCountList) {
        this.buyNumberCountList = buyNumberCountList;
    }
}
