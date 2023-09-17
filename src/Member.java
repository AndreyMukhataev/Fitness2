public class Member {
    //тип членства
    private char memberType;
    //Идентификатор членства
    private int memberID;
    //Наименование
    private String name;
    //Членский взнос
    private double fees;



    public Member(char pMemberType, int pMemberID, String pName, double pFees) {
        this.memberType = pMemberType;
        this.memberID = pMemberID;
        this.name = pName;
        this.fees = pFees;
    }

    public char getMemberType() {
        return memberType;
    }

    public String getMemberTypeName(){
        String res;
        switch (this.memberType) {
            case 'S':
                res= "Single club";
                break;
            case 'M':
                res = "Multi club";
                break;
            default:
                res="Тип не определён";
                break;
        }
        return res;
    }
    public void setMemberType(char pMemberType) {
        this.memberType = memberType;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int pMemberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        this.name = name;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double pFees) {
        this.fees = fees;
    }


    @Override
    public String toString() {
        return  "Тип членства: " + this.getMemberTypeName() +
                ", идентификатор посетителя: " + this.getMemberID() +
                ", имя посетителя: " + this.getName() +
                ", размер членского взноса: " + this.getFees() ;
    }
//    Процедура возвращающая строку для запись в файл
    public String toStringWritefile(){
        return  this.getMemberType() + FileHandler.DELIMITER +
                this.getMemberID() + FileHandler.DELIMITER +
                this.getName() + FileHandler.DELIMITER +
                this.getFees();
    }
}
