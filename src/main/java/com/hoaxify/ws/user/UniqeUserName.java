package com.hoaxify.ws.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {UniqeUserNameValidator.class}
)
public @interface UniqeUserName {
    String message() default "{username.must.be.uniqe.message}";//zorunlu

    Class<?>[] groups() default {};//zorunlu

    Class<? extends Payload>[] payload() default {};//zorunlu
}
