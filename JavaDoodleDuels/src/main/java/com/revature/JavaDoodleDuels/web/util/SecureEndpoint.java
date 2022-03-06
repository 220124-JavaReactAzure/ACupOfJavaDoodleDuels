package com.revature.JavaDoodleDuels.web.util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Target(ElemntType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecureEndpoint {
 String[] allowedUsers();
}
