package com.ifmo.jjd.exam.fitness;

import java.time.LocalDate;

public class SeasonTicket {
    Type type;
    final LocalDate dateOfRegistration = LocalDate.now();
    LocalDate validThrow ;
    UserInfo userInfo ;

    public SeasonTicket(Type type, UserInfo userInfo) {
        this.userInfo = userInfo;
        this.type = type ;
        this.setValidThrow();
    }

    private void setValidThrow () {
        validThrow = dateOfRegistration.plusYears(1);
    }


    @Override
    public String toString() {
        return "SeasonTicket{" +
                "type=" + type +
                ", dateOfRegistration=" + dateOfRegistration +
                ", validThrow=" + validThrow +
                ", userInfo=" + userInfo +
                '}';
    }

    enum Type{
        РАЗОВЫЙ, ДНЕВНОЙ, ПОЛНЫЙ
    }
}
