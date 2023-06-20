package service_catalog_rating_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SERVICE_CATALOG_RATINGS database table.
 * 
 */
@Entity
@Table(name="SERVICE_CATALOG_RATINGS")
public class ServiceCatalogRating implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ServiceCatalogRatingPK id;

	public ServiceCatalogRating() {
	}

	public ServiceCatalogRatingPK getId() {
		return this.id;
	}

	public void setId(ServiceCatalogRatingPK id) {
		this.id = id;
	}

}