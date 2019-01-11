package com.lyl.springintegrationjdbc;

import com.lyl.springintegrationjdbc.model.Gender;
import com.lyl.springintegrationjdbc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ImportResource("spring-integration-context.xml")
public class SpringIntegrationJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationJdbcApplication.class, args);
    }
//        final AbstractApplicationContext context =
//                new ClassPathXmlApplicationContext("classpath:spring-integration-context.xml");
//
//        context.registerShutdownHook();
//        final PersonService personService = context.getBean(PersonService.class);
//        final Scanner scanner = new Scanner(System.in);
//        while (true) {
//            final String input = scanner.nextLine();
//            if("1".equals(input.trim())) {
//                getPersonDetails(scanner, personService);
//            } else if("2".equals(input.trim())) {
//                createPersonDetails(scanner,personService);
//            } else if("q".equals(input.trim())) {
//                break;
//            } else {
//                System.out.println("Invalid choice\n\n");
//            }
//            System.out.println("Please enter a choice and press <enter>: ");
//            System.out.println("\t1. Find person details");
//            System.out.println("\t2. Create a new person detail");
//            System.out.println("\tq. Quit the application");
//            System.out.print("Enter you choice: ");
//        }
//    }
//
//    private static void createPersonDetails(final Scanner scanner, PersonService service) {
//        while(true) {
//            System.out.print("\nEnter the Person's name:");
//            String name = scanner.nextLine();
//            Gender gender;
//            while(true) {
//                System.out.print("Enter the Person's gender(M/F):");
//                String genderStr = scanner.nextLine();
//                if("m".equalsIgnoreCase(genderStr) || "f".equalsIgnoreCase(genderStr)) {
//                    gender = Gender.getGenderByIdentifier(genderStr.toUpperCase());
//                    break;
//                }
//            }
//            Date dateOfBirth;
//            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//            while(true) {
//                System.out.print("Enter the Person's Date of birth in DD/MM/YYYY format:");
//                String dobStr = scanner.nextLine();
//                try {
//                    dateOfBirth = format.parse(dobStr);
//                    break;
//                } catch (ParseException e) {
//                    //Silently suppress and ask to enter details again
//                }
//            }
//
//            Person person = new Person();
//            person.setDateOfBirth(dateOfBirth);
//            person.setGender(gender);
//            person.setName(name);
//            person = service.createPerson(person);
//            System.out.println("Created person record with id: " + person.getPersonId());
//            System.out.print("Do you want to create another person? (y/n)");
//            String choice  = scanner.nextLine();
//            if(!"y".equalsIgnoreCase(choice)) {
//                break;
//            }
//        }
//    }
//    /**
//     * @param service
//     */
//    private static void getPersonDetails(final Scanner scanner,final PersonService service) {
//        while(true) {
//            System.out.print("Please enter the name of the person and press<enter>: ");
//            String input = scanner.nextLine();
//            final List<Person> personList = service.findPersonByName(input);
//            if(personList != null && !personList.isEmpty()) {
//                for(Person person:personList) {
//                    System.out.print(
//                            String.format("Person found - Person Id: '%d', Person Name is: '%s',  Gender: '%s'",
//                                    person.getPersonId(),person.getName(), person.getGender()));
//                    System.out.println(String.format(", Date of birth: '%1$td/%1$tm/%1$tC%1$ty'", person.getDateOfBirth()));
//                }
//            } else {
//                System.out.println(
//                        String.format("No Person record found for name: '%s'.", input));
//            }
//            System.out.print("Do you want to find another person? (y/n)");
//            String choice  = scanner.nextLine();
//            if(!"y".equalsIgnoreCase(choice)) {
//                break;
//            }
//        }
//
//    }

}

