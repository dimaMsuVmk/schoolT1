package com.dimamsu.schoolt1;

import com.dimamsu.schoolt1.testClasses.MyClass;
import com.dimamsu.schoolt1.testClasses.MyClass2;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class SchoolT1Application {
    private final MyClass myClass;
    private final MyClass2 myClass2;

    public static void main(String[] args) {
        SpringApplication.run(SchoolT1Application.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void onReady() throws Exception {

        System.out.println(myClass.foo2().getClass());
        myClass.foo();
        myClass.foo2();
        myClass.foo();
        myClass.foo2();

        myClass2.foo();
        myClass2.foo2();
        myClass2.foo();
        myClass2.foo2();


    }


}
