package service_catalog_compclass_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_CATALOG_COMPCLASSES database table.
 * 
 */
@Entity
@Table(name = "SERVICE_CATALOG_COMPCLASSES")
public class ServiceCatalogCompClass implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6282083458475929340L;
	
	@EmbeddedId
	private ServiceCatalogCompClassPK id;

	public ServiceCatalogCompClass() {
	}

	public ServiceCatalogCompClassPK getId() {
		return this.id;
	}

	public void setId(ServiceCatalogCompClassPK id) {
		this.id = id;
	}

	public ServiceCatalogCompClass(ServiceCatalogCompClassPK id) {
		super();
		this.id = id;
	}

}