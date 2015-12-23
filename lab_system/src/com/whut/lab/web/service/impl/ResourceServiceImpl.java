package com.whut.lab.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.whut.lab.web.entity.Resource;
import com.whut.lab.web.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<Resource, Integer> implements ResourceService{

	@Override
	public Map<String, String> getResources() {
		Map<String, String> map = new HashMap<String, String>();
		List<Resource> resources = super.getAll();
		for(Resource resource : resources){
			map.put(resource.getUrl(), resource.getAuthority());
		}
		return map;
	}

}
