package com.oito.employee.dao.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
@Embeddable
public class Audit {
	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_timestamp")
	private LocalDateTime createdTimestamp;

	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	@Column(name = "last_updated_timestamp")
	private LocalDateTime lastUpdatedTimestamp;

}
