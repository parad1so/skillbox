/*
Цель задания
Научиться создавать классы @Entity со связями для работы с базой данных.
Что нужно сделать
Создайте классы @Entity для всех таблиц базы данных и связи между ними для всей базы данных Skillbox.
Рекомендации
Изучите каждую таблицу и найдите связи между ними. Например, в таблице Subscriptions есть поле с идентификатором студента (student_id). В классе, связанном с Subscriptions, можно сделать связь @ManyToOne со студентом, а у студента будет @OneToMany. То есть у одного студента может быть много подписок, а у каждой подписки может быть только один студент. Аналогично посмотрите, где и какие связи можно прописать между классами.
Критерии оценки
«Зачёт» — написаны все классы для таблиц базы данных с указанием связей между таблицами. «Незачёт» — задание не выполнено.

 */

import base.CoursesEntity;
import base.StudentsEntity;
import base.SubscriptionsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        CoursesEntity course = session.get(CoursesEntity.class, 3);
        SubscriptionsEntity sub = session.get(SubscriptionsEntity.class, 3);
        StudentsEntity student = session.get(StudentsEntity.class, 3);
        System.out.println(sub.getSubscriptionDate());
        System.out.println(student.getName());
        System.out.println(course.getName() + " = " + course.getStudentsCount());

        sessionFactory.close();


    }
}
