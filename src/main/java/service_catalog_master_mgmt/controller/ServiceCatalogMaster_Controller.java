package service_catalog_master_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service_catalog_master_mgmt.model.dto.ServiceCatalogMaster_DTO;
import service_catalog_master_mgmt.services.I_ServiceCatalogMaster_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceCatalogManagement")
public class ServiceCatalogMaster_Controller 
{

	//private static final Logger logger = LoggerFactory.getLogger(ServiceCatalogMasterController.class);

	@Autowired
	private I_ServiceCatalogMaster_Service serviceCatalogMasterServ;

	@PostMapping("/new")
	public ResponseEntity<ServiceCatalogMaster_DTO> newserviceCatalog(
			@RequestBody ServiceCatalogMaster_DTO serviceCatalogDTO) {
		ServiceCatalogMaster_DTO serviceCatalogDTO2 = serviceCatalogMasterServ.newServiceCatalog(serviceCatalogDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(serviceCatalogDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllServiceCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogMaster_DTO>> getAllServiceCatalogMasters() 
	{
		ArrayList<ServiceCatalogMaster_DTO> serviceCatalogDTOs = serviceCatalogMasterServ.getAllServiceCatalogs();		
		//logger.info("hit at all : " + System.currentTimeMillis());
		return new ResponseEntity<>(serviceCatalogDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServiceCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogMaster_DTO>> getSelectServiceCatalogsMasters(
			@RequestBody ArrayList<Long> serviceCatalogSeqNos) {
		ArrayList<ServiceCatalogMaster_DTO> serviceCatalogDTOs = serviceCatalogMasterServ
				.getSelectServiceCatalogs(serviceCatalogSeqNos);
		return new ResponseEntity<>(serviceCatalogDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServiceCatalogsForCompanies", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogMaster_DTO>> getSelectServiceCatalogsForCompanies(
			@RequestBody ArrayList<Long> serviceCatalogSeqNos) {
		ArrayList<ServiceCatalogMaster_DTO> serviceCatalogDTOs = serviceCatalogMasterServ
				.getSelectServiceCatalogsForCompanies(serviceCatalogSeqNos);
		return new ResponseEntity<>(serviceCatalogDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServiceCatalogsBetweenTimes/{fr}/{to}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogMaster_DTO>> getSelectServiceCatalogsBetweenTimes(
			@PathVariable String fr, @PathVariable String to) {
		ArrayList<ServiceCatalogMaster_DTO> serviceCatalogDTOs = serviceCatalogMasterServ
				.getSelectServiceCatalogsBetweenTimes(fr, to);
		return new ResponseEntity<>(serviceCatalogDTOs, HttpStatus.OK);
	}

	@PutMapping("/updServiceCatalog")
	public void updateServiceCatalog(@RequestBody ServiceCatalogMaster_DTO serviceCatalogDTO) {
		serviceCatalogMasterServ.updServiceCatalog(serviceCatalogDTO);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogs")
	public void deleteSelectserviceCatalogs(@RequestBody ArrayList<Long> serviceCatalogSeqNoList) {
		serviceCatalogMasterServ.delSelectServiceCatalogs(serviceCatalogSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogsForCompanies")
	public void delSelectServiceCatalogsForCompanies(@RequestBody ArrayList<Long> serviceCatalogSeqNoList) {
		serviceCatalogMasterServ.delSelectServiceCatalogsForCompanies(serviceCatalogSeqNoList);
		return;
	}
	
	@DeleteMapping("/delSelectServiceCatalogsBetweenTimes/{fr}/{to}")
	public void delSelectServiceCatalogsBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		serviceCatalogMasterServ.delSelectServiceCatalogsBetweenTimes(fr, to);
		return;
	}

	@DeleteMapping("/delAllServiceCatalogs")
	public void deleteAllServiceCatalogs() {
		serviceCatalogMasterServ.delAllServiceCatalogs();
		;
		return;
	}
}