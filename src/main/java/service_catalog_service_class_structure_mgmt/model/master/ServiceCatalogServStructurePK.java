package service_catalog_service_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ServiceCatalogServStructurePK implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1331515620447112510L;

	@Column(name = "SERVICE_CLASS_SEQ_NO")
	private Long serviceClassSeqNo;

	@Column(name = "PAR_SERVICE_CLASS_SEQ_NO")
	private Long parServiceClassSeqNo;

	@Column(name = "SERVICE_CATALOG_SEQ_NO")
	private Long serviceCatalogSeqNo;

	public ServiceCatalogServStructurePK() {
	}

	public Long getServiceClassSeqNo() {
		return this.serviceClassSeqNo;
	}

	public void setServiceClassSeqNo(Long serviceClassSeqNo) {
		this.serviceClassSeqNo = serviceClassSeqNo;
	}

	public Long getParServiceClassSeqNo() {
		return this.parServiceClassSeqNo;
	}

	public void setParServiceClassSeqNo(Long parServiceClassSeqNo) {
		this.parServiceClassSeqNo = parServiceClassSeqNo;
	}

	public Long getServiceCatalogSeqNo() {
		return this.serviceCatalogSeqNo;
	}

	public void setServiceCatalogSeqNo(Long serviceCatalogSeqNo) {
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ServiceCatalogServStructurePK)) {
			return false;
		}
		ServiceCatalogServStructurePK castOther = (ServiceCatalogServStructurePK) other;
		return (this.serviceClassSeqNo == castOther.serviceClassSeqNo)
				&& (this.parServiceClassSeqNo == castOther.parServiceClassSeqNo)
				&& (this.serviceCatalogSeqNo == castOther.serviceCatalogSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.serviceClassSeqNo ^ (this.serviceClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parServiceClassSeqNo ^ (this.parServiceClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.serviceCatalogSeqNo ^ (this.serviceCatalogSeqNo >>> 32)));

		return hash;
	}

	public ServiceCatalogServStructurePK(Long serviceClassSeqNo, Long parServiceClassSeqNo,
			Long serviceCatalogSeqNo) {
		super();
		this.serviceClassSeqNo = serviceClassSeqNo;
		this.parServiceClassSeqNo = parServiceClassSeqNo;
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
	}

}