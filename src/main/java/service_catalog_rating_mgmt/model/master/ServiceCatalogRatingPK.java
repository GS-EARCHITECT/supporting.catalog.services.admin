package service_catalog_rating_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SERVICE_CATALOG_RATINGS database table.
 * 
 */
@Embeddable
public class ServiceCatalogRatingPK implements Serializable 
{

	private static final long serialVersionUID = 1L;

	@Column(name = "SERVICE_CATALOG_SEQ_NO")
	private Long serviceCatalogSeqNo;

	@Column(name = "SERVICE_CATALOG_SEQ_NO")
	private Float rating;

	public ServiceCatalogRatingPK() {
	}

	public Long getServiceCatalogSeqNo() {
		return this.serviceCatalogSeqNo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
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
		ServiceCatalogRatingPK other = (ServiceCatalogRatingPK) obj;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (serviceCatalogSeqNo == null) {
			if (other.serviceCatalogSeqNo != null)
				return false;
		} else if (!serviceCatalogSeqNo.equals(other.serviceCatalogSeqNo))
			return false;
		return true;
	}

	public ServiceCatalogRatingPK(Long serviceCatalogSeqNo, Float rating) {
		super();
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
		this.rating = rating;
	}

}