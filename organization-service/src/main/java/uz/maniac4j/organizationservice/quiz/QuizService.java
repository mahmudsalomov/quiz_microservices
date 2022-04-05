package uz.maniac4j.organizationservice.quiz;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.maniac4j.organizationservice.config.ServiceNames;
import uz.maniac4j.organizationservice.organization.Organization;
import uz.maniac4j.organizationservice.organization.OrganizationRepository;
import uz.maniac4j.organizationservice.payload.Payload;
import uz.maniac4j.organizationservice.payload.Response;
import uz.maniac4j.organizationservice.quiz.dto.BlockDto;
import uz.maniac4j.organizationservice.quiz.dto.CategoryDto;
import uz.maniac4j.organizationservice.quiz.dto.QuizDto;
import uz.maniac4j.organizationservice.quiz.model.Block;
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


    public Response<?> createCategory(CategoryDto dto, User user){
        Response<Object> notFound = checkUserAndOrganization(user);
        if (notFound != null) return notFound;
        dto.setOrganization_id(user.getOrganization().getId());
        Category category = template.postForObject(serviceNames.getQuiz() + "/api/category/add", dto, Category.class);
        return Payload.ok(category);
    }


    public Response<?> createQuiz(QuizDto dto, User user){
        Response<Object> notFound = checkUserAndOrganization(user);
        if (notFound != null) return notFound;
        Quiz quiz=template.postForObject(serviceNames.getQuiz()+"/api/quiz/add",dto,Quiz.class);
        return Payload.ok(quiz);
    }


    public Response<?> createBlock(BlockDto dto, User user){
        Response<Object> notFound = checkUserAndOrganization(user);
        if (notFound != null) return notFound;
        Block block=template.postForObject(serviceNames.getQuiz()+"/api/block/add/custom",dto,Block.class);
        return Payload.ok(block);
    }




    public Response<?> getAllQuizByOrganization(User user, Optional<Integer> page, Optional<Integer> pageSize, Optional<String> sortBy){
        Pageable pg = PageRequest.of(page.isPresent()&&page.get()!=0?page.get()-1:0, pageSize.orElse(10), Sort.Direction.DESC, sortBy.orElse("id"));
        Response<Object> notFound = checkUserAndOrganization(user);
        if (notFound != null) return notFound;
        String object = template.postForObject(serviceNames.getQuiz() + "/api/quiz/all/organization/" + user.getOrganization().getId(),pg, String.class);
        System.out.println(object);
        return Payload.ok(object);
    }


    public Response<?> getAllQuizByCategory(Long category_id,User user, Optional<Integer> page, Optional<Integer> pageSize, Optional<String> sortBy){
        Pageable pg = PageRequest.of(page.isPresent()&&page.get()!=0?page.get()-1:0, pageSize.orElse(10), Sort.Direction.DESC, sortBy.orElse("id"));
        Response<Object> notFound = checkUserAndOrganization(user);
        if (notFound != null) return notFound;
        String object = template.postForObject(serviceNames.getQuiz() + "/api/quiz/all/organization/" + user.getOrganization().getId()+"/"+category_id,pg, String.class);
        System.out.println(object);
        return Payload.ok(object);
    }


    public Response<?> getAllQuizByBlock(Long block_id,User user, Optional<Integer> page, Optional<Integer> pageSize, Optional<String> sortBy){
        Pageable pg = PageRequest.of(page.isPresent()&&page.get()!=0?page.get()-1:0, pageSize.orElse(10), Sort.Direction.DESC, sortBy.orElse("id"));
        Response<Object> notFound = checkUserAndOrganization(user);
        if (notFound != null) return notFound;
        String object = template.postForObject(serviceNames.getQuiz() + "/api/quiz/all/block/"+block_id ,pg, String.class);
        System.out.println(object);
        return Payload.ok(object);
    }






    private Response<Object> checkUserAndOrganization(User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isEmpty()) return Payload.notFound("User not found!");
        user =optionalUser.get();
        Optional<Organization> organization = organizationRepository.findByOwnerId(user.getId());
        if (organization.isEmpty()) return Payload.notFound("Organization not found!");
        return null;
    }


}
