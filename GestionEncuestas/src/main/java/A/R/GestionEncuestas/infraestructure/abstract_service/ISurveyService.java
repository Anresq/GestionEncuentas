package A.R.GestionEncuestas.infraestructure.abstract_service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import A.R.GestionEncuestas.api.dto.Request.SurveyRequest;
import A.R.GestionEncuestas.api.dto.Response.SurveyResponse;
import A.R.GestionEncuestas.api.dto.Response.basic.SurveyBasicResponse;

@Service
public interface ISurveyService {
    
    Page<SurveyBasicResponse> getAll(int page, int size);

    SurveyResponse getById(Long id);

    SurveyBasicResponse create(SurveyRequest request);

}
