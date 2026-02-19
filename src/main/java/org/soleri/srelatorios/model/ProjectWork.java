package org.soleri.srelatorios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class ProjectWork {

    @Id
    private UUID id;

    private String name;
    private String code;
    private String Client;
    private String description;
}
