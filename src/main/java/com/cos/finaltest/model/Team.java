package com.cos.finaltest.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
	int id;
	int stadiumId;
	String name;
	Timestamp createDate;
}
