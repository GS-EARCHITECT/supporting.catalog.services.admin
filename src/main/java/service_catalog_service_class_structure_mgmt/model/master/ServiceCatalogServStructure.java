package service_catalog_service_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_CATALOG_PRODSTRUCTURE database table.
 * 
 */
@Entity
@Table(name = "SERVICE_CATALOG_SERVSTRUCTURE")
public class ServiceCatalogServStructure implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4012643470318435335L;
	
	@EmbeddedId
	private ServiceCatalogServStructurePK id;

	public ServiceCatalogServStructure() {
	}

	public ServiceCatalogServStructurePK getId() {
		return this.id;
	}

	public void setId(ServiceCatalogServStructurePK id) {
		this.id = id;
	}

	public ServiceCatalogServStructure(ServiceCatalogServStructurePK id) {
		super();
		this.id = id;
	}

}