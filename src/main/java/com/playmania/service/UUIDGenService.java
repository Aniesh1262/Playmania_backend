package com.playmania.service;


import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class UUIDGenService {
    private AtomicLong idGenerator = new AtomicLong(System.currentTimeMillis());

    public long generateUniqueId() {
        return idGenerator.incrementAndGet();
    }
}
