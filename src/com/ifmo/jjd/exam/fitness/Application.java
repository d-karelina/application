package com.ifmo.jjd.exam.fitness;

public class Application {
    public static void main(String[] args) {
        UserInfo user1 = new UserInfo("Виктория", "Андреева", 1988);
        SeasonTicket ticket1 = new SeasonTicket(SeasonTicket.Type.ПОЛНЫЙ, user1);

        UserInfo user2 = new UserInfo("Сергей", "Петров", 2000);
        SeasonTicket ticket2 = new SeasonTicket(SeasonTicket.Type.ДНЕВНОЙ, user2);

        FitnessClub fitnessClub = new FitnessClub();


        fitnessClub.visiting(fitnessClub.zones[0], ticket1);
    }
}

/*не сделано:

Абонемент не может быть зарегистрирован одновременно в нескольких зонах.
(реализовать проверку перед добавлением в зону)

Реализовать возможность выводить информацию в консоль каждый раз, когда клиент посещает фитнес клуб.
Информация для вывода:
Фамилия
Имя
Посещаемаю зона (бассейн/тренажерный зал/групповые занятия)
Дата и время посещени
* */
