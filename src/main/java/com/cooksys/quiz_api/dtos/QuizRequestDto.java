package com.cooksys.quiz_api.dtos;

import java.util.List;

import javax.persistence.Id;

import com.cooksys.quiz_api.entities.Question;
import com.fasterxml.jackson.core.sym.Name;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuizRequestDto {
	
//	private String name;
//	
//	//should be requestDTO
//	private List<Question> questions; 
	
	private Long quizId;

}
