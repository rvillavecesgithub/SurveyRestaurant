package com.robinfood.survey;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.robinfood.survey.model.Answer;
import com.robinfood.survey.model.Customer;
import com.robinfood.survey.model.CustomerSurveyAnswered;
import com.robinfood.survey.model.CustomerSurveyAnsweredPK;
import com.robinfood.survey.model.Question;
import com.robinfood.survey.model.QuestionType;
import com.robinfood.survey.model.Survey;
import com.robinfood.survey.model.SurveyQuestion;
import com.robinfood.survey.model.SurveyQuestionAnswer;
import com.robinfood.survey.model.SurveyQuestionAnswerPK;
import com.robinfood.survey.model.SurveyQuestionPK;
import com.robinfood.survey.repository.AnswerRepository;
import com.robinfood.survey.repository.CustomerRepository;
import com.robinfood.survey.repository.CustomerSurveyAnsweredRepository;
import com.robinfood.survey.repository.QuestionRepository;
import com.robinfood.survey.repository.QuestionTypeRepository;
import com.robinfood.survey.repository.SurveyQuestionAnswerRepository;
import com.robinfood.survey.repository.SurveyQuestionRepository;
import com.robinfood.survey.repository.SurveyRepository;

@SpringBootApplication
public class SurveyRestaurantApplication {

	private static final Logger log = LoggerFactory.getLogger(SurveyRestaurantApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SurveyRestaurantApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(QuestionTypeRepository qtrepo, CustomerRepository cRepo,
			CustomerSurveyAnsweredRepository csarRepo, SurveyRepository surveyRepo, QuestionRepository questionRepo,
			SurveyQuestionRepository surverquestionRepo, AnswerRepository answerRepo,
			SurveyQuestionAnswerRepository sqarepo) {
		return (args) -> {

			QuestionType qt = new QuestionType();
			qt.setDescription("Unica Respuesta");
			qtrepo.save(qt);

			QuestionType qt2 = new QuestionType();
			qt2.setDescription("Multiple Respuesta");
			qtrepo.save(qt2);

			Survey s = new Survey();
			s.setName("Encuesta de satisfacción");
			surveyRepo.save(s);

			Question q = new Question();
			q.setDescription("¿Esta satisfecho con el servicio?");
			q.setQuestionType(qt);
			questionRepo.save(q);
			
			Question q1 = new Question();
			q1.setDescription("¿Que platos le gusto mas?");
			q1.setQuestionType(qt2);
			questionRepo.save(q1);

			SurveyQuestionPK qspk = new SurveyQuestionPK(q.getQuestionId(), s.getSurveyId());
			SurveyQuestion sq = new SurveyQuestion(qspk, s, q);
			surverquestionRepo.save(sq);
			
			SurveyQuestionPK qspk1 = new SurveyQuestionPK(q1.getQuestionId(), s.getSurveyId());
			SurveyQuestion sq1= new SurveyQuestion(qspk1, s, q1);
			surverquestionRepo.save(sq1);

			Answer a = new Answer("Si");
			Answer a1 = new Answer("No");
			Answer a2 = new Answer("Plato Fuerte");
			Answer a3 = new Answer("Postre");
			Answer a4 = new Answer("La entrada");
			answerRepo.save(a);
			answerRepo.save(a1);
			answerRepo.save(a2);
			answerRepo.save(a3);
			answerRepo.save(a4);

			SurveyQuestionAnswerPK sqapk = new SurveyQuestionAnswerPK(qspk, a.getAnswerId());
			SurveyQuestionAnswer sqa = new SurveyQuestionAnswer(sqapk, sq, a);

			SurveyQuestionAnswerPK sqapk1 = new SurveyQuestionAnswerPK(qspk, a1.getAnswerId());
			SurveyQuestionAnswer sqa1 = new SurveyQuestionAnswer(sqapk1, sq, a1);
			
			SurveyQuestionAnswerPK sqapk2 = new SurveyQuestionAnswerPK(qspk1, a2.getAnswerId());
			SurveyQuestionAnswer sqa2 = new SurveyQuestionAnswer(sqapk2, sq1, a2);
			
			SurveyQuestionAnswerPK sqapk3 = new SurveyQuestionAnswerPK(qspk1, a3.getAnswerId());
			SurveyQuestionAnswer sqa3 = new SurveyQuestionAnswer(sqapk3, sq1, a3);
			
			SurveyQuestionAnswerPK sqapk4 = new SurveyQuestionAnswerPK(qspk1, a4.getAnswerId());
			SurveyQuestionAnswer sqa4 = new SurveyQuestionAnswer(sqapk4, sq1, a4);
			List<SurveyQuestionAnswer> list = new ArrayList<SurveyQuestionAnswer>();
			list.add(sqa);
			list.add(sqa1);
			list.add(sqa2);
			list.add(sqa3);
			list.add(sqa4);
			sqarepo.saveAll(list);
			Customer c = new Customer("Ramiro", "Villaveces");
			cRepo.save(c);

			Customer c1 = new Customer("Carlos", "Gonzalez");
			cRepo.save(c1);

			CustomerSurveyAnsweredPK customerSurveyAnsweredPK = new CustomerSurveyAnsweredPK(sqapk, c.getCustomerId());
			CustomerSurveyAnswered csa = new CustomerSurveyAnswered(customerSurveyAnsweredPK,
					sqa.getSurveyQuestionAnswerPK(), c);
			csarRepo.save(csa);

//			CustomerSurveyAnsweredPK customerSurveyAnsweredPK1 = new CustomerSurveyAnsweredPK(sqapk1,
//					c.getCustomerId());
//			CustomerSurveyAnswered csa1 = new CustomerSurveyAnswered(customerSurveyAnsweredPK1,
//					sqa1.getSurveyQuestionAnswerPK(), c);
//			csarRepo.save(csa1);

		};
	}

}
