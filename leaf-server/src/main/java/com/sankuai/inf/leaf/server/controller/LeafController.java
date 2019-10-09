package com.sankuai.inf.leaf.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.segment.dao.IDAllocDao;
import com.sankuai.inf.leaf.segment.model.LeafAlloc;
import com.sankuai.inf.leaf.server.exception.LeafServerException;
import com.sankuai.inf.leaf.server.exception.NoKeyException;
import com.sankuai.inf.leaf.server.service.SegmentService;
import com.sankuai.inf.leaf.server.service.SnowflakeService;

@RestController
public class LeafController {
    private Logger logger = LoggerFactory.getLogger(LeafController.class);
    @Autowired
    SegmentService segmentService;
    @Autowired
    SnowflakeService snowflakeService;
    
    

    @RequestMapping(value = "/api/segment/get/{appId}/{key}")
    public String getSegmentID(@PathVariable("key") String key,@PathVariable("appId") String appId) {
    	//根据渠道号和业务id找到对应的生成记录
    	//是否拼装至前缀、自增id的长度，不够前面补充0
    	LeafAlloc lf = new LeafAlloc();
    	lf.setKey(key);
    	lf.setAppId(appId);
    	LeafAlloc leafAlloc = segmentService.getLeafByParam(lf);
    	//拼装标志
    	String preFix = leafAlloc.getPrefixAdd();
    	int size = Integer.parseInt(leafAlloc.getNumSize());
    	String type = leafAlloc.getType();
    	if(type.equals("1")) {//如果雪花类型直接返回
    		return snowflakeService.getId(key).getId()+"";
    	}else {
    		String resultKey  = get(key, segmentService.getId(key));
        	
    		if(resultKey.length()< size) {
        		//给resultKey前面补0
        		int count = size - resultKey.length();
        		for (int i = 0; i < count; i++) {
        			resultKey = "0"+resultKey;
    			}
        	}
        	if(!StringUtils.isEmpty(preFix)) {
        		resultKey = preFix+resultKey;
        	}
            return resultKey;
    	}
    }

    @RequestMapping(value = "/api/snowflake/get/{key}")
    public String getSnowflakeID(@PathVariable("key") String key) {
        return get(key, snowflakeService.getId(key));

    }

    private String get(@PathVariable("key") String key, Result id) {
        Result result;
        if (key == null || key.isEmpty()) {
            throw new NoKeyException();
        }

        result = id;
        if (result.getStatus().equals(Status.EXCEPTION)) {
            throw new LeafServerException(result.toString());
        }
        return String.valueOf(result.getId());
    }
}
