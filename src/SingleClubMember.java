public class SingleClubMember extends Member  {
    //Идентификатор клуба в который ходит посетитель
    private int club;

    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub) {
        super(pMemberType, pMemberID, pName, pFees);
        this.club = pClub;
    }

    public int getClub() {
        return club;
    }

    public void setClub(int pClub) {
        this.club = club;
    }
    public String getNameClub(){
        String result;
        switch (this.club){
            case 1:
                result= "Club Mercury";
                break;
            case 2:
                result= "Club Neptune";
                break;
            case 3:
                result="Club Jupiter";
            default:
                result= "Не определенно";
        }
        return result;
    }
    @Override
    public String toString() {
        return super.toString()+ ", наименование клуба=" + this.getNameClub();
    }

    public String toStringWritefile(){
        return super.toStringWritefile() + FileHandler.DELIMITER + this.getClub();
    }
}
