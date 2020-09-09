package com.cos.finaltest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonRespDto<T> {
	private int statusCode; //1정상,  -1실패, 0 변경 안됨 원래는 enum 써야한다.
	private T data;

}