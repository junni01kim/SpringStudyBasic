package com.kmj.springapplication;

import java.util.UUID;

public interface Voucher {
    UUID getVocherId();

    long discount(long beforeDiscount);
}
