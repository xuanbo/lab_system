package com.whut.lab.web.service;

import java.util.Map;

import com.whut.lab.web.entity.Resource;

public interface ResourceService extends BaseService<Resource, Integer>{
	/**
	 * 获取权限与资源的map
	 * @return
	 */
	Map<String,String> getResources();
}
