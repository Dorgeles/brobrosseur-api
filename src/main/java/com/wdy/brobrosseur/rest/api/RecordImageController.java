

/*
 * Java controller for entity table record_image 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdy.brobrosseur.rest.api;

import com.wdy.brobrosseur.business.RecordImageBusiness;
import com.wdy.brobrosseur.rest.fact.ControllerFactory;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.contract.Response;
import com.wdy.brobrosseur.utils.dto.RecordImageDto;
import com.wdy.brobrosseur.utils.enums.FunctionalityEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
Controller for table "record_image"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/recordImage")
public class RecordImageController {

	@Autowired
    private ControllerFactory<RecordImageDto> controllerFactory;
	@Autowired
	private RecordImageBusiness recordImageBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RecordImageDto> create(@RequestBody Request<RecordImageDto> request) {
    	// System.out.println("start method /recordImage/create");
        Response<RecordImageDto> response = controllerFactory.create(recordImageBusiness, request, FunctionalityEnum.CREATE_RECORD_IMAGE);
		// System.out.println("end method /recordImage/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RecordImageDto> update(@RequestBody Request<RecordImageDto> request) {
    	// System.out.println("start method /recordImage/update");
        Response<RecordImageDto> response = controllerFactory.update(recordImageBusiness, request, FunctionalityEnum.UPDATE_RECORD_IMAGE);
		// System.out.println("end method /recordImage/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RecordImageDto> delete(@RequestBody Request<RecordImageDto> request) {
    	// System.out.println("start method /recordImage/delete");
        Response<RecordImageDto> response = controllerFactory.delete(recordImageBusiness, request, FunctionalityEnum.DELETE_RECORD_IMAGE);
		// System.out.println("end method /recordImage/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RecordImageDto> getByCriteria(@RequestBody Request<RecordImageDto> request) {
    	// System.out.println("start method /recordImage/getByCriteria");
        Response<RecordImageDto> response = controllerFactory.getByCriteria(recordImageBusiness, request, FunctionalityEnum.VIEW_RECORD_IMAGE);
		// System.out.println("end method /recordImage/getByCriteria");
        return response;
    }
}
