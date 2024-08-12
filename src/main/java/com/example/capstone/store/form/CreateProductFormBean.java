package com.example.capstone.store.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateProductFormBean {

    private Integer productId;


    @Pattern(regexp="[a-zA-Z]+", message = "Product name must have characters only.")
    @Length(max = 50, message = "Product name must be less than 50 characters")
    @NotEmpty(message = "Product name is required.")
    private String productName;
    private Double productPrice;
    private String productImageUrl;
    private String productDescription;

}