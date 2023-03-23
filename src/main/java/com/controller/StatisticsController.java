package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.OrdersEntity;
import com.service.OrdersService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 统计
 * 后端接口
 * @author
 * @email
 * @date 2023-03-14 09:22:59
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 统计
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(){
        return R.ok().put("data", ordersService.statisticsList());
    }
}
