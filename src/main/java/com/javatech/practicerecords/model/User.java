package com.javatech.practicerecords.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public record User(@Id String id, String name, int age, Address address) {
}
record Address(String street, String city, String state, String zip) {}
