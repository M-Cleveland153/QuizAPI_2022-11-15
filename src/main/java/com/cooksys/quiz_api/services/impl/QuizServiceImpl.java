package com.cooksys.quiz_api.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.cooksys.quiz_api.dtos.QuestionRequestDto;
import com.cooksys.quiz_api.dtos.QuestionResponseDto;
import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.entities.Answer;
import com.cooksys.quiz_api.entities.Question;
import com.cooksys.quiz_api.entities.Quiz;
import com.cooksys.quiz_api.mappers.QuestionMapper;
import com.cooksys.quiz_api.mappers.QuizMapper;
import com.cooksys.quiz_api.repositories.AnswerRepository;
import com.cooksys.quiz_api.repositories.QuestionRepository;
import com.cooksys.quiz_api.repositories.QuizRepository;
import com.cooksys.quiz_api.services.QuizService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

	private final QuizRepository quizRepository;
	private final QuizMapper quizMapper;
	private final QuestionRepository questionRepository;
	private final QuestionMapper questionMapper;
	private final AnswerRepository answerRepository;
	
	private Quiz getQuiz(Long id) {
		Optional<Quiz> optionalQuiz = quizRepository.findById(id);
		// exception logic goes here
		
		return optionalQuiz.get();
	}
	
	private Question getQuestion(Long id) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		//exception logic goes here
		
		return optionalQuestion.get();
	}

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

	@Override  //id is the Quiz id
	public QuizResponseDto addQuestion(Long id, QuestionRequestDto questionRequestDto) {
		Quiz quizToUpdate = getQuiz(id);
		Question questionToAdd = questionMapper.questionRequestDtoToEntity(questionRequestDto);
		for(Answer answer: questionToAdd.getAnswers()) {
			answer.setQuestion(questionToAdd);
		}
		questionToAdd.setQuiz(quizToUpdate);
		quizToUpdate.getQuestions().add(questionToAdd);
		return quizMapper.entityToDto(quizRepository.saveAndFlush(quizToUpdate));
	}

	@Override
	public QuizResponseDto renameQuiz(Long id, String newName) {
		Quiz quizToUpdate = quizRepository.getById(id);
		quizToUpdate.setName(newName);
		return quizMapper.entityToDto(quizRepository.saveAndFlush(quizToUpdate));
	}

	@Override  //id is quiz id
	public QuestionResponseDto deleteQuestion(Long id, Long questionId) {
		Quiz targetQuiz = getQuiz(id);
		Question questionToDelete = getQuestion(questionId);
		
		//check to see if questions has target question here and throw exception if not
		
		targetQuiz.getQuestions().remove(questionToDelete);
		quizRepository.saveAndFlush(targetQuiz);
		answerRepository.deleteAll(questionToDelete.getAnswers());
		questionRepository.delete(questionToDelete);
		
		return questionMapper.entityToDto(questionToDelete);
		
	}
	
	

}
