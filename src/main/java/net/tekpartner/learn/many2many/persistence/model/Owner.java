package net.tekpartner.learn.many2many.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chandrashekar R. Gaajula
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "owner")
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_generator")
    @SequenceGenerator(name = "owner_generator", sequenceName = "owner_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", length = 50)
    @Size(max = 50, message = "Size of name needs be less than or equal to 50")
    private String name;

    @ManyToMany(mappedBy = "owners", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Book> books = new HashSet<>();
}