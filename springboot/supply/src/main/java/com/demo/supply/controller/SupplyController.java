package com.demo.supply.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.supply.entity.Supply;
import com.demo.supply.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SupplyController {
    @Autowired
    SupplyService supplyService;

    @RequestMapping("supplyTable")
    public Page getSupplyList(@RequestParam Map<String, Object> params) {
        return supplyService.getSupplyList(params);
    }

    @RequestMapping("findAllList")
    public  Page findAllList(@RequestParam Map<String, Object> params) {
        System.out.println(params);
        return supplyService.findAllList(params);
    }

    @RequestMapping("findByNumber")
    public List<Supply> findByNumber(@RequestParam Map<String, Object> params) {
        return supplyService.findByNumber(params);
    }

    @RequestMapping("findByName")
    public List<Supply> findByName(@RequestParam Map<String, Object> params) {
        return supplyService.findByName(params);
    }
}
