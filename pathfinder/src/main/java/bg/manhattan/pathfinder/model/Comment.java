package bg.manhattan.pathfinder.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="comments", uniqueConstraints = @UniqueConstraint(columnNames = {"author_id", "route_id"}))
public class Comment extends BaseEntity {

    @Column(nullable = false)
    private boolean approved;

    /**
     * The values should not be future dates
     */
    @Column( nullable = false)
    private LocalDateTime created;

    @Column(name="text_content", nullable = false, columnDefinition = "TEXT")
    private String text;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false)
    private Route route;

    public boolean isApproved() {
        return approved;
    }

    public Comment setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Comment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getText() {
        return text;
    }

    public Comment setText(String text) {
        this.text = text;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }
}
