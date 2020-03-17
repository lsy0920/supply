package com.demo.supply.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.supply.entity.Supply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SupplyMapper extends BaseMapper<Supply> {
    List<Supply> getSupplyList(IPage page, @Param("params") Map<String, Object> params);

    List<Supply> findAllList(IPage page, @Param("params") Map<String, Object> params);

    List<Supply> findByNumber(@Param("params") Map<String, Object> params);

    List<Supply> findByName(@Param("params") Map<String, Object> params);

}
