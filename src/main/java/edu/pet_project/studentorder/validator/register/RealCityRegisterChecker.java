package edu.pet_project.studentorder.validator.register;

import edu.pet_project.studentorder.domain.register.CityRegisterRequest;
import edu.pet_project.studentorder.domain.register.CityRegisterResponse;
import edu.pet_project.studentorder.domain.Person;
import edu.pet_project.studentorder.exception.CityRegisterException;
import edu.pet_project.studentorder.exception.TransportException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

//В этом классе проверяем персону в методе
public class RealCityRegisterChecker implements CityRegisterChecker {
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {
        CityRegisterRequest request = new CityRegisterRequest(person);

        Client client = ClientBuilder.newClient();
        CityRegisterResponse response = client.target("http://localhost:8080/city-register-1.0/rest/check")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                .readEntity(CityRegisterResponse.class);
        return response;
    }
}
