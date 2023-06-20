package service_catalog_rating_mgmt.model.dto;

import java.io.Serializable;

public class ServiceCatalogRating_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3951592879492908367L;
	private Long serviceCatalogSeqNo;
	private Float rating;

	public Long getServiceCatalogSeqNo() {
		return serviceCatalogSeqNo;
	}

	public void setServiceCatalogSeqNo(Long serviceCatalogSeqNo) {
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public ServiceCatalogRating_DTO(Long serviceCatalogSeqNo, Float rating) {
		super();
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
		this.rating = rating;
	}

	public ServiceCatalogRating_DTO() {
		super();
	}

}