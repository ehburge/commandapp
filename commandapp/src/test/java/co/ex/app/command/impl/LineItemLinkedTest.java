package co.ex.app.command.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LineItemLinkedTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void recurse() {
        LineItemLinked lineItemLinked = new LineItemLinked();

        lineItemLinked.recurse(lineItemLinked.makeHeadLineItem());

        LineItem head = lineItemLinked.getHeadlineItem();

        assertNotNull(head.nextLineItem);

        head.toString();
    }
}