package com.bachelors.nni.database.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @Column(name = "C_ID", nullable = false, updatable = false, unique = true)
    private String assignedKafkaTopic;

    @Column(name = "C_NAME", nullable = false, updatable = false)
    private String name;

    @Column(name = "C_QUERY", nullable = false, updatable = false)
    private String query;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "CLIENT_SOURCE",
            joinColumns = { @JoinColumn(name = "CLIENT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "SOURCE_ID") }
    )
    @JsonManagedReference
    private Set<Source> sources = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "CLIENT_RSS",
            joinColumns = { @JoinColumn(name = "CLIENT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "RSS_ID") }
    )
    @JsonManagedReference
    private Set<RssFeed> rssFeeds = new HashSet<>();
}
