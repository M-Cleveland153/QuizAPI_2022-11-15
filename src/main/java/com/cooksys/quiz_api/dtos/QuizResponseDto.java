package com.cooksys.quiz_api.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuizResponseDto {

  private Long quizId;

  private String quizName;

  public List<QuestionResponseDto> questions;

}
