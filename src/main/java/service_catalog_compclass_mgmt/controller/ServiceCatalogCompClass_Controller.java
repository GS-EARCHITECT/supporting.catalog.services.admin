package service_catalog_compclass_mgmt.controller;

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
import service_catalog_compclass_mgmt.model.dto.ServiceCatalogCompClass_DTO;
import service_catalog_compclass_mgmt.services.I_ServiceCatalogCompClass_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceCatalogCompanyClassManagement")
public class ServiceCatalogCompClass_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ServiceCatalogCompClass_Controller.class);

	@Autowired
	private I_ServiceCatalogCompClass_Service serviceCatalogCompClassServ;

	@PostMapping("/new")
	public ResponseEntity<ServiceCatalogCompClass_DTO> newServiceCatalogCompClass(@RequestBody ServiceCatalogCompClass_DTO ServiceCatalogCompClass_DTO) 
	{
		ServiceCatalogCompClass_DTO ServiceCatalogCompClass_DTO2 = serviceCatalogCompClassServ.newServiceCatalogCompClass(ServiceCatalogCompClass_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ServiceCatalogCompClass_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getSelectServiceCatalogCompanyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogCompClass_DTO>> getSelectServiceCatalogCompanies(@RequestBody ArrayList<Long> fids)
	{
		ArrayList<ServiceCatalogCompClass_DTO> ServiceCatalogCompClass_DTOs = serviceCatalogCompClassServ.getSelectServiceCatalogCompanies(fids);
		return new ResponseEntity<>(ServiceCatalogCompClass_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServiceCatalogsCompanyClassesForCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogCompClass_DTO>> getSelectServiceCatalogsCompaniesForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ServiceCatalogCompClass_DTO> ServiceCatalogCompClass_DTOs = serviceCatalogCompClassServ.getSelectServiceCatalogsCompaniesForCatalogs(ids);
		return new ResponseEntity<>(ServiceCatalogCompClass_DTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllServiceCatalogCompanyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogCompClass_DTO>> getAllServiceCatalogCompanies() {
		ArrayList<ServiceCatalogCompClass_DTO> ServiceCatalogCompClass_DTOs = serviceCatalogCompClassServ.getAllServiceCatalogCompanies();
		return new ResponseEntity<>(ServiceCatalogCompClass_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updServiceCatalogCompanyClass")
	public void updateServiceCatalogCompClass(@RequestBody ServiceCatalogCompClass_DTO ServiceCatalogCompClass_DTO) {
		serviceCatalogCompClassServ.updServiceCatalogCompClass(ServiceCatalogCompClass_DTO);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogCompanyClasses")
	public void deleteSelectServiceCatalogCompanies(@RequestBody ArrayList<Long> fids)
	{
		serviceCatalogCompClassServ.delSelectServiceCatalogCompanies(fids);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogsCompanyClassesForCatalogs")
	public void delSelectServiceCatalogsCompaniesForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		serviceCatalogCompClassServ.delSelectServiceCatalogsCompaniesForCatalogs(ids);
		return;
	}
	
	@DeleteMapping("/delAllServiceCatalogCompanyClass")
	public void deleteAllServiceCatalogCompClass() {
		serviceCatalogCompClassServ.delAllServiceCatalogCompanies();		
		return;
	}
}