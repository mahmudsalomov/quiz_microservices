package uz.maniac4j.organizationservice.quiz;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.maniac4j.organizationservice.config.ServiceNames;
import uz.maniac4j.organizationservice.organization.Organization;
import uz.maniac4j.organizationservice.organization.OrganizationRepository;
import uz.maniac4j.organizationservice.payload.Payload;
import uz.maniac4j.organizationservice.payload.Response;
import uz.maniac4j.organizationservice.quiz.dto.CategoryDto;
import uz.maniac4j.organizationservice.quiz.dto.QuizDto;
import uz.maniac4j.organizationservice.quiz.model.Category;
import uz.maniac4j.organizationservice.quiz.model.Quiz;
import uz.maniac4j.organizationservice.user.User;
import uz.maniac4j.organizationservice.user.UserRepository;

import java.util.Optional;

@Service
public class QuizService {
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final RestTemplate template;
    private final ServiceNames serviceNames;

    public QuizService(OrganizationRepository organizationRepository, UserRepository userRepository, RestTemplate template, ServiceNames serviceNames) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.template = template;
        this.serviceNames = serviceNames;
    }


    public Response<?> addCategory(CategoryDto dto, User user){
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isEmpty()) return Payload.notFound("User not found!");
        user=optionalUser.get();
        Optional<Organization> organization = organizationRepository.findByOwnerId(user.getId());
        if (organization.isEmpty()) return Payload.notFound("Organization not found!");
        dto.setOrganization_id(organization.get().getId());
        Category category = template.postForObject(serviceNames.getQuiz() + "/api/category/add", dto, Category.class);
        return Payload.ok(category);
    }


    public Response<?> addQuiz(QuizDto dto, User user){
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isEmpty()) return Payload.notFound("User not found!");
        user=optionalUser.get();
        Optional<Organization> organization = organizationRepository.findByOwnerId(user.getId());
        if (organization.isEmpty()) return Payload.notFound("Organization not found!");
        Quiz quiz=template.postForObject(serviceNames.getQuiz()+"/api/quiz/add",dto,Quiz.class);
        return Payload.ok(quiz);

    }



}
