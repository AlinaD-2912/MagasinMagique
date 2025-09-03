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
    // passed
    @Test
    void normalItem_expiredDate_decreasesTwiceAsFast() {
        Item[] items = new Item[] { new Item("Produit Expiré", 0, 20) };
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals(18, app.items[0].quality); // 20 - 1 (normal) - 1 (expiré) = 18
        assertEquals(-1, app.items[0].sellIn);  // 0 - 1 = -1
    }






}
