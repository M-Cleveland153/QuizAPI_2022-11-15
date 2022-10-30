package com.cooksys.quiz_api.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.cooksys.quiz_api.dtos.QuestionResponseDto;
import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.entities.Answer;
import com.cooksys.quiz_api.entities.Question;
import com.cooksys.quiz_api.entities.Quiz;
import com.cooksys.quiz_api.mappers.QuestionMapper;
import com.cooksys.quiz_api.mappers.QuizMapper;
import com.cooksys.quiz_api.repositories.QuizRepository;
import com.cooksys.quiz_api.services.QuizService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

	private final QuizRepository quizRepository;
	private final QuizMapper quizMapper;
	private final QuestionMapper questionMapper;

	@Override
	public List<QuizResponseDto> getAllQuizzes() {
		return quizMapper.entitiesToDtos(quizRepository.findAll());
	}

	@Override
	public QuestionResponseDto getRandomQuestion(Long id) {
		Quiz quiz = quizRepository.getById(id);
		Random random = new Random();
		List<Question> questions =  quiz.getQuestions();
		return questionMapper.entityToDto(questions.get(random.nextInt(questions.size())));
	}

	@Override
	public QuizResponseDto createQuiz(QuizRequestDto quizRequestDto) {
		Quiz quiz = quizMapper.requestDtoToEntity(quizRequestDto);
		for(Question question: quiz.getQuestions()) {
			question.setQuiz(quiz);
			for(Answer answer : question.getAnswers()) {
				answer.setQuestion(question);
			}
		}
		return quizMapper.entityToDto(quizRepository.saveAndFlush(quiz)); 
		
	}

	@Override
	public QuizResponseDto deleteQuiz(Long id) {
		Quiz quiz = quizRepository.getById(id);
		quizRepository.delete(quiz);
		return quizMapper.entityToDto(quiz);
	}

}
