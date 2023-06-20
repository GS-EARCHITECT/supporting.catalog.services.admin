package service_catalog_location_class_structure_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import service_catalog_location_class_structure_mgmt.model.master.ServiceCatalogLocStructure;
import service_catalog_location_class_structure_mgmt.model.master.ServiceCatalogLocStructurePK;

@Repository("serviceCatalogLocStuctureRepo")
public interface ServiceCatalogLocStucture_Repo extends JpaRepository<ServiceCatalogLocStructure, ServiceCatalogLocStructurePK> 
{
	@Query(value = "SELECT * FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE (a.location_class_seq_no in :ids and a.par_location_class_seq_no in :pids) order by location_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogLocStructure> getSelectServiceCatalogStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE a.service_catalog_seq_no in :ids order by location_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogLocStructure> getSelectServiceCatalogsStructuresForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE (a.service_catalog_seq_no in :ids and a.location_class_seq_no in :cids) order by location_catalog_seq_no", nativeQuery = true)
	ArrayList<ServiceCatalogLocStructure> getSelectServiceChildStructuresForCatalogs(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
	
	@Query(value = "DELETE FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE (a.location_class_seq_no in :ids and a.par_location_class_seq_no in :pids)", nativeQuery = true)
	void delSelectServiceCatalogStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE a.service_catalog_seq_no in :ids", nativeQuery = true)
	void delSelectServiceCatalogsStructuresForCatalogs(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM RESOURCE_CATALOG_LOCSTRUCTURE a WHERE (a.service_catalog_seq_no in :ids and a.location_class_seq_no in :cids)", nativeQuery = true)
	void delSelectServiceChildStructuresForCatalogs(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);
}
