package com.edmointel.bonneyfx.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ForethoughtTest {
    private Forethought insurance70Plan1;
    private Forethought insurance70Plan2;
    private Forethought insurance70Plan3;
    private Forethought insurance70Plan5;
    private Forethought insurance70Plan8;
    private Forethought insurance70Plan10;

    private Forethought insurance80Plan1;
    private Forethought insurance80Plan2;
    private Forethought insurance80Plan3;
    private Forethought insurance80Plan5;
    private Forethought insurance80Plan8;
    private Forethought insurance80Plan10;

    private Forethought insurance90Plan1;
    private Forethought insurance90Plan2;
    private Forethought insurance90Plan3;
    private Forethought insurance90Plan5;
    private Forethought insurance90Plan8;
    private Forethought insurance90Plan10;

    private Forethought insurance99Plan1;
    private Forethought insurance99Plan2;
    private Forethought insurance99Plan3;
    private Forethought insurance99Plan5;
    private Forethought insurance99Plan8;
    private Forethought insurance99Plan10;

    private Forethought travel;
    private Forethought trust;


    @Before
    public void setUp() {
        final Recipient age70 = Mockito.mock(Recipient.class);
        Mockito.when(age70.getAge()).thenReturn(70);

        final Recipient age80 = Mockito.mock(Recipient.class);
        Mockito.when(age80.getAge()).thenReturn(80);

        final Recipient age90 = Mockito.mock(Recipient.class);
        Mockito.when(age90.getAge()).thenReturn(90);

        final Recipient age99 = Mockito.mock(Recipient.class);
        Mockito.when(age99.getAge()).thenReturn(99);

        final Sale sale70 = Mockito.mock(Sale.class);
        Mockito.when(sale70.getRecipient()).thenReturn(age70);

        final Sale sale80 = Mockito.mock(Sale.class);
        Mockito.when(sale80.getRecipient()).thenReturn(age80);

        final Sale sale90 = Mockito.mock(Sale.class);
        Mockito.when(sale90.getRecipient()).thenReturn(age90);

        final Sale sale99 = Mockito.mock(Sale.class);
        Mockito.when(sale99.getRecipient()).thenReturn(age99);

        insurance70Plan1 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale70, 1);
        insurance70Plan2 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale70, 2);
        insurance70Plan3 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale70, 3);
        insurance70Plan5 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale70, 5);
        insurance70Plan8 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale70, 8);
        insurance70Plan10 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale70, 10);
        insurance80Plan1 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale80, 1);
        insurance80Plan2 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale80, 2);
        insurance80Plan3 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale80, 3);
        insurance80Plan5 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale80, 5);
        insurance80Plan8 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale80, 8);
        insurance80Plan10 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale80, 10);
        insurance90Plan1 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale90, 1);
        insurance90Plan2 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale90, 2);
        insurance90Plan3 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale90, 3);
        insurance90Plan5 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale90, 5);
        insurance90Plan8 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale90, 8);
        insurance90Plan10 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale90, 10);
        insurance99Plan1 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale99, 1);
        insurance99Plan2 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale99, 2);
        insurance99Plan3 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale99, 3);
        insurance99Plan5 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale99, 5);
        insurance99Plan8 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale99, 8);
        insurance99Plan10 = new Forethought(Product.INSURANCE, Utils.toUSD("1234.56"), sale99, 10);
        travel = new Forethought(Product.TRAVEL, Utils.toUSD("1234.56"), sale70, 1);
        trust = new Forethought(Product.TRUST, Utils.toUSD("1234.56"), sale70, 1);

    }

    @Test
    public void getCommissionRate1() {
        assertEquals(0.07, insurance70Plan1.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate2() {
        assertEquals(0.055, insurance70Plan2.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate3() {
        assertEquals(0.055, insurance70Plan3.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate4() {
        assertEquals(0.055, insurance70Plan5.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate5() {
        assertEquals(0.04, insurance70Plan8.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate6() {
        assertEquals(0.04, insurance70Plan10.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate7() {
        assertEquals(0.065, insurance80Plan1.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate8() {
        assertEquals(0.05, insurance80Plan2.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate9() {
        assertEquals(0.05, insurance80Plan3.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate10() {
        assertEquals(0.05, insurance80Plan5.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate11() {
        assertEquals(0.04, insurance80Plan8.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate12() {
        assertEquals(0.04, insurance80Plan10.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate13() {
        assertEquals(0.06, insurance90Plan1.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate14() {
        assertEquals(0.04, insurance90Plan2.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate15() {
        assertEquals(0.04, insurance90Plan3.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate16() {
        assertEquals(0.04, insurance90Plan5.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate17() {
        assertEquals(0.00, insurance90Plan8.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate18() {
        assertEquals(0.00, insurance90Plan10.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate19() {
        assertEquals(0.04, insurance99Plan1.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate20() {
        assertEquals(0.03, insurance99Plan2.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate21() {
        assertEquals(0.03, insurance99Plan3.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate22() {
        assertEquals(0.03, insurance99Plan5.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate23() {
        assertEquals(0.00, insurance99Plan8.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate24() {
        assertEquals(0.00, insurance99Plan10.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate25() {
        assertEquals(0.00, travel.getCommissionRate(), 0.00);
    }
    @Test
    public void getCommissionRate26() {
        assertEquals(0.03, trust.getCommissionRate(), 0.00);
    }

    @Test
    public void getFlatCommission1() {
        assertEquals(Utils.toUSD("0.00"), insurance70Plan1.getFlatCommission());
    }

    @Test
    public void getFlatCommission2() {
        assertEquals(Utils.toUSD("0.00"), insurance70Plan2.getFlatCommission());
    }

    @Test
    public void getFlatCommission3() {
        assertEquals(Utils.toUSD("0.00"), insurance70Plan3.getFlatCommission());
    }

    @Test
    public void getFlatCommission4() {
        assertEquals(Utils.toUSD("0.00"), insurance70Plan5.getFlatCommission());
    }

    @Test
    public void getFlatCommission5() {
        assertEquals(Utils.toUSD("0.00"), insurance70Plan8.getFlatCommission());
    }

    @Test
    public void getFlatCommission6() {
        assertEquals(Utils.toUSD("0.00"), insurance70Plan10.getFlatCommission());
    }

    @Test
    public void getFlatCommission7() {
        assertEquals(Utils.toUSD("0.00"), insurance80Plan1.getFlatCommission());
    }

    @Test
    public void getFlatCommission8() {
        assertEquals(Utils.toUSD("0.00"), insurance80Plan2.getFlatCommission());
    }

    @Test
    public void getFlatCommission9() {
        assertEquals(Utils.toUSD("0.00"), insurance80Plan3.getFlatCommission());
    }

    @Test
    public void getFlatCommission10() {
        assertEquals(Utils.toUSD("0.00"), insurance80Plan5.getFlatCommission());
    }

    @Test
    public void getFlatCommission11() {
        assertEquals(Utils.toUSD("0.00"), insurance80Plan8.getFlatCommission());
    }

    @Test
    public void getFlatCommission12() {
        assertEquals(Utils.toUSD("0.00"), insurance80Plan10.getFlatCommission());
    }

    @Test
    public void getFlatCommission13() {
        assertEquals(Utils.toUSD("0.00"), insurance90Plan1.getFlatCommission());
    }

    @Test
    public void getFlatCommission14() {
        assertEquals(Utils.toUSD("0.00"), insurance90Plan2.getFlatCommission());
    }

    @Test
    public void getFlatCommission15() {
        assertEquals(Utils.toUSD("0.00"), insurance90Plan3.getFlatCommission());
    }

    @Test
    public void getFlatCommission16() {
        assertEquals(Utils.toUSD("0.00"), insurance90Plan5.getFlatCommission());
    }
    @Test
    public void getFlatCommission17() {
        assertEquals(Utils.toUSD("0.00"), insurance90Plan8.getFlatCommission());
    }

    @Test
    public void getFlatCommission18() {
        assertEquals(Utils.toUSD("0.00"), insurance90Plan10.getFlatCommission());
    }

    @Test
    public void getFlatCommission19() {
        assertEquals(Utils.toUSD("0.00"), insurance99Plan1.getFlatCommission());
    }

    @Test
    public void getFlatCommission20() {
        assertEquals(Utils.toUSD("0.00"), insurance99Plan2.getFlatCommission());
    }

    @Test
    public void getFlatCommission21() {
        assertEquals(Utils.toUSD("0.00"), insurance99Plan3.getFlatCommission());
    }

    @Test
    public void getFlatCommission22() {
        assertEquals(Utils.toUSD("0.00"), insurance99Plan5.getFlatCommission());
    }

    @Test
    public void getFlatCommission23() {
        assertEquals(Utils.toUSD("0.00"), insurance99Plan8.getFlatCommission());
    }

    @Test
    public void getFlatCommission24() {
        assertEquals(Utils.toUSD("0.00"), insurance99Plan10.getFlatCommission());
    }

    @Test
    public void getFlatCommission25() {
        assertEquals(Utils.toUSD("85.00"), travel.getFlatCommission());
    }

    @Test
    public void getFlatCommission26() {
        assertEquals(Utils.toUSD("0.00"), trust.getFlatCommission());
    }


    @Test
    public void getCommission1() {
        assertEquals(Utils.toUSD("86.42"), insurance70Plan1.getCommission());
    }

    @Test
    public void getCommission2() {
        assertEquals(Utils.toUSD("67.90"), insurance70Plan2.getCommission());
    }

    @Test
    public void getCommission3() {
        assertEquals(Utils.toUSD("67.90"), insurance70Plan3.getCommission());
    }

    @Test
    public void getCommission4() {
        assertEquals(Utils.toUSD("67.90"), insurance70Plan5.getCommission());
    }

    @Test
    public void getCommission5() {
        assertEquals(Utils.toUSD("49.38"), insurance70Plan8.getCommission());
    }

    @Test
    public void getCommission6() {
        assertEquals(Utils.toUSD("49.38"), insurance70Plan10.getCommission());
    }

    @Test
    public void getCommission7() {
        assertEquals(Utils.toUSD("80.25"), insurance80Plan1.getCommission());
    }

    @Test
    public void getCommission8() {
        assertEquals(Utils.toUSD("61.73"), insurance80Plan2.getCommission());
    }

    @Test
    public void getCommission9() {
        assertEquals(Utils.toUSD("61.73"), insurance80Plan3.getCommission());
    }

    @Test
    public void getCommission10() {
        assertEquals(Utils.toUSD("61.73"), insurance80Plan5.getCommission());
    }

    @Test
    public void getCommission11() {
        assertEquals(Utils.toUSD("49.38"), insurance80Plan8.getCommission());
    }

    @Test
    public void getCommission12() {
        assertEquals(Utils.toUSD("49.38"), insurance80Plan10.getCommission());
    }

    @Test
    public void getCommission13() {
        assertEquals(Utils.toUSD("74.07"), insurance90Plan1.getCommission());
    }

    @Test
    public void getCommission14() {
        assertEquals(Utils.toUSD("49.38"), insurance90Plan2.getCommission());
    }

    @Test
    public void getCommission15() {
        assertEquals(Utils.toUSD("49.38"), insurance90Plan3.getCommission());
    }

    @Test
    public void getCommission16() {
        assertEquals(Utils.toUSD("49.38"), insurance90Plan5.getCommission());
    }

    @Test
    public void getCommission17() {
        assertEquals(Utils.toUSD("0.00"), insurance90Plan8.getCommission()); // ask about rate
    }

    @Test
    public void getCommission18() {
        assertEquals(Utils.toUSD("0.00"), insurance90Plan10.getCommission()); // ask about rate
    }

    @Test
    public void getCommission19() {
        assertEquals(Utils.toUSD("49.38"), insurance99Plan1.getCommission());
    }

    @Test
    public void getCommission20() {
        assertEquals(Utils.toUSD("37.04"), insurance99Plan2.getCommission()); // ask about rate
    }

    @Test
    public void getCommission21() {
        assertEquals(Utils.toUSD("37.04"), insurance99Plan3.getCommission());
    }

    @Test
    public void getCommission22() {
        assertEquals(Utils.toUSD("37.04"), insurance99Plan5.getCommission());
    }

    @Test
    public void getCommission23() {
        assertEquals(Utils.toUSD("0.00"), insurance99Plan8.getCommission());
    }

    @Test
    public void getCommission24() {
        assertEquals(Utils.toUSD("0.00"), insurance99Plan10.getCommission());
    }

    @Test
    public void getCommission25() {
        assertEquals(Utils.toUSD("85.00"), travel.getCommission());
    }

    @Test
    public void getCommission26() {
        assertEquals(Utils.toUSD("37.04"), trust.getCommission());
    }
}