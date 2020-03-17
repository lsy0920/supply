package com.demo.supply.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.supply.entity.Supply;

import java.util.List;
import java.util.Map;

public interface SupplyService extends IService<Supply> {
    Page getSupplyList(Map<String, Object> params);

    Page findAllList(Map<String, Object> params);

    List<Supply> findByNumber(Map<String, Object> params);

    List<Supply> findByName(Map<String, Object> params);

}
