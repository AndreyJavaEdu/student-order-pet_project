package edu.pet_project.studentorder.domain.register;

import edu.pet_project.studentorder.domain.Person;
import edu.pet_project.studentorder.util.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class CityRegisterRequest {

    private String surname;
    private String givenName;
    private String patronomic;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate dateOfBirth;
    private Long streetCode;
    private String building;
    private String extension;
    private String apartment;

    public CityRegisterRequest() {
    }
    public CityRegisterRequest(Person person) {
        surname=person.getSurname();
        givenName=person.getGivenName();
        patronomic=person.getPatronomyc();
        dateOfBirth=person.getDateOfBirthday();
        streetCode=person.getAddress().getStreet().getStreetCode();
        building=person.getAddress().getBuilding();
        extension=person.getAddress().getExtension();
        apartment=person.getAddress().getApartment();

    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronomic() {
        return patronomic;
    }

    public void setPatronomic(String patronomic) {
        this.patronomic = patronomic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate DateOfBirth) {
        this.dateOfBirth = DateOfBirth;
    }

    public Long getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Long streetCode) {
        this.streetCode = streetCode;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "CityRegisterRequest{" +
                "surname='" + surname + '\'' +
                ", givenName='" + givenName + '\'' +
                ", patronomic='" + patronomic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", streetCode=" + streetCode +
                ", building='" + building + '\'' +
                ", extension='" + extension + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
