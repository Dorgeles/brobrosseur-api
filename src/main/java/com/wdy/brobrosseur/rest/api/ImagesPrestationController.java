

/*
 * Java controller for entity table images_prestation 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdy.brobrosseur.rest.api;

import com.wdy.brobrosseur.business.ImagesPrestationBusiness;
import com.wdy.brobrosseur.rest.fact.ControllerFactory;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.contract.Response;
import com.wdy.brobrosseur.utils.dto.ImagesPrestationDto;
import com.wdy.brobrosseur.utils.enums.FunctionalityEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
Controller for table "images_prestation"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/imagesPrestation")
public class ImagesPrestationController {

	@Autowired
    private ControllerFactory<ImagesPrestationDto> controllerFactory;
	@Autowired
	private ImagesPrestationBusiness imagesPrestationBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ImagesPrestationDto> create(@RequestBody Request<ImagesPrestationDto> request) {
    	// System.out.println("start method /imagesPrestation/create");
        Response<ImagesPrestationDto> response = controllerFactory.create(imagesPrestationBusiness, request, FunctionalityEnum.CREATE_IMAGES_PRESTATION);
		// System.out.println("end method /imagesPrestation/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ImagesPrestationDto> update(@RequestBody Request<ImagesPrestationDto> request) {
    	// System.out.println("start method /imagesPrestation/update");
        Response<ImagesPrestationDto> response = controllerFactory.update(imagesPrestationBusiness, request, FunctionalityEnum.UPDATE_IMAGES_PRESTATION);
		// System.out.println("end method /imagesPrestation/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ImagesPrestationDto> delete(@RequestBody Request<ImagesPrestationDto> request) {
    	// System.out.println("start method /imagesPrestation/delete");
        Response<ImagesPrestationDto> response = controllerFactory.delete(imagesPrestationBusiness, request, FunctionalityEnum.DELETE_IMAGES_PRESTATION);
		// System.out.println("end method /imagesPrestation/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ImagesPrestationDto> getByCriteria(@RequestBody Request<ImagesPrestationDto> request) {
    	// System.out.println("start method /imagesPrestation/getByCriteria");
        Response<ImagesPrestationDto> response = controllerFactory.getByCriteria(imagesPrestationBusiness, request, FunctionalityEnum.VIEW_IMAGES_PRESTATION);
		// System.out.println("end method /imagesPrestation/getByCriteria");
        return response;
    }
}
