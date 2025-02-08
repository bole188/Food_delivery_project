package DTOs;

public class TokenDTO {
    private String tokenId;
    private boolean validity;
    private int walletId;

    public TokenDTO() {}
    
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }
    
    @Override
    public String toString() {
        return "Payment{" +
                "tokenId=" + tokenId +
                ", walletId='" + walletId + '\'' +
                ", validity='" + validity +              
                '}';
    }
}