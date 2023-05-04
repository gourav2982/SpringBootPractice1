package com.gourav.demo1.collection;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("Student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private  String name;
    private String lastname;
    @NotBlank(message = "Enter the email")
    @Email(message = "Enter valid email")
    private String email;


}
