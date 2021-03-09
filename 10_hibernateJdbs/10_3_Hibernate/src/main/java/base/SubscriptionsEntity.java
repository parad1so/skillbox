package base;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "Subscriptions", schema = "skillbox", catalog = "")
public class SubscriptionsEntity {
    private Timestamp subscriptionDate;
    private StudentsEntity studentsByStudentId;
    private CoursesEntity coursesByCourseId;

    @Basic
    @Column(name = "subscription_date")
    public Timestamp getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Timestamp subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriptionsEntity that = (SubscriptionsEntity) o;

        if (subscriptionDate != null ? !subscriptionDate.equals(that.subscriptionDate) : that.subscriptionDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return subscriptionDate != null ? subscriptionDate.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public StudentsEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    public CoursesEntity getCoursesByCourseId() {
        return coursesByCourseId;
    }

    public void setCoursesByCourseId(CoursesEntity coursesByCourseId) {
        this.coursesByCourseId = coursesByCourseId;
    }
}
