

/*
 * Java controller for entity table zone_livraison 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdy.brobrosseur.rest.api;

import com.wdy.brobrosseur.business.ZoneLivraisonBusiness;
import com.wdy.brobrosseur.rest.fact.ControllerFactory;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.contract.Response;
import com.wdy.brobrosseur.utils.dto.ZoneLivraisonDto;
import com.wdy.brobrosseur.utils.enums.FunctionalityEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
Controller for table "zone_livraison"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/zoneLivraison")
public class ZoneLivraisonController {

	@Autowired
    private ControllerFactory<ZoneLivraisonDto> controllerFactory;
	@Autowired
	private ZoneLivraisonBusiness zoneLivraisonBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ZoneLivraisonDto> create(@RequestBody Request<ZoneLivraisonDto> request) {
    	// System.out.println("start method /zoneLivraison/create");
        Response<ZoneLivraisonDto> response = controllerFactory.create(zoneLivraisonBusiness, request, FunctionalityEnum.CREATE_ZONE_LIVRAISON);
		// System.out.println("end method /zoneLivraison/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ZoneLivraisonDto> update(@RequestBody Request<ZoneLivraisonDto> request) {
    	// System.out.println("start method /zoneLivraison/update");
        Response<ZoneLivraisonDto> response = controllerFactory.update(zoneLivraisonBusiness, request, FunctionalityEnum.UPDATE_ZONE_LIVRAISON);
		// System.out.println("end method /zoneLivraison/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ZoneLivraisonDto> delete(@RequestBody Request<ZoneLivraisonDto> request) {
    	// System.out.println("start method /zoneLivraison/delete");
        Response<ZoneLivraisonDto> response = controllerFactory.delete(zoneLivraisonBusiness, request, FunctionalityEnum.DELETE_ZONE_LIVRAISON);
		// System.out.println("end method /zoneLivraison/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ZoneLivraisonDto> getByCriteria(@RequestBody Request<ZoneLivraisonDto> request) {
    	// System.out.println("start method /zoneLivraison/getByCriteria");
        Response<ZoneLivraisonDto> response = controllerFactory.getByCriteria(zoneLivraisonBusiness, request, FunctionalityEnum.VIEW_ZONE_LIVRAISON);
		// System.out.println("end method /zoneLivraison/getByCriteria");
        return response;
    }
}
