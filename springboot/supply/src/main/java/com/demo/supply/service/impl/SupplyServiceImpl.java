package com.demo.supply.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.supply.entity.Supply;
import com.demo.supply.mapper.SupplyMapper;
import com.demo.supply.page.Query;
import com.demo.supply.service.SupplyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("SupplyService")
public class SupplyServiceImpl extends ServiceImpl<SupplyMapper, Supply> implements SupplyService {
    @Override
    public Page getSupplyList(Map<String, Object> params) {
        Page page = new Query<Supply>(params).getPage();
        return page.setRecords(baseMapper.getSupplyList(page, params));
    }

    @Override
    public Page findAllList(Map<String, Object> params) {
        Page page = new Query<Supply>(params).getPage();
        return page.setRecords(baseMapper.findAllList(page,params));
    }

    @Override
    public List<Supply> findByNumber(Map<String, Object> params) {
        return baseMapper.findByNumber(params);
    }

    @Override
    public List<Supply> findByName(Map<String, Object> params) {
        return baseMapper.findByName(params);
    }


}
