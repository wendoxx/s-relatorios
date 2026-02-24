package org.soleri.srelatorios.repository;

import org.soleri.srelatorios.model.ProjectWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectWorkRepository extends JpaRepository<ProjectWork, UUID> {
}
