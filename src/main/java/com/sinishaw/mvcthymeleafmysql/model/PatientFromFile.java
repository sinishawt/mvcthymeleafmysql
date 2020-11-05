package com.sinishaw.mvcthymeleafmysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PatientFromFile {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private Integer zipCode;
    private Double billAmount;
    private Integer accountNo;
    @DateTimeFormat(pattern="mm-dd-yyyy")
    private Date dos;
   // private MultipartFile spreadSheet;

}
