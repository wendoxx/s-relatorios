package org.soleri.srelatorios.dto.request;

import java.util.UUID;

public record ProjectWorkRequestDTO(UUID id, String name, String code, String client, String description) {
}