package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void normalProduct_decreaseQualityAndSellin() {
        Item[] items = new Item[] { new Item("Normal product", 10, 20) };
        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals("Normal product", app.items[0].name);
        assertEquals(19, app.items[0].sellIn); // 20 - 1 = 19
        assertEquals(9, app.items[0].quality); // 10 - 1 = 9
    }



}
