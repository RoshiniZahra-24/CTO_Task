import java.util.Scanner;

public class GSTMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Item : ");
        String item = sc.nextLine();

        System.out.print("Price : Rs. ");
        double price = sc.nextDouble();

        System.out.print("Qty : ");
        int quantity = sc.nextInt();

        System.out.print("GST Rate : ");
        int rate = sc.nextInt();

        switch (rate) {
            case 5:
            case 12:
            case 18:
            case 28:
                break;
            default:
                System.out.println("Invalid GST Rate");
                sc.close();
                return;
        }
        sc.nextLine();

        System.out.print("Seller : ");
        String seller = sc.nextLine();

        System.out.print("Buyer : ");
        String buyer = sc.nextLine();

        double subtotal = price * quantity;
        double grandTotal;

        System.out.println("\n--- INVOICE ---");
        System.out.printf("%-12s : %s x %d%n", "Item", item, quantity);
        System.out.printf("%-12s : Rs. %.2f%n", "Subtotal", subtotal);

        if (seller.equalsIgnoreCase(buyer)) {
            double cgst = subtotal * (rate / 2.0) / 100;
            double sgst = subtotal * (rate / 2.0) / 100;

            System.out.printf("%-12s : Rs. %.2f%n",
                    "CGST (" + (rate / 2) + "%)", cgst);

            System.out.printf("%-12s : Rs. %.2f%n",
                    "SGST (" + (rate / 2) + "%)", sgst);

            grandTotal = subtotal + cgst + sgst;
        } else {
            double igst = subtotal * rate / 100.0;

            System.out.printf("%-12s : Rs. %.2f%n",
                    "IGST (" + rate + "%)", igst);

            grandTotal = subtotal + igst;
        }
        System.out.printf("%-12s : Rs. %.2f%n", "Grand Total", grandTotal);
        sc.close();
    }
}