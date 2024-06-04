package com.dimamsu.schoolt1.testClasses;

import com.dimamsu.schoolt1.aop.TrackAsyncTime;
import com.dimamsu.schoolt1.aop.TrackTime;
import org.springframework.stereotype.Component;

@Component
public class MyClass2 {
    @TrackTime
    public void foo() throws Exception {
        Thread.sleep(2000);
        System.out.println("_______________foo_____from MyClass2_____________");
    }

    @TrackAsyncTime
    public void foo2() throws Exception {
        Thread.sleep(2000);
        System.out.println("_______________foo2_____from MyClass2_____________");
    }
}
