package service_catalog_location_class_structure_mgmt.controller;

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

import service_catalog_location_class_structure_mgmt.model.dto.ServiceCatalogLocStructure_DTO;
import service_catalog_location_class_structure_mgmt.services.I_ServiceCatalogLocStructure_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceCatalogLocStructureManagement")
public class ServiceCatalogLocStructure_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ServiceCatalogLocStructure_Controller.class);

	@Autowired
	private I_ServiceCatalogLocStructure_Service serviceCatalogLocStructureServ;

	@PostMapping("/new")
	public ResponseEntity<ServiceCatalogLocStructure_DTO> newServiceCatalogLocStructure(@RequestBody ServiceCatalogLocStructure_DTO ServiceCatalogLocStructure_DTO) 
	{
		ServiceCatalogLocStructure_DTO ServiceCatalogLocStructure_DTO2 = serviceCatalogLocStructureServ.newServiceCatalogLocStructure(ServiceCatalogLocStructure_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ServiceCatalogLocStructure_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getSelectServiceCatalogLocStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogLocStructure_DTO>> getSelectServiceCatalogLocStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		ArrayList<ServiceCatalogLocStructure_DTO> ServiceCatalogLocStructure_DTOs = serviceCatalogLocStructureServ.getSelectServiceCatalogLocStructures(ids, pids);
		return new ResponseEntity<>(ServiceCatalogLocStructure_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServiceCatalogsStructuresForCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogLocStructure_DTO>> getSelectServiceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ServiceCatalogLocStructure_DTO> ServiceCatalogLocStructure_DTOs = serviceCatalogLocStructureServ.getSelectServiceCatalogsStructuresForCatalogs(ids);
		return new ResponseEntity<>(ServiceCatalogLocStructure_DTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllServiceCatalogLocStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogLocStructure_DTO>> getAllServiceCatalogLocStructures() {
		ArrayList<ServiceCatalogLocStructure_DTO> ServiceCatalogLocStructure_DTOs = serviceCatalogLocStructureServ.getAllServiceCatalogLocStructures();
		return new ResponseEntity<>(ServiceCatalogLocStructure_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updServiceCatalogLocStructure")
	public void updateServiceCatalogLocStructure(@RequestBody ServiceCatalogLocStructure_DTO ServiceCatalogLocStructure_DTO) {
		serviceCatalogLocStructureServ.updServiceCatalogLocStructure(ServiceCatalogLocStructure_DTO);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogLocStructures")
	public void deleteSelectServiceCatalogLocStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		serviceCatalogLocStructureServ.delSelectServiceCatalogLocStructures(ids, pids);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogsStructuresForCatalogs")
	public void delSelectServiceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		serviceCatalogLocStructureServ.delSelectServiceCatalogsStructuresForCatalogs(ids);
		return;
	}
	
	@DeleteMapping("/delSelectServiceChildStructuresForCatalogs")
	public void delSelectServiceChildStructuresForCatalogs(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> cids) 
	{
		serviceCatalogLocStructureServ.delSelectServiceChildStructuresForCatalogs(ids, cids);
		return;
	}
	
	@DeleteMapping("/delAllServiceCatalogLocStructure")
	public void deleteAllServiceCatalogLocStructure() {
		serviceCatalogLocStructureServ.delAllServiceCatalogLocStructures();
		;
		return;
	}
}