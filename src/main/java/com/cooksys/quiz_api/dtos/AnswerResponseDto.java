package com.cooksys.quiz_api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AnswerResponseDto {

//  private Long ansId;

	private String ansText;

	private boolean correct;
	
//	private QuestionTextRespDto quesText;

}
