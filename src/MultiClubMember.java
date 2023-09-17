public class MultiClubMember extends Member {
    //Примиальные баллы
    private int membershipPoints;

    public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints) {
        super(pMemberType, pMemberID, pName, pFees);
        this.membershipPoints = pMembershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int pMembershipPoints) {
        this.membershipPoints = pMembershipPoints;
    }

    @Override
    public String toString() {
        return super.toString()+ ", колличество баллов:" + this.getMembershipPoints();
    }

    public String toStringWritefile(){
        return super.toStringWritefile() + FileHandler.DELIMITER + this.getMembershipPoints();
    }
}
