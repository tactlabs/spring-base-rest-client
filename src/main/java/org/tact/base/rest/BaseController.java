package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.service.BaseService;

@RestController
@RequestMapping(value = "/base")
public class BaseController {
	
	@Autowired
	BaseService baseService;
	
	/**
	 * 
	 * @return
	 * 
	 * http://localhost:1878/base
	 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    /**
	 * @return
	 * 
	 * http://localhost:1878/base/rest/client
	 */
    @RequestMapping(value = "/rest/client", method = RequestMethod.GET)
    public <T> T testRestClient() {
        return (T) baseService.getTest();
    }
    
    /**
	 * @return
	 * 
	 * http://localhost:1878/base/rest/client/2
	 */
    @RequestMapping(value = "/rest/client/2", method = RequestMethod.GET)
    public <T> T testRestClient2() {
        return (T) baseService.testRestClientWithSSL();
    }
}
