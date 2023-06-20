package service_catalog_location_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_CATALOG_LOCSTRUCTURE database table.
 * 
 */
@Entity
@Table(name = "SERVICE_CATALOG_LOCSTRUCTURE")
public class ServiceCatalogLocStructure implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7861481463509909631L;
	
	@EmbeddedId
	private ServiceCatalogLocStructurePK id;

	public ServiceCatalogLocStructure() {
	}

	public ServiceCatalogLocStructurePK getId() {
		return this.id;
	}

	public void setId(ServiceCatalogLocStructurePK id) {
		this.id = id;
	}

	public ServiceCatalogLocStructure(ServiceCatalogLocStructurePK id) {
		super();
		this.id = id;
	}

}