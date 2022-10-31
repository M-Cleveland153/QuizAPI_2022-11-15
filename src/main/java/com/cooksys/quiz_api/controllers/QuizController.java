package com.cooksys.quiz_api.controllers;

import java.util.List;

import com.cooksys.quiz_api.dtos.QuestionRequestDto;
import com.cooksys.quiz_api.dtos.QuestionResponseDto;
import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.entities.Question;
import com.cooksys.quiz_api.services.QuizService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

  private final QuizService quizService;

  //COMPLETE!!
  @GetMapping
  public List<QuizResponseDto> getAllQuizzes() {
    return quizService.getAllQuizzes();
  }
  
  // TODO: Implement the remaining 6 endpoints from the documentation.
  
  //COMPLETE!! POST QUIZ
  @PostMapping
  public QuizResponseDto createQuiz(@RequestBody QuizRequestDto quizRequestDto) {
	  return quizService.createQuiz(quizRequestDto);
  }
  
  //COMPLETE!! DELETE QUIZ/{ID}
  @DeleteMapping("/{id}")
  public QuizResponseDto deleteQuiz(@PathVariable Long id) {
	  return quizService.deleteQuiz(id);
  }
  
  
  //COMPLETE!! PATCH QUIZ/{ID}/RENAME/{newName}
  @PatchMapping("/{id}/rename/{newName}")
  public QuizResponseDto renameQuiz(@PathVariable Long id, @PathVariable String newName){
	  return quizService.renameQuiz(id, newName);
  }
  
  
  
  
  
  //COMPLETE!!  GET QUIZ / {ID} / RANDOM
  @GetMapping("/{id}/random")
  public QuestionResponseDto getRandomQuestion(@PathVariable Long id){
	  return quizService.getRandomQuestion(id);
	  	  
  }
  
  
  
  
  //COMPLETE!!  PATCH QUIZ/ {ID}/ADD
  @PatchMapping("/{id}/add")
  public QuizResponseDto addQuestion(@PathVariable Long id, @RequestBody QuestionRequestDto questionRequestDto) {
	  return quizService.addQuestion(id, questionRequestDto);
  }
  
  
  
  // DELETE QUIZ/ {ID} /DELETE/{QUESTION ID}
  @DeleteMapping("/{id}/delete/{questionId}") 
  public QuestionResponseDto deleteQuestion(@PathVariable Long id, @PathVariable Long questionId) {
	  return quizService.deleteQuestion(id, questionId);
  }
  
  

}
