package com.smu.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthControllerTest {

    @Test
    void sayHello() {
        HealthController healthController = new HealthController();
        assertEquals("Working Hot as Chili Sauce", healthController.sayHello().getBody());
    }
}
