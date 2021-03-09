package base;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "Subscriptions", schema = "skillbox", catalog = "")
public class SubscriptionsEntity {
    private Timestamp subscriptionDate;

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
}
