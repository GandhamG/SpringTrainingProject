package com.oito.employee.dao.audit;

import com.oito.employee.dao.entity.Audit;

public interface Auditable {

	Audit getAudit();

	void setAudit(Audit audit);

}
