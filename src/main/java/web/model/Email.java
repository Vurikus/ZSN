package web.model;

import java.time.LocalDate;

public class Email {

    public static final String SUBJECT = " зарегистрирован в ЦЗН";
    public static final String MESSAGE = "Вы зарегистрировались в качестве безработного в ЦЗН " + LocalDate.now()
            + ". \nПервая отметка назначена спустя две недели после регистрации: " + LocalDate.now().plusDays(14L);

}
