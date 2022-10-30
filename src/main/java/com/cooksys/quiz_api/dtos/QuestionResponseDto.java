package com.cooksys.quiz_api.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuestionResponseDto {

  private Long quesId;

  private String quesText;
  
//  private QuizIdNameRespDto quizIdNameRespDto;

  private List<AnswerResponseDto> answers;

}
