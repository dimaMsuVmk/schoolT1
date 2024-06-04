package com.dimamsu.schoolt1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Table(name = "InfoTimeMethods")
@NoArgsConstructor
@Getter
@Setter
public class InfoTimeMethod {//измерения
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "execution_time")
    private Long executionTime;
    @Column(name = "date")
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "method_id")
    private Method method;

    public InfoTimeMethod(Long executionTime, Method method) {
        this.executionTime = executionTime;
        this.date = LocalDateTime.now();
        this.method = method;
    }

}