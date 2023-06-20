package service_catalog_pricerange_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_CATALOG_PRICERANGE database table.
 * 
 */
@Entity
@Table(name = "SERVICE_CATALOG_PRICERANGE")
public class ServiceCatalogPriceRange implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9007366620964963373L;
	@EmbeddedId
	private ServiceCatalogPriceRangePK id;

	public ServiceCatalogPriceRange() {
	}

	public ServiceCatalogPriceRangePK getId() {
		return this.id;
	}

	public void setId(ServiceCatalogPriceRangePK id) {
		this.id = id;
	}

	public ServiceCatalogPriceRange(ServiceCatalogPriceRangePK id) {
		super();
		this.id = id;
	}

}