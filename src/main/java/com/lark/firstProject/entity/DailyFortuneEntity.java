package com.lark.firstProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity(name = "DAILY_FORTUNE")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DailyFortuneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String zodiac;
    private String fortuneText;
    private LocalDate date;

}
