package service_catalog_pricerange_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SERVICE_CATALOG_PRICERANGE database table.
 * 
 */
@Embeddable
public class ServiceCatalogPriceRangePK implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7326852860377653529L;

	@Column(name = "PRICE_FR")
	private Float priceFr;

	@Column(name = "SERVICE_CATALOG_SEQ_NO")
	private Long serviceCatalogSeqNo;

	@Column(name = "PRICE_TO")
	private Float priceTo;

	public ServiceCatalogPriceRangePK() {
	}

	public Float getPriceFr() {
		return this.priceFr;
	}

	public void setPriceFr(Float priceFr) {
		this.priceFr = priceFr;
	}

	public Long getServiceCatalogSeqNo() {
		return this.serviceCatalogSeqNo;
	}

	public void setServiceCatalogSeqNo(Long serviceCatalogSeqNo) {
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
	}

	public Float getPriceTo() {
		return this.priceTo;
	}

	public void setPriceTo(Float priceTo) {
		this.priceTo = priceTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((priceFr == null) ? 0 : priceFr.hashCode());
		result = prime * result + ((priceTo == null) ? 0 : priceTo.hashCode());
		result = prime * result + ((serviceCatalogSeqNo == null) ? 0 : serviceCatalogSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceCatalogPriceRangePK other = (ServiceCatalogPriceRangePK) obj;
		if (priceFr == null) {
			if (other.priceFr != null)
				return false;
		} else if (!priceFr.equals(other.priceFr))
			return false;
		if (priceTo == null) {
			if (other.priceTo != null)
				return false;
		} else if (!priceTo.equals(other.priceTo))
			return false;
		if (serviceCatalogSeqNo == null) {
			if (other.serviceCatalogSeqNo != null)
				return false;
		} else if (!serviceCatalogSeqNo.equals(other.serviceCatalogSeqNo))
			return false;
		return true;
	}

	public ServiceCatalogPriceRangePK(Float priceFr, Long serviceCatalogSeqNo, Float priceTo) {
		super();
		this.priceFr = priceFr;
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
		this.priceTo = priceTo;
	}

}