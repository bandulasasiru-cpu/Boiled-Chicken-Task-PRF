import java.util.*;
class Example{
	public static void main(String args[]){
	   Scanner input = new Scanner(System.in);
	   System.out.println("+-------------------------------------------------------------+");
	   System.out.println("|             Boiled Chicken Packet Factory System            |");
	   System.out.println("+-------------------------------------------------------------+");
	   System.out.println();
	   System.out.println();
	   System.out.print("Enter today's Manufacturing Price (Rs.per kg): ");
	   String price = input.next();
	   System.out.print("Enter today's Selling Price (Rs.per kg): ");
	   String Today = input.next();
	   System.out.println();
	   System.out.println();
	   System.out.println("Starting Box 1....");
	   System.out.println();
	   System.out.println("+-------------------------------------------------------------+");
       System.out.println("|                         Box 1                               |");
       System.out.println("+-------------------------------------------------------------+");
	   System.out.println();
	   System.out.println();
	   int packetCount = 0;
       double totalWeight = 0;
       double maxWeight = 0;
       double minWeight = 0;

      while (true) {

      System.out.print("Enter packet weight (kg) [0 = box full, -1 = end day] : ");
      String value = input.next();

     double weight;

     try {
        weight = Double.parseDouble(value);
    }
    catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a numeric value.");
        continue;
    }
    // End day
    if (weight == -1) {
        System.out.println("Day End.");
        break;
    }
    // Box full
    if (weight == 0) {
        System.out.println("Box Full.");
        break;
    }
    // Invalid weight
    if (weight < 0 || weight > 5) {
        System.out.println("Invalid input!");
        continue;
    }
    // Store valid packet
    packetCount++;
    totalWeight += weight;

    if (packetCount == 1) {
        maxWeight = weight;
        minWeight = weight;
    } else {
        if (weight > maxWeight)
            maxWeight = weight;

        if (weight < minWeight)
            minWeight = weight;
    }
}
     // Box Report
     if (packetCount > 0) {
       double average = totalWeight / packetCount;
       System.out.println("\n----------- Box 1 Report -----------");
       System.out.println("Total Packets : " + packetCount);
       System.out.println("Total Weight  : " + totalWeight + " kg");
       System.out.println("Maximum Weight: " + maxWeight + " kg");
       System.out.println("Minimum Weight: " + minWeight + " kg");
       System.out.println("Average Weight: " + average + " kg");
}
	   System.out.println("-----------------------------------------------------");
	   System.out.println();
	   System.out.println();
	   int totalBoxes = 0;
       int totalPackets = 0;
       double dayTotalWeight = 0;
       double dayMaxWeight = 0;
       double dayMinWeight = 0;
       boolean firstPacket = true;
       boolean endDay = false;
	   System.out.println("Starting Box 2...");
       System.out.println("+-------------------------------------------------------------+");
       System.out.println("|                         Box 2                               |");
       System.out.println("+-------------------------------------------------------------+");

     while (true) {

    System.out.print("Enter the packet Weight (kg) [0 = box full, -1 = end day]: ");
    String value = input.next();

    double weight;

    try {
        weight = Double.parseDouble(value);
    } catch (NumberFormatException e) {
        System.out.println("Invalid input!");
        continue;
    }

    // End Day
    if (weight == -1) {
        endDay = true;
        break;
    }

    // Box Full
    if (weight == 0) {
        totalBoxes++;
        break;
    }

    // Invalid Weight
    if (weight < 0 || weight > 5) {
        System.out.println("Invalid input!");
        continue;
    }

    // Valid Packet
    totalPackets++;
    dayTotalWeight += weight;

    if (firstPacket) {
        dayMaxWeight = weight;
        dayMinWeight = weight;
        firstPacket = false;
    } else {
        if (weight > dayMaxWeight)
            dayMaxWeight = weight;

        if (weight < dayMinWeight)
            dayMinWeight = weight;
    }
}

     // Print summary only when -1 is entered
     if (endDay) {

     double averageWeight = 0;

     if (totalPackets > 0)
    averageWeight = dayTotalWeight / totalPackets;
    double manufacturingCost = dayTotalWeight * Double.parseDouble(price);
    double totalIncome = dayTotalWeight * Double.parseDouble(Today);
    double netProfit = totalIncome - manufacturingCost;

    System.out.println();
    System.out.println();
    System.out.println("=====================DAY END SUMMARY====================");
    System.out.printf("Total Boxes Packed    : %d%n", totalBoxes);
    System.out.printf("Total Packets Packed  : %d%n", totalPackets);
    System.out.printf("Total Weight (Day)    : %.2fkg%n", dayTotalWeight);
    System.out.printf("Maximum Weight (Day)  : %.2fkg%n", dayMaxWeight);
    System.out.printf("Minimum Weight (Day)  : %.2fkg%n", dayMinWeight);
    System.out.printf("Average Weight (Day)  : %.4fkg%n", averageWeight);
    System.out.printf("Manufacturing cost    : Rs.%.2f%n", manufacturingCost);
    System.out.printf("Total Income (Sales)  : Rs.%.2f%n", totalIncome);
    System.out.printf("Net Profit            : Rs.%.2f%n", netProfit);
    System.out.println("========================================================");
    System.out.println();
    System.out.println();
    System.out.println("Thank you. Program Ended");
   }
  }
}

