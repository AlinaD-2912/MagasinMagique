package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }
// Pass VIP adds quality
    // +2 if product has 10 more days
    // +3 if it has 5 days or less
    // quality drops to 0 when concert finished
//   Compte's quality adds with time

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        // if not Compté and doesn't have pass VIP pass

            if (items[i].quality > 50) {
                throw new IllegalArgumentException("Quality cannot be greater than 50");
            }

            if (items[i].quality < 0) {
                throw new IllegalArgumentException("Cannot be negative");
            }


            if (!items[i].name.equals("Comté")
                    && !items[i].name.equals("Pass VIP Concert")
                    && !items[i].name.equals("Wine")) {
                // if quality > 0
                if (items[i].quality > 0) {
                    // if product is kryptonite
                    if (!items[i].name.equals("Kryptonite")) {
                        // quality -1
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else // if name Comte and hae vip
            {
                // if comte quality less than 50
                if (items[i].quality < 50 && items[i].quality > 0) {
                    // add quality
                    items[i].quality = items[i].quality + 1;
                    // if item has vip paas
                    if (items[i].name.equals("Pass VIP Concert")) {
                        // if it's selling less than 11
                        if (items[i].sellIn < 11) {
                            // if quality less than 50
                            if (items[i].quality < 50) {
                                //add quality
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }

                    // added for quality solution
                }
            }
            // for all items that are not kryptonite they lose their quality
            if (!items[i].name.equals("Kryptonite")) {
                items[i].sellIn = items[i].sellIn - 1;
            }



//          If product sellin less than 0
            if (items[i].sellIn < 0) {
                // if products is not compte
                if (!items[i].name.equals("Comté")) {
                    //if product doesn't have a vip pass
                    if (!items[i].name.equals("Pass VIP Concert")) {
//                        if item still has qaulity
                        if (items[i].quality > 0) {
                            //if item is not kryptonite
                            if (!items[i].name.equals("Kryptonite")) {
                                //decrease thir's quality
                                items[i].quality = items[i].quality - 1;
                            }
                        }
//                        if has vip pass
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
//                    if product is compte
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
