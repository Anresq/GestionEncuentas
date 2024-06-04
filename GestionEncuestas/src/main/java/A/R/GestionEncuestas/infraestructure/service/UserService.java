package A.R.GestionEncuestas.infraestructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import A.R.GestionEncuestas.api.dto.Request.UserRequest;
import A.R.GestionEncuestas.api.dto.Response.UserResponse;
import A.R.GestionEncuestas.domain.entities.User;
import A.R.GestionEncuestas.domain.repositories.UserRepository;
import A.R.GestionEncuestas.infraestructure.abstract_service.IUserService;
import A.R.GestionEncuestas.infraestructure.helpers.EntityToEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.userRepository.findAll(pagination).map(this::entityToResponse);
        // throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public UserResponse getById(Long id) {
        return entityToResponse(find(id));
        // throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public UserResponse create(UserRequest request) {
        return this.entityToResponse(this.userRepository.save(EntityToEntity.entityToEntity(request, User.class)));
        // throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public UserResponse update(UserRequest request, Long id) {
        this.find(id);
        User userUpdated = EntityToEntity.entityToEntity(request, User.class);
        userUpdated.setId_User(id);
        return this.entityToResponse(this.userRepository.save(userUpdated));
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    private User find(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    private UserResponse entityToResponse(User entity) {
        return EntityToEntity.entityToEntity(entity, UserResponse.class);
    }

}
