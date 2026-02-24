package org.soleri.srelatorios.dto.response;

import java.util.UUID;

public record ProjectWorkResponseDTO(UUID id, String name, String code, String client, String description) {
}