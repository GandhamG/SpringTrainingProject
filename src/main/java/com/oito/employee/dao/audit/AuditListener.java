package com.oito.employee.dao.audit;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Value;

import com.oito.employee.dao.entity.Audit;

public class AuditListener {

	@Value("${name}")
	private String user;

	@PrePersist
	public void setAuditFieldsOnInsert(final Auditable auditable) {

		final var audit = new Audit();
		auditable.setAudit(audit);
		audit.setCreatedBy(user);
		audit.setCreatedTimestamp(LocalDateTime.now());
		audit.setLastUpdatedBy(user);
		audit.setLastUpdatedTimestamp(LocalDateTime.now());

	}

	@PreUpdate
	public void setAuditFieldsOnUpdate(final Auditable auditable) {

		final var audit = auditable.getAudit();
		audit.setLastUpdatedBy(user);
		audit.setLastUpdatedTimestamp(LocalDateTime.now());

	}
}
