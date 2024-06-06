package com.dimamsu.schoolt1.testClasses;

import com.dimamsu.schoolt1.aop.TrackAsyncTime;
import com.dimamsu.schoolt1.aop.TrackTime;
import org.springframework.stereotype.Component;

@Component
public class MyClass {
    @TrackTime
    public void foo() throws Exception {
        Thread.sleep(2000);
        System.out.println("_______________foo_____from MyClass_____________");
    }

    @TrackAsyncTime
    public Integer foo2() throws Exception {
        Thread.sleep(2000);
        System.out.println("_______________foo2_____from MyClass_____________");
        return 0;
    }
}
