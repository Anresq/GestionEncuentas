package A.R.GestionEncuestas.infraestructure.service;
import A.R.GestionEncuestas.domain.entities.Question;
import A.R.GestionEncuestas.domain.entities.Survey;
import A.R.GestionEncuestas.domain.repositories.SurveyRepository;
import A.R.GestionEncuestas.domain.repositories.UserRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import A.R.GestionEncuestas.api.dto.Request.SurveyRequest;
import A.R.GestionEncuestas.api.dto.Response.QuestionResponse;
import A.R.GestionEncuestas.api.dto.Response.SurveyResponse;
import A.R.GestionEncuestas.api.dto.Response.basic.SurveyBasicResponse;
import A.R.GestionEncuestas.infraestructure.abstract_service.ISurveyService;
import A.R.GestionEncuestas.infraestructure.helpers.EntityToEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class SurveyService implements ISurveyService {

    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<SurveyBasicResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.surveyRepository.findAll(pagination).map(this::entityToBasicResponse);
    }

    @Override
    public SurveyResponse getById(Long id) {
        return entityToResponse(find(id));
    }

    @Override
    public SurveyBasicResponse create(SurveyRequest request) {
        Survey survey = EntityToEntity.entityToEntity(request, Survey.class);
        survey.setQuestions(new ArrayList()<>());
        survey.setCreator(this.userRepository.findById(request.getCreator()).orElseThrow());
        return this.entityToBasicResponse(
                this.surveyRepository.save(survey));
    }

    private Survey find(Long id) {
        return this.surveyRepository.findById(id).orElseThrow();
    }

    private SurveyBasicResponse entityToBasicResponse(Survey entity) {
        return EntityToEntity.entityToEntity(entity, SurveyBasicResponse.class);
    }

    private SurveyResponse entityToResponse(Survey entity) {
        SurveyResponse surveyResponse = EntityToEntity.entityToEntity(entity, SurveyResponse.class);
        surveyResponse.setQuestions(entity.getQuestions().stream().map(this::questionToResponse).toList());
        return surveyResponse;
    }

    private QuestionResponse questionToResponse(Question question) {
        QuestionResponse questionResponse = EntityToEntity.entityToEntity(question, QuestionResponse.class);
        questionResponse.setOptions(question.getOptions().stream().map(
                option -> {
                    return EntityToEntity.entityToEntity(option, OptionQuestionResponse.class);
                }).toList());
        return questionResponse;
    }



}