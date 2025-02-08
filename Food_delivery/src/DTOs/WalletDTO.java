package DTOs;

public class WalletDTO {
    private int walletId;
    private int walletAmount;
    private int walletLimit;

    public WalletDTO() {}

    public WalletDTO(int walletId, int walletAmount, int walletLimit) {
        this.walletId = walletId;
        this.walletAmount = walletAmount;
        this.walletLimit = walletLimit;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(int walletAmount) {
        this.walletAmount = walletAmount;
    }

    public int getWalletLimit() {
        return walletLimit;
    }

    public void setWalletLimit(int walletLimit) {
        this.walletLimit = walletLimit;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId=" + walletId +
                ", walletAmount=" + walletAmount +
                ", walletLimit=" + walletLimit +
                '}';
    }
}

