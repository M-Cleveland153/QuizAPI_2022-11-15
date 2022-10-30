package com.cooksys.quiz_api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.quiz_api.dtos.QuestionResponseDto;
import com.cooksys.quiz_api.dtos.QuizRequestDto;
import com.cooksys.quiz_api.dtos.QuizResponseDto;
import com.cooksys.quiz_api.entities.Quiz;
import com.cooksys.quiz_api.mappers.AnswerMapper;
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
	private final AnswerMapper answerMapper;
	
	private Quiz getQuiz(Long id) {
		Optional<Quiz> optionalQuiz = quizRepository.findById(id);
		//exception logic can go here
		
		return optionalQuiz.get();
	}

	@Override
	public List<QuizResponseDto> getAllQuizzes() {
		return quizMapper.entitiesToDtos(quizRepository.findAll());
	}

	@Override
	public QuizResponseDto createQuiz(QuizRequestDto quizRequestDto) {
		Quiz quizToSave = quizMapper.requestDtoToEntity(quizRequestDto);
		//for each question save (question repo) etc.
		return quizMapper.entityToDto(quizRepository.saveAndFlush(quizToSave));//does not auto save questions and answers
	}
	
//	public QuizResponseDto createQuiz(CreateQuizRequestDto createQuizRequestDto) {
//		List<QuestionRequestDto> questionIdsList = createQuizRequestDto.getQuestionIdsList();
//		
//		List<Question> questionEntitiesList = new ArrayList<>();
//		//for each questionRequestDto in questionIdsList, map to entity and add to list of entities
//		for(QuestionRequestDto questionRequestDto : questionIdsList) {
//			Question questionEntity = questionMapper.dtoToEntity(questionRequestDto);
//			questionEntitiesList.add(questionEntity);
//		}
//		
//		for(Question question : questionEntitiesList) {
//			
//			QuestionResponseDto questionResponseDto = new QuestionResponseDto();
//						
//			List<Answer> answerList = question.getAnswers();
//			List<AnswerResponseDto> answerResponseDtoList = new ArrayList<>();
//			for(Answer answer: answerList) {
//				AnswerResponseDto answerResponseDto = answerMapper.entityToDto(answer);
//				answerResponseDtoList.add(answerResponseDto);
//			}
//			questionResponseDto.setAnswers(answerResponseDtoList);
//			questionResponseDto.setQuesId(question.getQuesId());
//			questionResponseDto.setQuesText(question.getQuesText());
//
//			QuizIdNameRespDto quizIdNameRespDto = new QuizIdNameRespDto();
//			quizIdNameRespDto.setQuizName(createQuizRequestDto.getQuizName());
//			
//			QuestionResponseDto.setQuizIdNameRespDto()
//			
//		}
//		
//		QuizResponseDto quizResponseDto = new QuizResponseDto();
//		quizResponseDto.setQuizName(createQuizRequestDto.getQuizName());
//		
//		
//					
//	}
	

	
	@Override
	public QuizResponseDto deleteQuiz(Long id) {
		Quiz quizToDelete = getQuiz(id); //custom private getter, see above
		QuizResponseDto quizResponseDto = quizMapper.entityToDto(quizToDelete);
		quizRepository.delete(quizToDelete); //this quiz has answers (and questions) that must be deleted first
		return quizResponseDto; //failing to return the specific quiz. Trying to load questions, but there are no questions
		
	}
	
	//PATCH quiz/{id}/rename/{newName} Rename the specified quiz using the new name given
	  //Returns the renamed Quiz
	  
	
	@Override
	public QuestionResponseDto getRandomQuestion(Long id) {
		// TODO Auto-generated method stub
		return null;
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
