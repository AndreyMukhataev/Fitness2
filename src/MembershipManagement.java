import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader=new Scanner(System.in);;
    private int memberIDmax;
    //Считывание int с консоли
    private int getIntInput(){
        boolean flagToInt= false; // флаг, что число является int
        int res=0;
        while (flagToInt== false){
            if (reader.hasNextInt() ){
                res = reader.nextInt();
                flagToInt = true;
            }
        }
        return res;
    }
    // Прописывание наименование клубов
    private void printClubOptions(){
        System.out.println("1) Club Mercury\n" +
                        "2) Club Neptune\n" +
                        "3) Club Jupiter\n"+
                        "4) Multi Clubs");
    }
    //основное меню
    public int getChoice() {
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================'");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.print("Please select an option (or Enter -1 to quit):");
        return getIntInput();
    }
    //Добавление нового участника клуба
    public String addMembers(LinkedList<Member> m) {
        Member mbr = null;
        Calculator<Integer> cal=new Calculator<Integer>() {
            @Override
            public double calculateFees(Integer clubID) {

                switch (clubID){
                    case 1:
                        return 900.0;
                    case 2:
                        return 950.0;
                    case 3:
                        return 1000.0;
                    default:
                        return -1.0;
                }
            }
        };


        printClubOptions();
        int club= getIntInput();
        double fees = cal.calculateFees(club);

        System.out.println("Введите имя нового пользователя:");
        String name= reader.next();

        if (m.size()!=0) {
            for (Member member : m) {
                if (member.getMemberID() >= memberIDmax) memberIDmax = member.getMemberID() + 1;
            }
        }
        else{
            memberIDmax=1;
        }
        int memberID= memberIDmax ;

        if ((club==1) || (club==2)|| (club==3)){
            mbr= new SingleClubMember('S',memberID, name, fees, club);
        }
        else if (club==4) {
            mbr= new MultiClubMember('M', memberID, name, fees, 100);
        }
        m.add(mbr);
        String mem = mbr.toStringWritefile();
        return mem;
    }
    //Удаление участника из коллекции по идентификатору
    public void removeMember(LinkedList<Member> m){
        if (m.size()!=0) {
            System.out.println("Введите идентификатор пользователя клуба:");
            int memberID = getIntInput();
            for (Member member : m) {
                if (member.getMemberID() == memberID) {
                    m.remove(member);
                }
            }
        }
    }
    // поиск участника в коллекции по идентификатору
    public void printMemberInfo(LinkedList<Member> m){
        if (m.size()!=0) {
            System.out.println("Введите идентификатор пользователя клуба:");
            int memberID = getIntInput() ;
            for (Member member : m) {
                if (member.getMemberID() == memberID) {
                    System.out.println(m.toString());
                }
            }
        }
    }

}
