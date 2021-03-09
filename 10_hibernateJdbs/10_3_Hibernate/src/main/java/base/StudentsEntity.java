package base;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Students", schema = "skillbox")
public class StudentsEntity {
    private int id;
    private String name;
    private int age;
    private Timestamp registrationDate;
    private Collection<SubscriptionsEntity> subscriptionsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "registration_date")
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }


    public void setSubscriptionsById(Collection<SubscriptionsEntity> subscriptionsById) {
        this.subscriptionsById = subscriptionsById;
    }
}
