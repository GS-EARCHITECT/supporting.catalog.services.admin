package service_catalog_compclass_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SERVICE_CATALOG_COMPCLASSES database table.
 * 
 */
@Embeddable
public class ServiceCatalogCompClassPK implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6460444811611726097L;

	@Column(name = "SERVICE_CATALOG_SEQ_NO")
	private Long serviceCatalogSeqNo;

	@Column(name = "COMPANY_CLASS_SEQ_NO")
	private Long companyClassSeqNo;

	public ServiceCatalogCompClassPK() {
	}

	public Long getServiceCatalogSeqNo() {
		return this.serviceCatalogSeqNo;
	}

	public void setServiceCatalogSeqNo(Long serviceCatalogSeqNo) {
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
	}

	public Long getCompanyClassSeqNo() {
		return this.companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ServiceCatalogCompClassPK)) {
			return false;
		}
		ServiceCatalogCompClassPK castOther = (ServiceCatalogCompClassPK) other;
		return (this.serviceCatalogSeqNo == castOther.serviceCatalogSeqNo)
				&& (this.companyClassSeqNo == castOther.companyClassSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.serviceCatalogSeqNo ^ (this.serviceCatalogSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.companyClassSeqNo ^ (this.companyClassSeqNo >>> 32)));
		return hash;
	}

	public ServiceCatalogCompClassPK(Long serviceCatalogSeqNo, Long companyClassSeqNo) {
		super();
		this.serviceCatalogSeqNo = serviceCatalogSeqNo;
		this.companyClassSeqNo = companyClassSeqNo;
	}

}