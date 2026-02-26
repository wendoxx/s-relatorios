package org.soleri.srelatorios.dto.request;

import org.soleri.srelatorios.utils.enums.EmployeeRole;

import java.util.UUID;

public record EmployeeRequestDTO(UUID id, String name, EmployeeRole role) {
}