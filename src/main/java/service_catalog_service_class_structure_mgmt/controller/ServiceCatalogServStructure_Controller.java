package service_catalog_service_class_structure_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service_catalog_service_class_structure_mgmt.model.dto.ServiceCatalogServStructure_DTO;
import service_catalog_service_class_structure_mgmt.services.I_ServiceCatalogServStructure_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceCatalogServStructureManagement")
public class ServiceCatalogServStructure_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ServiceCatalogServStructure_Controller.class);

	@Autowired
	private I_ServiceCatalogServStructure_Service serviceCatalogServStructureServ;

	@PostMapping("/new")
	public ResponseEntity<ServiceCatalogServStructure_DTO> newServiceCatalogServStructure(@RequestBody ServiceCatalogServStructure_DTO ServiceCatalogServStructure_DTO) 
	{
		ServiceCatalogServStructure_DTO ServiceCatalogServStructure_DTO2 = serviceCatalogServStructureServ.newServiceCatalogServStructure(ServiceCatalogServStructure_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ServiceCatalogServStructure_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getSelectServiceCatalogServStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogServStructure_DTO>> getSelectServiceCatalogServStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		ArrayList<ServiceCatalogServStructure_DTO> ServiceCatalogServStructure_DTOs = serviceCatalogServStructureServ.getSelectServiceCatalogServStructures(ids, pids);
		return new ResponseEntity<>(ServiceCatalogServStructure_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServiceCatalogsStructuresForCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogServStructure_DTO>> getSelectServiceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ServiceCatalogServStructure_DTO> ServiceCatalogServStructure_DTOs = serviceCatalogServStructureServ.getSelectServiceCatalogsStructuresForCatalogs(ids);
		return new ResponseEntity<>(ServiceCatalogServStructure_DTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllServiceCatalogServStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogServStructure_DTO>> getAllServiceCatalogServStructures() {
		ArrayList<ServiceCatalogServStructure_DTO> ServiceCatalogServStructure_DTOs = serviceCatalogServStructureServ.getAllServiceCatalogServStructures();
		return new ResponseEntity<>(ServiceCatalogServStructure_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updServiceCatalogServStructure")
	public void updateServiceCatalogServStructure(@RequestBody ServiceCatalogServStructure_DTO ServiceCatalogServStructure_DTO) {
		serviceCatalogServStructureServ.updServiceCatalogServStructure(ServiceCatalogServStructure_DTO);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogServStructures")
	public void deleteSelectServiceCatalogServStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		serviceCatalogServStructureServ.delSelectServiceCatalogServStructures(ids, pids);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogsStructuresForCatalogs")
	public void delSelectServiceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		serviceCatalogServStructureServ.delSelectServiceCatalogsStructuresForCatalogs(ids);
		return;
	}
	
	@DeleteMapping("/delSelectServiceChildStructuresForCatalogs")
	public void delSelectServiceChildStructuresForCatalogs(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> cids) 
	{
		serviceCatalogServStructureServ.delSelectServiceChildStructuresForCatalogs(ids, cids);
		return;
	}
	
	@DeleteMapping("/delAllServiceCatalogServStructure")
	public void deleteAllServiceCatalogServStructure() {
		serviceCatalogServStructureServ.delAllServiceCatalogServStructures();
		;
		return;
	}
}