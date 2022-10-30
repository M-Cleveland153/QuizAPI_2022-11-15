package com.cooksys.quiz_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.quiz_api.dtos.QuestionResponseDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.services.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

  private final QuizService quizService;

  @GetMapping
  public List<QuizResponseDto> getAllQuizzes() {
    return quizService.getAllQuizzes();
  }
  
  // TODO: Implement the remaining 6 endpoints from the documentation.
  
  //POST Quiz; Creates a quiz and adds to collection
  //Returns the Quiz that it created
  @PostMapping
//  public QuizResponseDto createQuiz(@RequestBody QuizRequestDto quizRequestDto) {
//	  return quizService.createQuiz(quizRequestDto);
//  }
  
//  public QuizResponseDto createQuiz(@RequestBody CreateQuizRequestDto createQuizRequestDto) {
//	  return quizService.createQuiz(createQuizRequestDto);
//  }
  
  //DELETE quiz/{id} Deletes the specified quiz from collection
  //Returns the deleted Quiz
  @DeleteMapping("/{id}")
  public QuizResponseDto deleteQuiz(@PathVariable Long id) {
	  return quizService.deleteQuiz(id);
  }
  
  
  //PATCH quiz/{id}/rename/{newName} Rename the specified quiz using the new name given
  //Returns the renamed Quiz
  
  
  
  //GET quiz/{id}/random
  //Returns a random Question from the specified quiz
  @GetMapping("/{id}/random")
  public QuestionResponseDto getRandomQuestion(@PathVariable Long id) {
	  return quizService.getRandomQuestion(id);
  }
  
  //PATCH quiz/{id}/add Adds a question to the specified quiz
  //Receives a Question
  //Returns the modified Quiz
  
  //DELETE quiz/{id}/delete/{questionID} Deletes the specified question from the specified quiz
  //Returns the deleted Question
  //check if the question exists and belongs to the right quiz
  //404 not found if not in database
  //(advanced exception handling)

}
