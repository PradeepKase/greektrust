package greektrust;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MetroTrain {
    private final String originStation;
    private final String destinationStation;
    private final Map<String, Integer> passengersCount;
    private int totalCollection;
    private int totalDiscount;

    private static final int ADULT_COST = 200;
    private static final int SENIOR_CITIZEN_COST = 100;
    private static final int KID_COST = 50;
    private static final int RETURN_DISCOUNT_PERCENTAGE = 50;
    private static final double SERVICE_FEE_PERCENTAGE = 2;

    public MetroTrain(String originStation, String destinationStation) {
        this.originStation = originStation;
        this.destinationStation = destinationStation;
        this.passengersCount = new HashMap<>();
        this.totalCollection = 0;
        this.totalDiscount = 0;
    }

    public void travel(List<MetroCard> metroCards) {
        for (MetroCard card : metroCards) {
            int fare = calculateFare(card.getPassengerType());
            if (card.getBalance() < fare) {
                int rechargeAmount = fare - card.getBalance();
                double serviceFee = calculateServiceFee(rechargeAmount);
                card.recharge(rechargeAmount + (int) serviceFee);
                totalCollection += rechargeAmount + (int) serviceFee;
            }
            card.deduct(fare);
            totalCollection += fare;
            passengersCount.put(card.getPassengerType(), passengersCount.getOrDefault(card.getPassengerType(), 0) + 1);
        }
        if (destinationStation.equals(originStation)) {
            totalDiscount += totalCollection;
        } else {
            totalDiscount += (int) (totalCollection * (RETURN_DISCOUNT_PERCENTAGE / 100.0));
        }
    }

    private int calculateFare(String passengerType) {
        switch (passengerType) {
            case "ADULT":
                return ADULT_COST;
            case "SENIOR_CITIZEN":
                return SENIOR_CITIZEN_COST;
            case "KID":
                return KID_COST;
            default:
                throw new IllegalArgumentException("Invalid passenger type: " + passengerType);
        }
    }

    private double calculateServiceFee(int rechargeAmount) {
        return rechargeAmount * (SERVICE_FEE_PERCENTAGE / 100.0);
    }

    public void printCollectionSummary() {
        System.out.println("Collection Summary:");
        System.out.println("Total collection: " + totalCollection);
        System.out.println("Total discount: " + totalDiscount);
    }

    public void printPassengerSummary() {
        System.out.println("Passenger Summary:");
        List<Map.Entry<String, Integer>> sortedPassengerCount = new ArrayList<>(passengersCount.entrySet());
        Collections.sort(sortedPassengerCount, (a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });
        for (Map.Entry<String, Integer> entry : sortedPassengerCount) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter origin station: ");
	    String originStation = scanner.nextLine();

	    System.out.print("Enter destination station: ");
	    String destinationStation = scanner.nextLine();

	    System.out.print("Enter number of passengers: ");
	    int numPassengers = scanner.nextInt();

	    List<MetroCard> metroCards = new ArrayList<>();

	    for (int i = 1; i <= numPassengers; i++) {
	        System.out.printf("Enter passenger %d type (ADULT, SENIOR_CITIZEN, KID): ", i);
	        String passengerType = scanner.next();

	        System.out.print("Enter balance in MetroCard: ");
	        int balance = scanner.nextInt();

	        MetroCard metroCard = new MetroCard(passengerType, balance);
	        metroCards.add(metroCard);
	    }

	    MetroTrain metroTrain = new MetroTrain(originStation, destinationStation);
	    metroTrain.travel(metroCards);
	    metroTrain.printCollectionSummary();
	    metroTrain.printPassengerSummary();
	}

}
