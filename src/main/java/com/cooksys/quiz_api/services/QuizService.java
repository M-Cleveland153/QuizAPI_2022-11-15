package com.cooksys.quiz_api.services;

import java.util.List;

import com.cooksys.quiz_api.dtos.QuestionRequestDto;
import com.cooksys.quiz_api.dtos.QuestionResponseDto;
import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.entities.Question;

public interface QuizService {

  List<QuizResponseDto> getAllQuizzes();

	QuestionResponseDto getRandomQuestion(Long id);

	QuizResponseDto createQuiz(QuizRequestDto quizRequestDto);

	QuizResponseDto deleteQuiz(Long id);

	QuizResponseDto addQuestion(Long id, QuestionRequestDto questionRequestDto);

	QuizResponseDto renameQuiz(Long id, String newName);

	QuestionResponseDto deleteQuestion(Long id, Long questionId); //id is quiz id

}
