package JoinedEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue("B")
public class Movie extends Item{
    private String director;
    private String actor;
}
