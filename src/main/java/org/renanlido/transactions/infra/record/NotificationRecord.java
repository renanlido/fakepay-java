package org.renanlido.transactions.infra.record;

import org.springframework.data.relational.core.mapping.Table;

@Table("notification")
public record NotificationRecord(boolean message) {
}
