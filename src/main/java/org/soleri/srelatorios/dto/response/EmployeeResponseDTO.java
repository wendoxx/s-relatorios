package org.soleri.srelatorios.dto.response;

import java.util.UUID;

public record EmployeeResponseDTO(UUID id, String name, String role) {
}