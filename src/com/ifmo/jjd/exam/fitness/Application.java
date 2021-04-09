package com.ifmo.jjd.exam.fitness;

public class Application {
    public static void main(String[] args) {
        UserInfo user1 = new UserInfo("Виктория", "Андреева", 1988);
        SeasonTicket ticket1 = new SeasonTicket(SeasonTicket.Type.FULL, user1);

        UserInfo user2 = new UserInfo("Сергей", "Петров", 2000);
        SeasonTicket ticket2 = new SeasonTicket(SeasonTicket.Type.FULL, user2);

        UserInfo user3 = new UserInfo("Сергей", "Иванов", 2004);
        SeasonTicket ticket3 = new SeasonTicket(SeasonTicket.Type.FULL, user3);

        UserInfo user4 = new UserInfo("Марина", "Иванова", 1994);
        SeasonTicket ticket4 = new SeasonTicket(SeasonTicket.Type.FULL, user4);



        FitnessClub fitnessClub = new FitnessClub();


        fitnessClub.visiting(fitnessClub.zones[2], ticket1);
        fitnessClub.visiting(fitnessClub.zones[2], ticket2);
        fitnessClub.visiting(fitnessClub.zones[2], ticket3);
        fitnessClub.visiting(fitnessClub.zones[2], ticket4);

        fitnessClub.printCustomersInfo();
        fitnessClub.isClosing();

        fitnessClub.printCustomersInfo();

    }
}

