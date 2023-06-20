package service_catalog_rating_mgmt.controller;

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
import service_catalog_rating_mgmt.model.dto.ServiceCatalogRating_DTO;
import service_catalog_rating_mgmt.services.I_ServiceCatalogRating_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceCatalogRatingManagement")
public class ServiceCatalogRating_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ServiceCatalogRating_Controller.class);

	@Autowired
	private I_ServiceCatalogRating_Service resourceCatalogRatingServ;

	@PostMapping("/new")
	public ResponseEntity<ServiceCatalogRating_DTO> newServiceCatalogRating(@RequestBody ServiceCatalogRating_DTO ServiceCatalogRating_DTO) 
	{
		ServiceCatalogRating_DTO ServiceCatalogRating_DTO2 = resourceCatalogRatingServ.newServiceCatalogRating(ServiceCatalogRating_DTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(ServiceCatalogRating_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getSelectServiceCatalogRatings", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogRating_DTO>> getSelectServiceCatalogRatings(@RequestBody ArrayList<Float> fids)
	{
		ArrayList<ServiceCatalogRating_DTO> ServiceCatalogRating_DTOs = resourceCatalogRatingServ.getSelectServiceCatalogRatings(fids);
		return new ResponseEntity<>(ServiceCatalogRating_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectServiceCatalogsRatingsForCatalogs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogRating_DTO>> getSelectServiceCatalogsRatingsForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ServiceCatalogRating_DTO> ServiceCatalogRating_DTOs = resourceCatalogRatingServ.getSelectServiceCatalogsRatingsForCatalogs(ids);
		return new ResponseEntity<>(ServiceCatalogRating_DTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllServiceCatalogRatings", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ServiceCatalogRating_DTO>> getAllServiceCatalogRatings() {
		ArrayList<ServiceCatalogRating_DTO> ServiceCatalogRating_DTOs = resourceCatalogRatingServ.getAllServiceCatalogRatings();
		return new ResponseEntity<>(ServiceCatalogRating_DTOs, HttpStatus.OK);
	}

	@PutMapping("/updServiceCatalogRating")
	public void updateServiceCatalogRating(@RequestBody ServiceCatalogRating_DTO ServiceCatalogRating_DTO) {
		resourceCatalogRatingServ.updServiceCatalogRating(ServiceCatalogRating_DTO);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogRatings")
	public void deleteSelectServiceCatalogRatings(@RequestBody ArrayList<Float> fids)
	{
		resourceCatalogRatingServ.delSelectServiceCatalogRatings(fids);
		return;
	}

	@DeleteMapping("/delSelectServiceCatalogsRatingsForCatalogs")
	public void delSelectServiceCatalogsRatingsForCatalogs(@RequestBody ArrayList<Long> ids) 
	{
		resourceCatalogRatingServ.delSelectServiceCatalogsRatingsForCatalogs(ids);
		return;
	}
	
	@DeleteMapping("/delAllServiceCatalogRating")
	public void deleteAllServiceCatalogRating() {
		resourceCatalogRatingServ.delAllServiceCatalogRatings();
		;
		return;
	}
}