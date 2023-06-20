package service_catalog_pricerange_mgmt.model.dto;

import java.io.Serializable;

public class ServiceCatalogPriceRange_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2501172951237174313L;
	private Float priceFr;
	private Long serviceCatalogSeqNo;
	private Float priceTo;

	public Float getPriceFr() {
		return priceFr;
	}

	public void setPriceFr(Float priceFr) {
		this.priceFr = priceFr;
	}

	public Long getServiceCatalogSeqNo() {
		return serviceCatalogSeqNo;
	}

	public void setServiceCatalogSeqNo(Long serviceCatalogSeqNo) {
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
	}

	public Float getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(Float priceTo) {
		this.priceTo = priceTo;
	}

	public ServiceCatalogPriceRange_DTO(Float priceFr, Long serviceCatalogSeqNo, Float priceTo) {
		super();
		this.priceFr = priceFr;
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
		this.priceTo = priceTo;
	}

	public ServiceCatalogPriceRange_DTO() {
		super();
	}

}