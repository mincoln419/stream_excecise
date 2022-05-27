package me.whiteship.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void basePrice() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);

        Booking booking = new Booking(lionKing, weekday);
        assertEquals(120, booking.basePrice());

        Booking premium = new PremiumBooking(lionKing, weekday, new PremiumExtra(List.of(), 50));
        assertEquals(170, premium.basePrice());
    }

    @Test
    void basePrice_on_peakDay() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

        Booking booking = new Booking(lionKing, weekend);
        assertEquals(138, booking.basePrice());

        Booking premium = new PremiumBooking(lionKing, weekend, new PremiumExtra(List.of(), 50));
        assertEquals(188, premium.basePrice());
    }

    @Test
    void talkback() {
        Show noTalkbackShow = new Show(List.of(), 120);
        Show talkbackShow = new Show(List.of("talkback"), 120);
        LocalDateTime nonPeekday = LocalDateTime.of(2022, 1, 20, 19, 0);
        LocalDateTime peekday = LocalDateTime.of(2022, 1, 15, 19, 0);

        assertFalse(Booking.createBook(noTalkbackShow, nonPeekday).hasTalkback());
        assertTrue(Booking.createBook(talkbackShow, nonPeekday).hasTalkback());
        assertFalse(Booking.createBook(talkbackShow, peekday).hasTalkback());

        PremiumExtra premiumExtra = new PremiumExtra(List.of(), 50);
        assertTrue(Booking.createPremiumBook(talkbackShow, peekday, premiumExtra).hasTalkback());
        assertFalse(Booking.createPremiumBook(noTalkbackShow, peekday, premiumExtra).hasTalkback());
    }

    @Test
    void hasDinner() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
        LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);
        PremiumExtra premiumExtra = new PremiumExtra(List.of("dinner"), 50);

        assertTrue(new PremiumBooking(lionKing, weekday, premiumExtra).hasDinner());
        assertFalse(new PremiumBooking(lionKing, weekend, premiumExtra).hasDinner());
    }

}