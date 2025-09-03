package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MagasinTest {

//    @Test
//    void foo() {
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        Magasin app = new Magasin(items);
//        app.updateQuality();
//        assertEquals("fixme", app.items[0].name);
//    }

    @Test
    void normalProduct_decreaseQualityAndSellin() {
        Item[] items = new Item[] { new Item("Normal product", 10, 20) };
        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals("Normal product", app.items[0].name);
        assertEquals(9, app.items[0].sellIn); // 10 - 1 = 9
        assertEquals(19, app.items[0].quality); // 20 - 1 = 19
    }

    // passed
    // Once the expiration date has passed, the quality degrades twice as fast
    @Test
    void normalItem_expiredDate_decreasesTwiceAsFast() {
        Item[] items = new Item[] { new Item("Produit Expiré", 0, 20) };
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals(18, app.items[0].quality); // 20 - 1 (normal) - 1 (expiré) = 18
        assertEquals(-1, app.items[0].sellIn);  // 0 - 1 = -1
    }

    // The quality of a product can never be negative.
    @Test
    void qualityCanNotBeNegative() {
        Item[] items = new Item[] { new Item("Produit Expiré", 10, -5) };
        Magasin app = new Magasin(items);


        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> app.updateQuality(),
                "Negative quality should throw illegal exception but nothing was thrown"
        );
        assertEquals("Cannot be negative", exception.getMessage());

    }

    // passed
    //  The "Comté" product increases its quality over time.
    @Test
    void compteQuality() {
        Item[] items = new Item[] { new Item("Comté", 14, 20) };
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals(21, app.items[0].quality); // 20 + 1 = 21

    }

    //passed
    //  The quality of a product is never greater than 50.
    @Test
    void qualityIsNotGreaterThan50() {
        Item[] items = new Item[] { new Item("Product", 14, 55) };
        Magasin app = new Magasin(items);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> app.updateQuality(),
                "Quality is never greater than 50"
        );
        assertEquals("Quality cannot be greater than 50", exception.getMessage());
    }
    // passed
    //  "Kryptonite", being a legendary item, has no expiration date and never loses
    @Test
    void kryptoniteNotLoosingQuality() {
        Item[] items = new Item[] { new Item("Kryptonite", 14, 42) };
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals(42, app.items[0].quality);
    }

    //passed
    //  "Kryptonite", being a legendary item, has no expiration date and never loses
    @Test
    void vipPassIncreaseOfQuality() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 10, 24) };
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals(26, app.items[0].quality); // quality increases by 2 when there are 10 days or less remaining

        Item[] it = new Item[] { new Item("Pass VIP Concert", 5, 24) };
        Magasin a = new Magasin(it);

        a.updateQuality();

        assertEquals(27, a.items[0].quality); // by 3 when there are 5 days or less remaining

    }






}
