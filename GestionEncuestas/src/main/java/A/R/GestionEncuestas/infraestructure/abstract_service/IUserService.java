package A.R.GestionEncuestas.infraestructure.abstract_service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import A.R.GestionEncuestas.api.dto.Request.UserRequest;
import A.R.GestionEncuestas.api.dto.Response.UserResponse;

@Service
public interface IUserService {
    
    Page<UserResponse> getAll(int page, int size);

    UserResponse getById(Long id);

    UserResponse create(UserRequest request);

    UserResponse update(UserRequest request, Long id);
    
}
