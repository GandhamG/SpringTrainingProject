package com.oito.employee.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditVO {
	private String createdBy;

	private LocalDateTime createdTimestamp;

	private String lastUpdatedBy;

	private LocalDateTime lastUpdatedTimestamp;

}
