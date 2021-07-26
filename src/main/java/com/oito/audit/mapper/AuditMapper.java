package com.oito.audit.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.oito.employee.dao.entity.Audit;
import com.oito.employee.vo.AuditVO;

@Component
@Mapper(componentModel = "spring")
public interface AuditMapper {
	Audit toAudit(AuditVO auditVO);
}
