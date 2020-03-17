package com.demo.supply.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.LinkedHashMap;
import java.util.Map;

public class Query<T> extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 每页条数
     */
    private int pageSize = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);
        String currentPage = "currentPage";
        String pageSize1 = "pageSize";
//        System.out.println(params);
        //分页参数
        if (params.get(currentPage) != null) {
            pageNum = Integer.parseInt(params.get(currentPage).toString());
        }
        if (params.get(pageSize1) != null) {
            pageSize = Integer.parseInt(params.get(pageSize1).toString());
        }
        System.out.println(pageSize + "query" + pageNum);

        this.put("offset", (pageNum - 1) * pageSize);
        this.put("page", pageNum);
        this.put("limit", pageSize);

        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
//        String sidx = SQLFilter.sqlInject((String) params.get("sidx"));  //排序字段
//        String order = SQLFilter.sqlInject((String) params.get("order"));   //ASC | DESC 两个值中的一种
//        this.put("sidx", sidx);
//        this.put("order", order);
//
        //mybatis-plus分页
        this.page = new Page<>(pageNum, pageSize);
//
//        //排序
//        if (StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(order)) {
//            this.page.setOrderByField(sidx);
//            this.page.setAsc("ASC".equalsIgnoreCase(order));
//        }
//
    }

    public Page<T> getPage() {
        return page;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }
}
