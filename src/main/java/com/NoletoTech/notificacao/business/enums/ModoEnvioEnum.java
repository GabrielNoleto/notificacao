package com.NoletoTech.notificacao.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ModoEnvioEnum {
    EMAIL,
    SMS,
    PUSH,
    WHATSAPP;
}
