class MovieTicket {
    private int movieId;
    private int noOfSeats;
    private double costPerTicket;

    public MovieTicket(int movieId, int noOfSeats) {
        this.movieId = movieId;
        this.noOfSeats = noOfSeats;
        setCostPerTicket(movieId);
    }

    public double calculateTotalAmount() {
        double totalAmount = costPerTicket * noOfSeats;
        totalAmount += 0.02 * totalAmount;
        return Math.round(totalAmount);
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
        setCostPerTicket(movieId);
    }

    public int getMovieId() {
        return movieId;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    private void setCostPerTicket(int movieId) {
        switch (movieId) {
            case 111:
                costPerTicket = 7.0;
                break;
            case 112:
                costPerTicket = 8.0;
                break;
            case 113:
                costPerTicket = 8.5;
                break;
            default:
                costPerTicket = 0.0;
        }
    }

    public double getCostPerTicket() {
        return costPerTicket;
    }

    public void setCostPerTicket(double costPerTicket) {
        this.costPerTicket = costPerTicket;
    }
}

class Tester {
    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket(112, 3);
        double amount = movieTicket.calculateTotalAmount();
        if (amount == 0)
            System.out.println("Sorry! Please enter valid movie Id and number of seats");
        else
            System.out.println("Total amount for booking : $" + amount);

        MovieTicket movieTicket1 = new MovieTicket(114, 3);
        double amount1 = movieTicket1.calculateTotalAmount();
        if (amount1 == 0)
            System.out.println("Sorry! Please enter valid movie Id and number of seats");
        else
            System.out.println("Total amount for booking : $" + amount1);
    }
}