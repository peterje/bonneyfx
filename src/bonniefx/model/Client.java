package bonniefx.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        Sale sale = new Sale(dateFormat);
        Item item;
        item = new PreNeedItem();
        Recipient recipient = new Recipient();
        ArrayList<SalesPerson> salesPeople = new ArrayList<SalesPerson>();

        SalesPerson primaryServiceDirector = new SalesPerson();
        System.out.println("Primary Service Director: ");
        primaryServiceDirector.setName(input.nextLine());

        System.out.println("Split percentage?: ");
        primaryServiceDirector.setSplitPCT(Double.parseDouble(input.nextLine()));
        salesPeople.add(primaryServiceDirector);

        System.out.println("Add a service director?: ");
        boolean moreMembers = input.nextLine().equalsIgnoreCase("yes");
        while (moreMembers) {
            SalesPerson serviceDirector = new SalesPerson();
            System.out.println("Service director name?: ");
            serviceDirector.setName(input.nextLine());

            System.out.println("Split percentage?: ");
            serviceDirector.setSplitPCT(Double.parseDouble(input.nextLine()));

            salesPeople.add(serviceDirector);
            System.out.println("Add a service director?: ");
            moreMembers = input.nextLine().equalsIgnoreCase("yes");
        }

        System.out.println("bonniefx.model.Recipient name: ");
        recipient.setName(input.nextLine());

        System.out.println("bonniefx.model.Recipient DOB: ");
        recipient.setDateOfBirth(LocalDate.parse(input.nextLine(), dateFormat));

        System.out.println("bonniefx.model.Recipient deceased?: ");
        recipient.setDeceased(input.nextLine().equalsIgnoreCase("yes"));

        if (recipient.isDeceased()) {
            System.out.println("bonniefx.model.Recipient DOD?");
            recipient.setDateOfDeath(LocalDate.parse(input.nextLine(), dateFormat));
        }

        System.out.println("bonniefx.model.Item sold: 1. MERCHANDISE, 2. PROPERTY, 3. INTERMENT, 4. INSURANCE, 5. TRUST, 6. TRAVEL");
        int choice = Integer.parseInt(input.nextLine());

        Product productSold = Product.values()[choice - 1];

        if (recipient.isDeceased())
            item = new AtNeedItem();
        else {
            if (productSold == Product.INSURANCE || productSold == Product.TRUST || productSold == Product.TRAVEL) {
                item = new Forethought();
                System.out.println("Payment Plan (years): ");
                int payPlan = Integer.parseInt(input.nextLine());
                ((Forethought) item).setPayPlan(payPlan);

            } else {
                item = new PreNeedItem();
                System.out.println("Down payment: ");
                ((PreNeedItem) item).setDownPayment(Utils.toUSD(input.nextLine()));

                System.out.println("Payed in full? ");
                ((PreNeedItem) item).setPaidInFull(input.nextLine().equalsIgnoreCase("yes"));

                System.out.println("Lead code:  ");
                System.out.println("1. PERSONAL 2. COMPANY");
                int leadCodeIndex = Integer.parseInt(input.nextLine());
                ((PreNeedItem) item).setLeadCode(LeadCode.values()[leadCodeIndex - 1]);
//                input.nextLine();
            }

        }
        if (productSold == Product.PROPERTY) {
            System.out.println("Plot code: ");
            PlotCode plotCode = PlotCode.valueOf(input.nextLine());
        }

        if (productSold == Product.TRAVEL || productSold == Product.TRUST || productSold == Product.INSURANCE) {
            System.out.println("Face amount: ");
        } else {
            System.out.println("Board value: ");
        }
        item.setBoardValue(Utils.toUSD(input.nextLine()));

        item.setProduct(productSold);
        item.setRecipient(recipient);

        System.out.println("Commission rate: " + 100.0 * item.getCommissionRate() + "%");
        System.out.println("Total commission: " + item.getCommission());

    }
}
