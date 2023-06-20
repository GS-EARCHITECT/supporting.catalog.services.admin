package service_catalog_pricerange_mgmt.controller;

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
import service_catalog_pricerange_mgmt.model.dto.ServiceCatalogPriceRange_DTO;
import service_catalog_pricerange_mgmt.services.I_ServiceCatalogPriceRange_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceCatalogPriceRangeManagement")
public class ServiceCatalogPriceRange_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ServiceCatalogPriceRange_Controller.class);

	@Autowired
	private I_ServiceCatalogPriceRange_Service serviceCatalogPriceRangeServ;

	@PostMapping("/new")
	public ResponseEntity<ServiceCatalogPriceRange_DTO> newServiceCatalogPriceRange(
			@RequestBody ServiceCatalogPriceRange_DTO ServiceCatalogPriceRange_DTO) {
		ServiceCatalogPriceRange_DTO ServiceCatalogPriceRange_DTO2 = serviceCatalogPriceRangeServ
				.newServiceCatalogPriceRange(ServiceCatalogPriceRange_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ServiceCatalogPriceRange_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllServiceCatalogPriceRanges", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogPriceRange_DTO>> getAllServiceCatalogPriceRanges() {
		ArrayList<ServiceCatalogPriceRange_DTO> ServiceCatalogPriceRange_DTOs = serviceCatalogPriceRangeServ
				.getAllServiceCatalogPriceRanges();
		return new ResponseEntity<>(ServiceCatalogPriceRange_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServiceCatalogsBetweenPrices/{frPrice}/{toPrice}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogPriceRange_DTO>> getSelectServiceCatalogsBetweenPrices(
			@RequestBody ArrayList<Long> ids, @PathVariable Float frPrice, @PathVariable Float toPrice) {
		ArrayList<ServiceCatalogPriceRange_DTO> ServiceCatalogPriceRange_DTOs = serviceCatalogPriceRangeServ
				.getSelectServiceCatalogsBetweenPrices(ids, frPrice, toPrice);
		return new ResponseEntity<>(ServiceCatalogPriceRange_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServiceCatalogsPriceRanges", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogPriceRange_DTO>> getSelectServiceCatalogsPriceRanges(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<ServiceCatalogPriceRange_DTO> ServiceCatalogPriceRange_DTOs = serviceCatalogPriceRangeServ
				.getSelectServiceCatalogsPriceRanges(ids);
		return new ResponseEntity<>(ServiceCatalogPriceRange_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServiceCatalogsForPriceRange/{frPrice}/{toPrice}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogPriceRange_DTO>> getSelectServiceCatalogsForPriceRange(
			@PathVariable Float frPrice, @PathVariable Float toPrice) {
		ArrayList<ServiceCatalogPriceRange_DTO> ServiceCatalogPriceRange_DTOs = serviceCatalogPriceRangeServ
				.getSelectServiceCatalogsForPriceRange(frPrice, toPrice);
		return new ResponseEntity<>(ServiceCatalogPriceRange_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updServiceCatalogPriceRange")
	public void updateServiceCatalogPriceRange(@RequestBody ServiceCatalogPriceRange_DTO ServiceCatalogPriceRange_DTO) {
		serviceCatalogPriceRangeServ.updServiceCatalogPriceRange(ServiceCatalogPriceRange_DTO);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogsBetweenPrices/{frPrice}/{toPrice}")
	public void delSelectServiceCatalogsBetweenPrices(@RequestBody ArrayList<Long> ids, @PathVariable Float frPrice,
			@PathVariable Float toPrice) {
		serviceCatalogPriceRangeServ.delSelectServiceCatalogsBetweenPrices(ids, frPrice, toPrice);
		return;
	}

	@DeleteMapping("/deltSelectServiceCatalogsPriceRanges")
	public void delSelectServiceCatalogsStructuresForCatalogs(@RequestBody ArrayList<Long> ids) {
		serviceCatalogPriceRangeServ.deltSelectServiceCatalogsPriceRanges(ids);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogsForPriceRange/{frPrice}/{toPrice}")
	public void delSelectServiceCatalogsForPriceRange(@PathVariable Float frPrice, @PathVariable Float toPrice) {
		serviceCatalogPriceRangeServ.delSelectServiceCatalogsForPriceRange(frPrice, toPrice);
		return;
	}

	@DeleteMapping("/delAllServiceCatalogPriceRange")
	public void deleteAllServiceCatalogPriceRange() {
		serviceCatalogPriceRangeServ.delAllServiceCatalogPriceRanges();
		;
		return;
	}
}