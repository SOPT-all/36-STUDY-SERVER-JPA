package hellojpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AL")
public class Album extends Item {
    private String artist;
}
